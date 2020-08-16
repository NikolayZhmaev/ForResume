package net.thumbtack.school.sunday.http;

import mockit.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class TestDownloadInformationPageJMockit {
    @Mocked HttpURLConnection conn;
    @Mocked URL url;

    @Test
    public void testUrl() throws Exception {
        try {
            new DownloadInformationPage().download("moscow");
        } catch (NullPointerException e) {}

        new VerificationsInOrder() {{
             new URL("http://restcountries.eu/rest/v2/capital/moscow?fields=name;currencies");
        }};
    }

    @Test
    public void testDownloadPage() throws Exception {

        InputStream stream = new ByteArrayInputStream("https://somepage texttext".getBytes());

        new Expectations() {{
            url.openConnection(); result = conn;
            conn.getContent();    result = stream;
        }};

        String result = new DownloadInformationPage().download("moskow");
        assertEquals("https://somepage texttext", result);
    }

}

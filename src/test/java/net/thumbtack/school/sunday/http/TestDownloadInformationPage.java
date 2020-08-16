package net.thumbtack.school.sunday.http;

import net.thumbtack.school.sunday.http.jdbc.JdbcCapitalsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DownloadInformationPage.class)
public class TestDownloadInformationPage {

    @Test
    public void testDownloadPage() throws Exception {
        InputStream stream = new ByteArrayInputStream("moscow:[{currencies:[{code:RUB, name:Russian ruble, symbol:ru}],name:Russian Federation}]".getBytes());
        HttpURLConnection http = mock(HttpURLConnection.class);
        when(http.getContent()).thenReturn(stream);
        URL url = mock(URL.class);
        when(url.openConnection()).thenReturn(http);
        PowerMockito.whenNew(URL.class).withAnyArguments().thenReturn(url);

        String result = new DownloadInformationPage().download("moscow");
        assertEquals("moscow:[{currencies:[{code:RUB, name:Russian ruble, symbol:ru}],name:Russian Federation}]", result);
    }

    @Test
    public void testUrlDownloadPage() throws Exception {
        HttpURLConnection http = mock(HttpURLConnection.class);
        URL url = mock(URL.class);
        when(url.openConnection()).thenReturn(http);
        PowerMockito.whenNew(URL.class).withAnyArguments().thenReturn(url);

        try {
            new DownloadInformationPage().download("moscow");
        } catch (NullPointerException e) {
            //ignore
        }
        PowerMockito.verifyNew(URL.class).withArguments("http://restcountries.eu/rest/v2/capital/moscow?fields=name;currencies");
    }
}

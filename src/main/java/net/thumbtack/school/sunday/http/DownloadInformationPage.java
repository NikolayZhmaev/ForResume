package net.thumbtack.school.sunday.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadInformationPage {

    // в этом классе будет реализована закачка необходимой информации
    public String download (String nameOfCapital) throws IOException {
        URL url = new URL("http://restcountries.eu/rest/v2/capital/" + nameOfCapital + "?fields=name;currencies");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();
        try(InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
            BufferedReader buff = new BufferedReader(in)) {
            StringBuilder sb = new StringBuilder();
            String line = buff.readLine();
            sb.append(line);
            return sb.toString();
        }
    }
}

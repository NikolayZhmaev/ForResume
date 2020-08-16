package net.thumbtack.school.sunday.http;

import net.thumbtack.school.sunday.http.jdbc.JdbcCapitalsService;
import net.thumbtack.school.sunday.http.jdbc.JdbcConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NationalCurrencySearch {

    private List<String> capitals = new ArrayList<String>();
    private DownloadInformationPage downloadInformationPage = new DownloadInformationPage();

    // так как в задании не уточняется, результат будем выводить в консоль.
    public static void main(String[] args) throws IOException, SQLException {
        new NationalCurrencySearch(new JdbcCapitalsService());
    }

    public NationalCurrencySearch(JdbcCapitalsService jdbcCapitalsService) throws SQLException, IOException {
        setCapitals(jdbcCapitalsService.getCapitalsFromDataBase()); // получим данные с БД и передадим их для скачки информации

        int number = 1;
        for (String capital :getCapitals()){
            System.out.println(number + ". " + capital + ":" + getDownloadInformationPage().download(capital));
            number++;
        }
    }

    public List<String> getCapitals() {
        return capitals;
    }

    public void setCapitals(List<String> capitals) {
        this.capitals = capitals;
    }

    public DownloadInformationPage getDownloadInformationPage() {
        return downloadInformationPage;
    }

    public void setDownloadInformationPage(DownloadInformationPage downloadInformationPage) {
        this.downloadInformationPage = downloadInformationPage;
    }
}

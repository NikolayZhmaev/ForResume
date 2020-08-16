package net.thumbtack.school.sunday.http.jdbc;

import net.thumbtack.school.online.database.jdbc.JdbcUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcCapitalsService {

    private static List<String> capitals = new ArrayList<String>();

    public  List<String> getCapitalsFromDataBase () throws SQLException {
        JdbcConnection jdbcConnection = new JdbcConnection();
        jdbcConnection.createConnection();

        String getQuery = "select * from capitals";

        try (PreparedStatement stmt = JdbcConnection.getConnection().prepareStatement(getQuery); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                capitals.add(rs.getString("capitals_name"));
            }
        }
        return getCapitals();
    }

    public static List<String> getCapitals() {
        return capitals;
    }

    public static void setCapitals(List<String> capitals) {
        JdbcCapitalsService.capitals = capitals;
    }
}

package academy.belhard.db.reader;

import academy.belhard.entity.FullData;
import academy.belhard.util.ConnectionUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FullDataReader {

    private static final String SELECT_FULL_DATA = "SELECT fl.number, fl.date, fl.time, pl.tale_number, " +
            "CONCAT_WS (' ', pl.brand, pl.model) AS brand_model, pl.capacity, \n" +
            "CONCAT (CONCAT_WS (' ', p.last_name, substr(p.first_name,1,1)),+'.') AS full_name, \n" +
            "CONCAT (p.code, +' (',p.rang,+')') AS code_rang\n" +
            "FROM flights fl\n" +
            "JOIN planes pl ON fl.planes_id = pl.id\n" +
            "JOIN pilots p ON fl.pilots_id = p.id;";

    public static List<FullData> read() {
        List<FullData> result = new ArrayList<>();

        Connection connection = ConnectionUtil.getConnection();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_FULL_DATA)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String flightNumber = resultSet.getString("number");
                Date flightDate = resultSet.getDate("date");
                Time flightTime = resultSet.getTime("time");
                String planeTaleNumber = resultSet.getString("tale_number");
                String planeBrandModel = resultSet.getString("brand_model");
                Integer planeCapacity = resultSet.getInt("capacity");
                String pilotFullName = resultSet.getString("full_name");
                String pilotCodeRang = resultSet.getString("code_rang");

                result.add(new FullData(flightNumber, flightDate, flightTime, planeTaleNumber, planeBrandModel, planeCapacity, pilotFullName, pilotCodeRang));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}

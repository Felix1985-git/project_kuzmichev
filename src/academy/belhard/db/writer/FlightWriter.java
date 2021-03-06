package academy.belhard.db.writer;

import academy.belhard.entity.Flight;
import academy.belhard.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class FlightWriter {

    private static final String INSERT = "INSERT INTO flights (id, planes_id, pilots_id, date, time, number) VALUES(?, ?, ? ,? ,? ,?)";

    public static void write(List<Flight> flights) {
        Connection connection = ConnectionUtil.getConnection();
        System.out.println(String.format(WriterConstants.WRITE_START, "flights"));

        for (Flight flight : flights) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
                statement.setInt(1, flight.getId());
                statement.setInt(2, flight.getPlanesId());
                statement.setInt(3, flight.getPilotsId());
                statement.setDate(4, flight.getDate());
                statement.setTime(5, flight.getTime());
                statement.setString(6, flight.getNumber());

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        flights.forEach(System.out::println);
        System.out.println(String.format(WriterConstants.WRITE_STOP, "flights"));
    }
}
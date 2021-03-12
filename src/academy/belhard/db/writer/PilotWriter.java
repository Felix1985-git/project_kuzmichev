package academy.belhard.db.writer;

import academy.belhard.entity.Pilot;
import academy.belhard.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class PilotWriter {

    private static final String INSERT = "INSERT INTO pilots (id, first_name, last_name, rang, code) VALUES(?, ?, ? ,? ,?)";

    public static void write(List<Pilot> pilots) {
        Connection connection = ConnectionUtil.getConnection();
        System.out.println(String.format(WriterConstants.WRITE_START, "pilots"));

        for (Pilot pilot : pilots) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
                statement.setInt(1, pilot.getId());
                statement.setString(2, pilot.getFirstName());
                statement.setString(3, pilot.getLastName());
                statement.setString(4, pilot.getRang().toString());
                statement.setString(5, pilot.getCode());

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pilots.forEach(System.out::println);
        System.out.println(String.format(WriterConstants.WRITE_STOP, "pilots"));
    }
}

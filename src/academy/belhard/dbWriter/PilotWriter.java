package academy.belhard.dbWriter;

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
        System.out.println("Старт записи в таблицу [pilots]");

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
        System.out.println("Запись в таблицу [pilots] завершена");
    }
}

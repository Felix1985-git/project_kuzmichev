package academy.belhard.db.writer;

import academy.belhard.entity.Plane;
import academy.belhard.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class PlaneWriter {

    private static final String INSERT = "INSERT INTO planes (id, brand, model, capacity, tale_number) VALUES(?, ?, ? ,? ,?)";

    public static void write(List<Plane> planes) {
        Connection connection = ConnectionUtil.getConnection();
        System.out.println(String.format(WriterConstants.WRITE_START, "planes"));

        for (Plane plane : planes) {
            try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
                statement.setInt(1, plane.getId());
                statement.setString(2, plane.getBrand());
                statement.setString(3, plane.getModel());
                statement.setInt(4, plane.getCapacity());
                statement.setString(5, plane.getTaleNumber());

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        planes.forEach(System.out::println);
        System.out.println(String.format(WriterConstants.WRITE_STOP, "planes"));
    }
}
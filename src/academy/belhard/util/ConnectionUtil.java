package academy.belhard.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/kuzmichev_project_db?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "1232164";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}

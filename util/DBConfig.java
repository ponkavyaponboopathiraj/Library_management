package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConfig {
      private static final String URL = "jdbc:postgresql://localhost:5432/library_management";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
}
}

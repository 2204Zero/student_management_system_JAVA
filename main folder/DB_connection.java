import java.sql.Connection;
import java.sql.DriverManager;

public class DB_connection {
    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_management",
                "root",
                "Maya@1979"
            );
            System.out.println("Connected to database!");
        } catch (Exception e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }

        return conn;
    }
}
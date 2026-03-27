import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

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

   

public static void addStudent(int id, String name, int age, String course) {
    
    try {
        Connection conn = getConnection();

        //  NEW CHECK
        if (studentExists(id)) {
            System.out.println("Student with this ID already exists!");
            return;
        }

        String query = "INSERT INTO students VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);
        ps.setString(4, course);

        ps.executeUpdate();

        System.out.println("Student added successfully!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void viewStudents() {
    try {
        Connection conn = getConnection();

        String query = "SELECT * FROM students";
        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String course = rs.getString("course");

            System.out.println(id + " | " + name + " | " + age + " | " + course);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void searchStudent(int searchId) {
    try {
        Connection conn = getConnection();

        String query = "SELECT * FROM students WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, searchId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String course = rs.getString("course");

            System.out.println(id + " | " + name + " | " + age + " | " + course);
        } else {
            System.out.println("Student not found!");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void deleteStudent(int id) {
    try {
        Connection conn = getConnection();

        String query = "DELETE FROM students WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static boolean studentExists(int id) {
    try {
        Connection conn = getConnection();

        String query = "SELECT * FROM students WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        return rs.next(); // true if exists

    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

public static void updateStudent(int id, String name, int age, String course) {
    try {
        Connection conn = getConnection();

        String query = "UPDATE students SET name = ?, age = ?, course = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, course);
        ps.setInt(4, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}


package in.ac.iiitb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String query = "INSERT INTO student(roll, name) values (?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quizdao", "bolleyboll", "password");

            PreparedStatement s = conn.prepareStatement(query);
            s.setInt(1, 1);
            s.setString(2, "Aman Gupta");
            s.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
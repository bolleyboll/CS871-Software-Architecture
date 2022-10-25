import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    private static Connection db = new Connection() {
		
	};

	static final String JDBCDriver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/quizdao";
	static final String USER = "bolleyboll";
	static final String PASS = "password";

    private DBConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			db = DriverManager.getConnection(DB_URL, USER, PASS);
			db.setAutoCommit(false);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
    }

    public static Connection getUniqueInstance() {
        return uniqueInstance;
    }
}
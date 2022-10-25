package in.ac.iiitb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import in.ac.iiitb.dao.impl.StudentDAOImpl;

public class ConnectionFactory {
	public enum TXN_STATUS {
		COMMIT, ROLLBACK
	};

	static final String JDBCDriver = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/quizdao";
	static final String USER = "bolleyboll";
	static final String PASS = "password";

	Connection dbConn;
	Boolean activeConnection;
	StudentDAO studentDAO = null;

	ConnectionFactory() {
		dbConn = null;
		activeConnection = false;
	}

	public void activateConnection() throws Exception {
		if (activeConnection == true)
			throw new Exception("Connection already active");

		System.out.println("Connecting to database...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConn = DriverManager.getConnection(DB_URL, USER, PASS);
			dbConn.setAutoCommit(false);
			activeConnection = true;
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

	public StudentDAO getStudentDAO() throws Exception {
		if (activeConnection == false)
			throw new Exception("Connection not activated...");

		if (studentDAO == null)
			studentDAO = new StudentDAOImpl(dbConn);

		return studentDAO;
	}

	public void deactivateConnection(TXN_STATUS txn_status) {
		// Okay to keep deactivating an already deactivated connection
		activeConnection = false;
		if (dbConn != null) {
			try {
				if (txn_status == TXN_STATUS.COMMIT)
					dbConn.commit();
				else
					dbConn.rollback();

				dbConn.close();
				dbConn = null;

				// Nullify all DAO objects
				studentDAO = null;
			} catch (SQLException ex) {
				// handle any errors
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());
			}
		}
	}
}
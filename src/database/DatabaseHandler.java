package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseHandler {

	private Connection connect = null;

	private final String DATABASE_NAME = "aah-database";
	private final String DATABASE_USER = "UserAAH";
	private final String DATABASE_USERPW = "1234aah";

	private void openDataBase() {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/"
					+ DATABASE_NAME + "?" + "user=" + DATABASE_USER
					+ "&password=" + DATABASE_USERPW);

		} catch (SQLException e) {
			
			e.printStackTrace(System.err);
			
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
            
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
			System.err.println("Message: " + e.getMessage());
		} 

	}

	private void closeDatabase() {
		try {
			if (connect != null) {
				connect.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace(System.err);
			
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
            
		} 
		connect=null;
	}
}

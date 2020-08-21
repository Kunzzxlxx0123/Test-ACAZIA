package connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectPostgreSQL implements ConnectDB{
	
	private static final String url = "jdbc:postgresql://localhost:5432/test-acazia";
	private static final String user = "postgres";
	private static final String password = "root";
	
	@Override
	public Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return null;
		}
	}
}

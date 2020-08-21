package connectdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSQLServer implements ConnectDB{
	
	private static final String url = "jdbc:sqlserver://localhost:1433/test-acazia";
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

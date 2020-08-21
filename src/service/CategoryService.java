package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import connectdb.ConnectDB;
import entities.Category;

public class CategoryService {
	
	private ConnectDB connectDB;
	
	// implement dependency injection
	public CategoryService(ConnectDB connectDB) {
		// TODO Auto-generated constructor stub
		this.connectDB = connectDB;
	}

	public Optional<Category> createCategory(Category category) throws SQLException{
		Connection connection = connectDB.getConnection();
		String sql = "INSERT INTO categories(name, tag) VALUES(?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, category.getName());
		statement.setString(2, category.getTag());
		statement.executeUpdate();
		connection.close();
		return Optional.of(category);
	}
}

package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import connectdb.ConnectDB;
import entities.Product;

public class ProductService {

	private ConnectDB connectDB;

	//implement dependency injection
	public ProductService(ConnectDB connectDB) {
		this.connectDB = connectDB;
	}

	public Optional<List<Product>> getProductByCategoryTag(String categoryTag) throws SQLException {
		String sql = "SELECT * FROM products WHERE products.category_tag = ? ORDER BY products.name ASC";
		Connection connection = connectDB.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, categoryTag);
		ResultSet rs = statement.executeQuery();
		List<Product> products = new ArrayList<Product>();
		connection.close();
		while (rs.next()) {
			products.add(new Product(rs.getString(1), rs.getString(2)));
		}
		return Optional.of(products);
	}

	public Optional<Product> createProduct(Product product) throws SQLException {
		String sql = "INSERT INTO products(name, category_tag) VALUES (?,?)";
		Connection connection = connectDB.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, product.getName());
		statement.setString(2, product.getCategory_tag());
		statement.executeUpdate();
		connection.close();
		return Optional.of(product);
	}
	
}

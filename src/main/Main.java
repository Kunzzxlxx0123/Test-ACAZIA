package main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import connectdb.ConnectDB;
import connectdb.ConnectPostgreSQL;
import entities.Category;
import entities.Product;
import service.CategoryService;
import service.ProductService;

public class Main {
	
	public static ConnectDB connectDB;
	public static CategoryService categoryService;
	public static ProductService productService;
	
	@SuppressWarnings("resource")
	public static void showMenu() {
		while(true) {
			System.out.println("1. Insert category");
			System.out.println("2. Insert product");
			System.out.println("3. Find product by category_tag");
			System.out.println("4. exit");
			System.out.println("Your choice: ");
			
			String categoryTag;
			String choice = new Scanner(System.in).nextLine();
			switch (choice) {
			case "1":
				System.out.println("Category name: ");
				String categoryName = new Scanner(System.in).nextLine();
				System.out.println("Category tag: ");
				categoryTag = new Scanner(System.in).nextLine();
				if(categoryName.isBlank() || categoryTag.isBlank()) {
					System.out.println("Input invalid!");
				} else {
					try {
						categoryService.createCategory(new Category(categoryName, categoryTag))
							.orElseThrow(() -> new RuntimeException());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case "2": 
				System.out.println("Product name: ");
				String productName = new Scanner(System.in).nextLine();
				System.out.println("Category tag: ");
				categoryTag = new Scanner(System.in).nextLine();
				if(productName.isBlank() || categoryTag.isEmpty()) {
					System.out.println("Input invalid!");
				} else {
					try {
						productService.createProduct(new Product(productName, categoryTag))
							.orElseThrow(() -> new RuntimeException());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case "3": 
				System.out.println("Category tag; ");
				categoryTag = new Scanner(System.in).nextLine();
				try {
					List<Product> products = productService.getProductByCategoryTag(categoryTag)
							.orElseThrow(() -> new RuntimeException());
					products.forEach(product -> {
						System.out.println(product);
					});
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "4":
				System.exit(1);
			default:
				System.out.println("Your choice invalid!");
				break;
			}
		}
	}
	public static void main(String[] args) {
		//Using PostgreSQL
		connectDB = new ConnectPostgreSQL();
		
		//implement dependency injection
		categoryService = new CategoryService(connectDB);
		productService = new ProductService(connectDB);
		showMenu();
	}
}

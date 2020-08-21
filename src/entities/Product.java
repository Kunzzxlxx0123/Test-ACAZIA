package entities;

public class Product {

	private String name;
	private String category_tag;

	public Product(String name, String category_tag) {
		super();
		this.name = name;
		this.category_tag = category_tag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory_tag() {
		return category_tag;
	}

	public void setCategory_tag(String category_tag) {
		this.category_tag = category_tag;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", category_tag=" + category_tag + "]";
	}
	

}

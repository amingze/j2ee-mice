
package mice.bean;

import java.util.List;

public class Category {
<<<<<<< HEAD
=======
    private int id;
    private String name;
    private int largeCategoryId;
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544

	private String name;
	private int id;
	List<Product> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public static void main(String[] args) {

	}
}

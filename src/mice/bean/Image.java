package mice.bean;

public class Image {
	String Image;
	Product Product;
	int id;

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product Product) {
		this.Product = Product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

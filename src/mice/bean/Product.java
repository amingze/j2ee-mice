package mice.bean;

public class Product {
	int id;
	String name;
	float price;
	int imageid;

	public int getImageId() {
		return this.imageid;
	}

	public void setImageId(int imageid) {
		this.imageid = imageid;
	}
	
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}

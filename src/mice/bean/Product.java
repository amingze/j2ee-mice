<<<<<<< HEAD
package mice.bean;

import java.util.Date;

import java.util.List;

public class Product {
	private String name;
	private String subTitle;

	private float promotePrice;
	private int stock;
	private Date createDate;
	private Category category;
	private int id;
	private ProductImage firstProductImage;
	private List<ProductImage> productSingleImages;
	private int reviewCount;
	private int saleCount;
	private String edit;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}


	public float getPromotePrice() {
		return promotePrice;
	}

	public void setPromotePrice(float promotePrice) {
		this.promotePrice = promotePrice;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return name;
	}

	public ProductImage getFirstProductImage() {
		return firstProductImage;
	}

	public void setFirstProductImage(ProductImage firstProductImage) {
		this.firstProductImage = firstProductImage;
	}


	public List<ProductImage> getProductSingleImages() {
		return productSingleImages;
	}

	public void setProductSingleImages(List<ProductImage> productSingleImages) {
		this.productSingleImages = productSingleImages;
	}



	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	
	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}
}

/**
 * 

 */
=======
package mice.bean;

public class Product {
	private int id;
	private String name;
	private float price;
	private int imageid;

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
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544

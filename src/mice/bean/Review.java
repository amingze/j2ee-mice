<<<<<<< HEAD
=======
package mice.bean;

/**
 * Review
 */
public class Review {

    private int id;
    private int userId;
    private int productId;
    private String Content;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544

package mice.bean;

import java.util.Date;

public class Review {
	private String content;
	private Date createDate;
	private User user;
	private Product product;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}

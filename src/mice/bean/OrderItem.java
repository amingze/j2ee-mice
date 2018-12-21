
package mice.bean;

public class OrderItem {
<<<<<<< HEAD
	private int number;
	private Product product;
	private Order order;
	private User user;
	private int id;
=======
    private int id;
    private int userId;

    private Product product;
    private int productId;
    private float productPrice;
    private String productName;
    private int number;
    private String status;
    private int orderId;

    public int getProductPrice() {
        return this.orderId;
    }

    public void setProductPrice(int orderId) {
        this.orderId = orderId;
    }

    public int getProductName() {
        return this.orderId;
    }

    public void setProductName(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // 0-订单隐藏 1-收藏夹 2-购物车 3-未付款 4-已付款 5-已发货
    // 6-退款申请 7-退款同意 8-退款失败 9-退款中 10-退款完成
    String remake;

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return this.userId;
    }
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

<<<<<<< HEAD
	public void setOrder(Order order) {
		this.order = order;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
=======
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

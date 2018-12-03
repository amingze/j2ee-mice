package mice.bean;
public  class OrderItem {
    int id;
    int userId;


    Product product;
    int productId;

    int number;
    int status;
    //0-订单隐藏 1-收藏夹 2-购物车 3-未付款 4-已付款 5-已发货 
    //6-退款申请 7-退款同意 8-退款失败 9-退款中 10-退款完成
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

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemake() {
        return this.remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    
}
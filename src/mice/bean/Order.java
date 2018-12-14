package mice.bean;

import java.util.ArrayList;
import java.util.List;

import mice.dao.OrderDAO;

public class Order {

    private int id;
    private int userId;
    private List<Order> orderItem = new ArrayList<>();
    private float total;
    private String datetime;
    private Address address;
    private int addressId;
    private int addressUId;
    private String addressAddress;
    private String addressName;
    private String addressPhone;
    private String status = "未知";

    // 0-订单隐藏 1-收藏夹 2-购物车 3-未付款 4-已付款 5-已发货 6-待评价 7-完成 8-删除
    // 16-退款申请 17-退款同意 18-退款失败 19-退款中 10-退款完成
    public String getStatus() {
        String desc = "未知";
        switch (status) {
        case OrderDAO.waitPay:
            desc = "待付款";
            break;
        case OrderDAO.waitDelivery:
            desc = "待发货";
            break;
        case OrderDAO.waitConfirm:
            desc = "待收货";
            break;
        case OrderDAO.waitReview:
            desc = "等评价";
            break;
        case OrderDAO.finish:
            desc = "完成";
            break;
        case OrderDAO.delete:
            desc = "刪除";
            break;

        default:
            desc = "未知";
        }
        return desc;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Order> getOrderItem() {
        return this.orderItem;
    }

    public void setOrderItem(List<Order> orderItem) {
        this.orderItem = orderItem;
    }

    public String getDatetime() {
        return this.datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus(String status) {
        return this.status;
    }

    /**
     * @return int return the addressId
     */
    public int getAddressId() {
        return addressId;
    }

    /**
     * @param addressId the addressId to set
     */
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    /**
     * @return int return the addressUId
     */
    public int getAddressUId() {
        return addressUId;
    }

    /**
     * @param addressUId the addressUId to set
     */
    public void setAddressUId(int addressUId) {
        this.addressUId = addressUId;
    }

    /**
     * @return String return the addressAddress
     */
    public String getAddressAddress() {
        return addressAddress;
    }

    /**
     * @param addressAddress the addressAddress to set
     */
    public void setAddressAddress(String addressAddress) {
        this.addressAddress = addressAddress;
    }

    /**
     * @return String return the addressPhone
     */
    public String getAddressPhone() {
        return addressPhone;
    }

    /**
     * @param addressPhone the addressPhone to set
     */
    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    /**
     * @return String return the addressName
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * @param addressName the addressName to set
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

}
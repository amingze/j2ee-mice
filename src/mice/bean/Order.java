package mice.bean;

import java.util.ArrayList;
import java.util.List;
public class Order {

    int id;
    int userId;
    List<Order> orderItem = new ArrayList<>();
    String datetime;
    Address address;
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
}
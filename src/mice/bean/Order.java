package mice.bean;

import java.util.ArrayList;
import java.util.List;

public class Order {

    int id;
    int userId;
    List<Order> orderItem = new ArrayList<>();
    String datetime;
    Address address;
    int status;
    // 0-订单隐藏 1-收藏夹 2-购物车 3-未付款 4-已付款 5-已发货 6-待评价 7-完成 8-删除

    // 16-退款申请 17-退款同意 18-退款失败 19-退款中 10-退款完成
    public String getStatus() {
        String desc = "未知";
        switch (status) {
        case 3:
            desc = "待付款";
            break;
        case 4:
            desc = "待发货";
            break;
        case 5:
            desc = "待收货";
            break;
        case 6:
            desc = "待评价";
            break;
        case 7:
            desc = "完成";
            break;
        case 8:
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
}
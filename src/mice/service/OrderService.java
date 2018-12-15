package mice.service;

import java.util.ArrayList;
import java.util.List;

import mice.bean.Address;
import mice.bean.Order;
import mice.bean.OrderItem;
import mice.bean.Product;
import mice.bean.User;
import mice.dao.OrderDAO;
import mice.dao.OrderItemDAO;
import mice.dao.UserDAO;
import mice.util.NumCheck;

/**
 * OrderService
 */
public class OrderService {
    protected static OrderItemDAO orderItemDAO = new OrderItemDAO();

    public static List<OrderItem> getCartList(User userBean) {
        List<OrderItem> beans = orderItemDAO.getCart(userBean.getId());
        return beans;
    }

    public static void getTotal() {

    }

    public static void addCart(int pid, int uid, int num) {

        if (NumCheck.IsNoPositive(num)) {// 不是正数直接返回
            return;
        }

        OrderItem orderItem = new OrderItem();
        if (orderItemDAO.isNoExistCartByPId(pid)) {// 判断购物车是否存在要加入的商品
            orderItem.setUserId(uid); // 不存在则添加
            orderItem.setProductId(pid);
            orderItem.setNumber(num);
            orderItem.setStatus(OrderDAO.waitPay);
            orderItemDAO.add(orderItem);
        } else {
            orderItem = orderItemDAO.getByPId(pid);
            // 存在则在原先购物车的数量上加上要加入的数量
            int oiNum = orderItemDAO.get(orderItem.getId()).getNumber() + num;
            orderItem.setNumber(oiNum);
            orderItemDAO.updata(orderItem);
        }
        return;
    }

    public static void addCart(String pid, int uid, String num) {
        int int_pid = Integer.parseInt(pid);
        int int_num = Integer.parseInt(num);
        int int_uid = uid;
        addCart(int_pid, int_num, int_uid);
    }

    public static void addCart(String pid, String uid, String num) {
        int int_uid = Integer.parseInt(num);
        addCart(pid, int_uid, uid);
    }

    public static void addAmount(String oiId) {
        int id = Integer.parseInt(oiId);
        addAmount(id);
    }

    public static void addAmount(int oiId) {
        if (orderItemDAO.get(oiId).getNumber() >= 1)
            orderItemDAO.changeAmount(oiId, orderItemDAO.get(oiId).getNumber() + 1);
    }

    public static void reduceAmount(String oiId) {
        int id = Integer.parseInt(oiId);
        addAmount(id);
    }

    public static void reduceAmount(int oiId) {
        if (orderItemDAO.get(oiId).getNumber() > 1)
            orderItemDAO.changeAmount(oiId, orderItemDAO.get(oiId).getNumber() - 1);
    }

    public static void changeAmount(String oiId, String oiAmount) {
        int id = Integer.parseInt(oiId);
        int num = Integer.parseInt(oiAmount);
        changeAmount(id, num);
    }

    public static void changeAmount(int oiId, int num) {
        if (orderItemDAO.get(oiId).getNumber() >= 1)
            orderItemDAO.changeAmount(oiId, num);
    }

    public static void deleteCart(String oiId) {
        int id = Integer.parseInt(oiId);
        deleteCart(id);
    }

    public static void deleteCart(int oiId) {
        if (orderItemDAO.isExistCartByOIId(oiId)) {
            orderItemDAO.delete(oiId);
        }
    }

    public static void changeOrderItemsStatus(String[] orderItemsId, String status) {
        for (String orderItem : orderItemsId) {
            int oi = Integer.parseInt(orderItem);
            changeOrderItemStatus(oi, status);
        }
    }

    public static void changeOrderItemStatus(int orderItemId, String status) {
        OrderItemDAO.changeStatus(orderItemId, status);
    }

    public static Order createOrder(int userId, Address addressBean) {
        Order bean = new Order();
        bean.setUserId(userId);
        bean.setAddressName(addressBean.getName());
        bean.setAddressAddress(addressBean.getAddress());
        bean.setAddressPhone(addressBean.getPhone());
        OrderDAO.add(bean);
        return bean;
    }

    public static Order createOrder(User userBean, Address addressBean) {

        return createOrder(userBean.getId(), addressBean);
    }

    public static void changeOrderItemOId(int orderItemId, int orderId) {
        OrderItem oii = orderItemDAO.get(orderItemId);
        oii.setOrderId(orderId);
        orderItemDAO.updata(oii);
    }

    public static void changeOrderItemsOId(String[] orderItemIds, int orderId) {
        for (String orderItemId : orderItemIds) {
            int oiId = Integer.parseInt(orderItemId);
            changeOrderItemOId(oiId, orderId);
        }
    }

    public static float totalPrice(Order orderBean) {
        return totalPrice(orderItemDAO.getByOrder(orderBean.getId()));
    }

    public static float totalPrice(List<OrderItem> orderItems) {
        float total = 0;
        for (OrderItem orderItem : orderItems) {
            total += orderItem.getNumber() * orderItem.getProductPrice();
        }
        return total;
    }

    // public static float buy(int userId, String[] orderItemsId) {

    // // return totalPrice(order);

    // }

    public static void status(int orderId, String status) {
        OrderDAO.changeStatus(orderId, status);
    }

    public static List<List<OrderItem>> order(int userId) {

        return OrderDAO.listByUser(userId);
    }

    public static List<List<OrderItem>> list() {

        return OrderDAO.list();
    }

    public static void main(String[] args) {

    }

}
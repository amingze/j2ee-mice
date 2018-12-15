package mice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mice.bean.Order;
import mice.bean.OrderItem;
import mice.bean.Product;
import mice.util.DBUtil;

public class OrderDAO {
    protected static ProductDAO productDAO = new ProductDAO();
    protected static OrderItemDAO orderItemDAO = new OrderItemDAO();
    protected static OrderDAO orderDAO = new OrderDAO();

    public static final String waitPay = "waitPay";
    public static final String waitDelivery = "waitDelivery";
    public static final String waitConfirm = "waitConfirm";
    public static final String waitReview = "waitReview";
    public static final String finish = "finish";
    public static final String delete = "delete";

    public static Order get(int id) {
        String sql = "SELECT * FROM `order` where `id` = ? ";
        Order bean = new Order();
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            bean.setId(rs.getInt("id"));
            bean.setUserId(rs.getInt("u_id"));
            bean.setAddressAddress(rs.getString("a_address"));
            bean.setAddressId(rs.getInt("a_id"));
            bean.setAddressName(rs.getString("a_name"));
            bean.setAddressPhone(rs.getString("a_phone"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static void add(Order bean) {
        String sql = "INSERT INTO `mice`.`order` (`id`, `u_id`, `datetime`, `a_id`, `a_name`, `a_address`, `a_phone`) VALUES (NULL, ?, CURRENT_TIMESTAMP, ?, ?, ?, ?);";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, bean.getUserId());
            ps.setInt(2, bean.getAddressId());
            ps.setString(3, bean.getAddressName());
            ps.setString(4, bean.getAddressAddress());
            ps.setString(5, bean.getAddressPhone());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                bean.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int createOrder() {
        int id = 0;
        String sql = "INSERT INTO `mice`.`order` (`id`, `datetime`,`status`) VALUES (null,null,3);";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;

    }

    public void setTotal(float total) {
        String sql = "UPDATE  `mice`.`Order` SET  `total` =  ?WHERE  `Order`.`id` =?;";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setFloat(1, total);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void updata(Order bean) {
        String sql = "UPDATE  `mice`.`order` SET  `u_id`=? WHERE  `order`.`id` =?;";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, bean.getUserId());
            ps.setFloat(2, bean.getId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<List<OrderItem>> listByUser(int userId) {
        List<List<OrderItem>> beans = new ArrayList<>();
        String sql = "SELECT * FROM `orderitem` where `u_id` = ?";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                List<OrderItem> bean = new ArrayList<OrderItem>();
                bean = orderItemDAO.getByOrder(id);
                beans.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beans;
    }

    public static List<List<OrderItem>> list() {
        List<List<OrderItem>> beans = new ArrayList<>();
        String sql = "SELECT * FROM `orderitem` ";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                List<OrderItem> bean = new ArrayList<OrderItem>();
                bean = orderItemDAO.getByOrder(id);
                beans.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beans;
    }

    public static void changeStatus(int id, String status) {
        String sql = "UPDATE  `mice`.`orderitem` SET  `status` =  ? WHERE  `orderitem`.`o_id` =?;";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<List<OrderItem>> order = new ArrayList<>();
        order = orderDAO.listByUser(16);

        for (List<OrderItem> beans : order) {
            for (OrderItem bean : beans)
                System.out.println("bean:~" + bean.getProductId());
        }
    }
}

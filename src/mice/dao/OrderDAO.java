
package mice.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mice.bean.Order;
import mice.bean.User;
import mice.util.DBUtil;
import mice.util.DateUtil;

public class OrderDAO {
<<<<<<< HEAD
=======
    protected static ProductDAO productDAO = new ProductDAO();
    protected static OrderItemDAO orderItemDAO = new OrderItemDAO();
    protected static OrderDAO orderDAO = new OrderDAO();

>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544
    public static final String waitPay = "waitPay";
    public static final String waitDelivery = "waitDelivery";
    public static final String waitConfirm = "waitConfirm";
    public static final String waitReview = "waitReview";
    public static final String finish = "finish";
    public static final String delete = "delete";

<<<<<<< HEAD
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from Order_";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    public void add(Order bean) {

        String sql = "insert into order_ values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            ps.setString(1, bean.getOrderCode());
            ps.setString(2, bean.getAddress());
            ps.setString(3, bean.getPost());
            ps.setString(4, bean.getReceiver());
            ps.setString(5, bean.getMobile());
            ps.setString(6, bean.getUserMessage());

            ps.setTimestamp(7, DateUtil.d2t(bean.getCreateDate()));
            ps.setTimestamp(8, DateUtil.d2t(bean.getPayDate()));
            ps.setTimestamp(9, DateUtil.d2t(bean.getDeliveryDate()));
            ps.setTimestamp(10, DateUtil.d2t(bean.getConfirmDate()));
            ps.setInt(11, bean.getUser().getId());
            ps.setString(12, bean.getStatus());

            ps.executeUpdate();

=======
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
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Order bean) {

        String sql = "update order_ set address= ?, post=?, receiver=?,mobile=?,userMessage=? ,createDate = ? , payDate =? , deliveryDate =?, confirmDate = ? , orderCode =?, uid=?, status=? where id = ?";
        try (Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            ps.setString(1, bean.getAddress());
            ps.setString(2, bean.getPost());
            ps.setString(3, bean.getReceiver());
            ps.setString(4, bean.getMobile());
            ps.setString(5, bean.getUserMessage());
            ps.setTimestamp(6, DateUtil.d2t(bean.getCreateDate()));
            ;
            ps.setTimestamp(7, DateUtil.d2t(bean.getPayDate()));
            ;
            ps.setTimestamp(8, DateUtil.d2t(bean.getDeliveryDate()));
            ;
            ps.setTimestamp(9, DateUtil.d2t(bean.getConfirmDate()));
            ;
            ps.setString(10, bean.getOrderCode());
            ps.setInt(11, bean.getUser().getId());
            ps.setString(12, bean.getStatus());
            ps.setInt(13, bean.getId());
            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from Order_ where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Order get(int id) {
        Order bean = new Order();

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from Order_ where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                String orderCode = rs.getString("orderCode");
                String address = rs.getString("address");
                String post = rs.getString("post");
                String receiver = rs.getString("receiver");
                String mobile = rs.getString("mobile");
                String userMessage = rs.getString("userMessage");
                String status = rs.getString("status");
                int uid = rs.getInt("uid");
                Date createDate = DateUtil.t2d(rs.getTimestamp("createDate"));
                Date payDate = DateUtil.t2d(rs.getTimestamp("payDate"));
                Date deliveryDate = DateUtil.t2d(rs.getTimestamp("deliveryDate"));
                Date confirmDate = DateUtil.t2d(rs.getTimestamp("confirmDate"));

                bean.setOrderCode(orderCode);
                bean.setAddress(address);
                bean.setPost(post);
                bean.setReceiver(receiver);
                bean.setMobile(mobile);
                bean.setUserMessage(userMessage);
                bean.setCreateDate(createDate);
                bean.setPayDate(payDate);
                bean.setDeliveryDate(deliveryDate);
                bean.setConfirmDate(confirmDate);
                User user = new UserDAO().get(uid);
                bean.setUser(user);
                bean.setStatus(status);

                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public List<Order> list() {
        return list(0, Short.MAX_VALUE);
    }

<<<<<<< HEAD
    public List<Order> list(int start, int count) {
        List<Order> beans = new ArrayList<Order>();

        String sql = "select * from Order_ order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

=======
    public static List<List<OrderItem>> listByUser(int userId) {
        List<List<OrderItem>> beans = new ArrayList<>();
        String sql = "SELECT * FROM `orderitem` where `u_id` = ?";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, userId);
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order bean = new Order();
                String orderCode = rs.getString("orderCode");
                String address = rs.getString("address");
                String post = rs.getString("post");
                String receiver = rs.getString("receiver");
                String mobile = rs.getString("mobile");
                String userMessage = rs.getString("userMessage");
                String status = rs.getString("status");
                Date createDate = DateUtil.t2d(rs.getTimestamp("createDate"));
                Date payDate = DateUtil.t2d(rs.getTimestamp("payDate"));
                Date deliveryDate = DateUtil.t2d(rs.getTimestamp("deliveryDate"));
                Date confirmDate = DateUtil.t2d(rs.getTimestamp("confirmDate"));
                int uid = rs.getInt("uid");

                int id = rs.getInt("id");
                bean.setId(id);
                bean.setOrderCode(orderCode);
                bean.setAddress(address);
                bean.setPost(post);
                bean.setReceiver(receiver);
                bean.setMobile(mobile);
                bean.setUserMessage(userMessage);
                bean.setCreateDate(createDate);
                bean.setPayDate(payDate);
                bean.setDeliveryDate(deliveryDate);
                bean.setConfirmDate(confirmDate);
                User user = new UserDAO().get(uid);
                bean.setUser(user);
                bean.setStatus(status);
                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }

<<<<<<< HEAD
    public List<Order> list(int uid, String status) {
        return list(uid, status, 0, Short.MAX_VALUE);
    }

    public List<Order> list(int uid, String status_s, int start, int count) {
        List<Order> beans = new ArrayList<Order>();

        String sql = "select * from Order_ where uid = ? and status != ? order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            ps.setInt(1, uid);
            ps.setString(2, status_s);
            ps.setInt(3, start);
            ps.setInt(4, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order bean = new Order();
                String orderCode = rs.getString("orderCode");
                String address = rs.getString("address");
                String post = rs.getString("post");
                String receiver = rs.getString("receiver");
                String mobile = rs.getString("mobile");
                String userMessage = rs.getString("userMessage");
                String status = rs.getString("status");
                Date createDate = DateUtil.t2d(rs.getTimestamp("createDate"));
                Date payDate = DateUtil.t2d(rs.getTimestamp("payDate"));
                Date deliveryDate = DateUtil.t2d(rs.getTimestamp("deliveryDate"));
                Date confirmDate = DateUtil.t2d(rs.getTimestamp("confirmDate"));

                int id = rs.getInt("id");
                bean.setId(id);
                bean.setOrderCode(orderCode);
                bean.setAddress(address);
                bean.setPost(post);
                bean.setReceiver(receiver);
                bean.setMobile(mobile);
                bean.setUserMessage(userMessage);
                bean.setCreateDate(createDate);
                bean.setPayDate(payDate);
                bean.setDeliveryDate(deliveryDate);
                bean.setConfirmDate(confirmDate);
                User user = new UserDAO().get(uid);
                bean.setStatus(status);
                bean.setUser(user);
                beans.add(bean);
            }
        } catch (SQLException e) {
=======
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
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544

            e.printStackTrace();
        }
        return beans;
    }

}

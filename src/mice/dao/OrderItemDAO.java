package mice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mice.bean.Order;
import mice.bean.OrderItem;
import mice.bean.Product;
import mice.bean.User;
import mice.util.DBUtil;

public class OrderItemDAO {
	protected static ProductDAO productDAO = new ProductDAO();

	public static void add(OrderItem bean) {
		String sql = "INSERT INTO `mice`.`orderitem` (`id`, `u_id`, `number`,`status`,`p_id`) VALUES (null,?,?,?,?);";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {

			ps.setInt(1, bean.getUserId());
			ps.setInt(2, bean.getNumber());
			ps.setString(3, bean.getStatus());
			ps.setInt(4, bean.getProductId());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				bean.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete(int id) {
		String sql = "DELETE FROM `mice`.`orderitem` WHERE `orderitem`.`id` = ?";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updata(OrderItem bean) {
		String sql = "UPDATE  `mice`.`orderitem` SET  `u_id` =  ?, `p_id` = ?, `number` = ?,`status`=? WHERE  `orderitem`.`id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, bean.getUserId());
			ps.setInt(2, bean.getProductId());
			ps.setInt(3, bean.getNumber());
			ps.setString(4, bean.getStatus());
			ps.setInt(5, bean.getId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static OrderItem get(int id) {
		String sql = "SELECT * FROM `orderitem` where id = ? ";
		OrderItem bean = new OrderItem();
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			try {
				ps.setInt(1, id);
				ResultSet eq = ps.executeQuery();
				if (eq.next()) {
					bean.setId(id);
					bean.setUserId(eq.getInt("u_id"));
					bean.setProductId(eq.getInt("p_id"));
					bean.setOrderId(eq.getInt("o_id"));
					bean.setNumber(eq.getInt("number"));
					bean.setNumber(eq.getInt("status"));
					bean.setProduct(productDAO.get(eq.getInt("p_id")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return bean;
	}

	public static OrderItem getByPId(int pid) {
		String sql = "SELECT * FROM `orderitem` where `p_id` = ? ";
		OrderItem bean = new OrderItem();
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			try {
				ps.setInt(1, pid);
				ResultSet eq = ps.executeQuery();
				if (eq.next()) {
					bean.setId(eq.getInt("id"));
					bean.setProductId(pid);
					bean.setUserId(eq.getInt("u_id"));
					bean.setNumber(eq.getInt("number"));
					bean.setStatus(eq.getString("status"));
					bean.setOrderId(eq.getInt("o_id"));
					bean.setProduct(productDAO.get(pid));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return bean;
	}

	public static List<OrderItem> getListByUserId(int UserId) {
		String sql = "SELECT *  FROM `orderitem` WHERE `u_id` = ?";
		List<OrderItem> beans = new ArrayList<>();

		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, UserId);
			ResultSet eq = ps.executeQuery();
			while (eq.next()) {
				OrderItem bean = new OrderItem();
				bean.setId(eq.getInt("id"));
				bean.setUserId(eq.getInt("u_id"));
				bean.setNumber(eq.getInt("number"));
				bean.setStatus(eq.getString("status"));
				int productId = eq.getInt("p_id");
				bean.setProductId(productId);
				bean.setProduct(productDAO.get(productId));
				beans.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beans;
	}

	public static List<OrderItem> getCart(int id) {
		String sql = "SELECT *  FROM `orderitem` WHERE `u_id` = ? and `status` =2";
		List<OrderItem> beans = new ArrayList<>();

		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet eq = ps.executeQuery();
			while (eq.next()) {
				OrderItem bean = new OrderItem();
				bean.setId(eq.getInt("id"));
				bean.setUserId(eq.getInt("u_id"));
				bean.setNumber(eq.getInt("number"));
				bean.setStatus(eq.getString("status"));
				int productId = eq.getInt("p_id");
				bean.setProductId(productId);
				bean.setProduct(productDAO.get(productId));
				beans.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beans;
	}

	public static void changeAmount(int id, int num) {

		String sql = "UPDATE  `mice`.`orderitem` SET  `number` =  ? WHERE  `orderitem`.`id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, num);
			ps.setInt(2, id);

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void setOrder(int orderItemId, int orderId) {
		String sql = "UPDATE  `mice`.`orderitem` SET  `o_id` =  ?, `status`=? WHERE  `orderitem`.`id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, orderId);
			ps.setInt(2, 3);
			ps.setInt(3, orderItemId);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<OrderItem> getByOrder(int orderId) {
		String sql = "SELECT *  FROM `orderitem` WHERE `o_id` = ?";
		List<OrderItem> beans = new ArrayList<>();

		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, orderId);
			ResultSet eq = ps.executeQuery();
			while (eq.next()) {
				OrderItem bean = new OrderItem();
				bean.setId(eq.getInt("id"));
				bean.setUserId(eq.getInt("u_id"));
				bean.setNumber(eq.getInt("number"));
				bean.setStatus(eq.getString("status"));
				int productId = eq.getInt("p_id");
				bean.setProductId(productId);
				bean.setProduct(productDAO.get(productId));
				beans.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beans;
	}

	public static void changeStatus(int orderId, String status) {
		String sql = "UPDATE  `mice`.`orderitem` SET  `status` =  ? WHERE  `orderitem`.`o_id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setString(1, status);
			ps.setInt(2, orderId);
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isExistCartByPId(int pId) {
		String sql = "SELECT *  FROM `orderitem` WHERE `p_id` = ? and `status`=?";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, pId);
			ps.setInt(2, 2);
			ResultSet eq = ps.executeQuery();
			if (eq.next())
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isExistCartByOIId(int oIId) {
		String sql = "SELECT *  FROM `orderitem` WHERE `id` = ? and `status`=?";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, oIId);
			ps.setInt(2, 2);
			ResultSet eq = ps.executeQuery();
			if (eq.next())
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isNoExistCartByOIId(int orderId) {

		return !isExistCartByOIId(orderId);
	}

	public static boolean isNoExistCartByPId(int orderId) {

		return !isExistCartByPId(orderId);
	}

	public static void main(String[] args) {
		// OrderItemDAO.changeAmount(1,2);
		// float total = 0;
		// OrderItem orderItem = OrderItemDAO.get(5);
		// System.out.println(total += orderItem.getAmount() *
		// orderItem.getProduct().getPrice());
		// System.out.println(isExistCartByOIId(29));
		delete(14);
		//
		// System.out.println( getList(15).get(1).getProductId());
	}
}

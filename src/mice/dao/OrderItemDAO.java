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

public class OrderItemDAO {
	public static void add(OrderItem bean) {
		String sql = "INSERT INTO `mice`.`orderitem` (`id`, `u_id`, `number`,`status`,`p_id`) VALUES (null,?,?,?,?);";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {

            ps.setInt(1, bean.getUserId());
            ps.setInt(2, bean.getAmount());
            ps.setInt(3, bean.getStatus());
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
        String sql = "UPDATE  `mice`.`orderitem` SET  `u_id` =  ?, `p_id` = ?, `number` = ?,`status`=?,WHERE  `orderitem`.`id` =?;";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, bean.getUserId());
            ps.setInt(2, bean.getProductId());
            ps.setInt(3, bean.getAmount());
            ps.setInt(3, bean.getStatus());
            ps.setInt(4, bean.getId());
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
					
					bean.setAmount(eq.getInt("number"));
					bean.setStatus(eq.getInt("status"));
					// bean.setRemake(remake);
					bean.setProduct(ProductDAO.get(eq.getInt("p_id")));
					
					// bean.setProductId();
					//TODO
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return bean;

	}
	public static List<OrderItem> getList(int id) {
		String sql="SELECT *  FROM `orderitem` WHERE `u_id` = ?";
		List<OrderItem> beans=new ArrayList<>();
		
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet eq = ps.executeQuery();
			while(eq.next()){
				OrderItem bean=new OrderItem();
				bean.setId(eq.getInt("id"));
				bean.setUserId(eq.getInt("u_id"));
				bean.setAmount(eq.getInt("number"));
				bean.setStatus(eq.getInt("status"));
				int productId=eq.getInt("p_id");
				bean.setProductId(productId);
				bean.setProduct(ProductDAO.get(productId));
				beans.add(bean);
			}
		}catch (Exception e) {
				e.printStackTrace();
		}
		return beans;
	}

	public static List<OrderItem> getCart(int id) {
		String sql="SELECT *  FROM `orderitem` WHERE `u_id` = ? and `status` =2";
		List<OrderItem> beans=new ArrayList<>();
		
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet eq = ps.executeQuery();
			while(eq.next()){
				OrderItem bean=new OrderItem();
				bean.setId(eq.getInt("id"));
				bean.setUserId(eq.getInt("u_id"));
				bean.setAmount(eq.getInt("number"));
				bean.setStatus(eq.getInt("status"));
				int productId=eq.getInt("p_id");
				bean.setProductId(productId);
				bean.setProduct(ProductDAO.get(productId));
				beans.add(bean);
			}
		}catch (Exception e) {
				e.printStackTrace();
		}
		return beans;
	}



	public static void changeAmount(int id,int num){
		
		String sql = "UPDATE  `mice`.`orderitem` SET  `number` =  ? WHERE  `orderitem`.`id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, num);
			ps.setInt(2, id);

			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public static void setOrder(int orderId , int orderItemId) {
		String sql = "UPDATE  `mice`.`orderitem` SET  `o_id` =  ?, `status`=? WHERE  `orderitem`.`id` =?;";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, orderItemId);
            ps.setInt(2, 3);
            ps.setInt(3, orderId);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	public static List<OrderItem> getByOrder(int orderId) {
		String sql="SELECT *  FROM `orderitem` WHERE `o_id` = ?";
		List<OrderItem> beans=new ArrayList<>();
		
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, orderId);
			ResultSet eq = ps.executeQuery();
			while(eq.next()){
				OrderItem bean=new OrderItem();
				bean.setId(eq.getInt("id"));
				bean.setUserId(eq.getInt("u_id"));
				bean.setAmount(eq.getInt("number"));
				bean.setStatus(eq.getInt("status"));
				int productId=eq.getInt("p_id");
				bean.setProductId(productId);
				bean.setProduct(ProductDAO.get(productId));
				beans.add(bean);
			}
		}catch (Exception e) {
				e.printStackTrace();
		}
		return beans;
	}

	public static void changeStatus(int orderId,int status){
        String sql = "UPDATE  `mice`.`orderitem` SET  `status` =  ? WHERE  `orderitem`.`o_id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, status);
			ps.setInt(2, orderId);
			ps.execute();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	// public static Boolean isExist(int id) {
	// 	String sql = "SELECT * FROM `Product` where id = ? ";
	// 	try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
	// 		try {
	// 			ps.setInt(1, id);
	// 			ResultSet eq = ps.executeQuery();
	// 			if (eq.next())
	// 				return true;
	// 			else
	// 				return false;
	// 		} catch (Exception e) {
	// 			// TODO Auto-generated catch block
	// 			e.printStackTrace();
	// 		}

	// 	} catch (SQLException e1) {
	// 		// TODO Auto-generated catch block
	// 		e1.printStackTrace();
	// 	}

	// 	return false;

	// }

	// public static void delete(int id) {
	// 	String sql = "DELETE FROM `mice`.`Product` WHERE `Product`.`id` = ?";
	// 	if (isExist(id)) {
	// 		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
	// 			ps.setInt(1, id);
	// 			ps.execute();
	// 		} catch (Exception e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
	// }

	// public static void updata(Product bean) {
	// 	String sql = "UPDATE  `mice`.`Product` SET  `name` =  ?,price=? WHERE  `Product`.`id` =?;";
	// 	try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
	// 		ps.setString(1, bean.getName());
	// 		ps.setFloat(2, bean.getPrice());
	// 		ps.setInt(3, bean.getId());
	// 		ps.execute();

	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}

	// }

	// public static List<Product> get(String name) {
	// 	String sql = "SELECT * FROM `Product` where name like ? ";
	// 	List<Product> beans = new ArrayList<Product>();
	// 	try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql);) {
	// 		ps.setString(1, "%" + name + "%");
	// 		ResultSet rs = ps.executeQuery();
	// 		while (rs.next()) {
	// 			Product bean = new Product();
	// 			bean.setId(rs.getInt("id"));
	// 			bean.setName(rs.getString("name"));
	// 			bean.setPrice(Float.parseFloat(rs.getString("price")));
	// 			beans.add(bean);
	// 			System.out.println(rs.getString("name"));
	// 		}

	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}

	// 	return beans;
	// }

	// public static List<Product> total() {
	// 	String sql = "SELECT * FROM `Product`";
	// 	List<Product> beans = new ArrayList<Product>();

	// 	try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql);) {
	// 		ResultSet rs = ps.executeQuery();
	// 		while (rs.next()) {
	// 			Product bean = new Product();
	// 			bean.setId(rs.getInt("id"));
	// 			bean.setName(rs.getString("name"));
	// 			bean.setPrice(Float.parseFloat(rs.getString("price")));
	// 			beans.add(bean);
	// 		}

	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}

	// 	return beans;
	// }

	// public static void main(String[] args) {
	// 	List<Product> Product = OrderDAO.get("a");
	// 	for (Product g : Product) {
	// 		System.out.println(g.getName());
	// 	}
	// }
	public static void main(String[] args) {
		// OrderItemDAO.changeAmount(1,2); 
		float total=0;
		OrderItem orderItem=OrderItemDAO.get(5);
		System.out.println(total+=orderItem.getAmount()*orderItem.getProduct().getPrice()); 
		// 
		// System.out.println( getList(15).get(1).getProductId());
	}
}

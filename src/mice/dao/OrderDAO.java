package mice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mice.bean.Order;
import mice.bean.Product;
import mice.util.DBUtil;

public class OrderDAO {

	// public static void updata(Order bean) {
	// 	String sql = "UPDATE  `mice`.`Order` SET  `name` =  ?,price=? WHERE  `Order`.`id` =?;";
	// 	try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
	// 		ps.setString(1, bean.getName());
	// 		ps.setFloat(2, bean.getPrice());
	// 		ps.setInt(3, bean.getId());
	// 		ps.execute();
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}
	// }

    public int createOrder() {
        int id=0;
        String sql = "INSERT INTO `mice`.`order` (`id`, `datetime`) VALUES (null,null);";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id=rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;

    }

	public void setTotal(float total){
		String sql = "UPDATE  `mice`.`Order` SET  `total` =  ?WHERE  `Order`.`id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setFloat(1,total);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// public static void add(Order bean) {

	// 	String sql = "INSERT INTO `mice`.`order` (`id`, `u_id`, `number`,`status`,`p_id`) VALUES (null,?,?,?,?);";
	// 	try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {

    //         ps.setInt(1, bean.getUserId());
    //         ps.setInt(2, bean.getNumber());
    //         ps.setInt(3, bean.getStatus());
    //         ps.setInt(4, bean.getProductId());
	// 		ps.execute();
	// 		ResultSet rs = ps.getGeneratedKeys();
	// 		if (rs.next()) {
	// 			bean.setId(rs.getInt(1));
	// 		}
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}

	// }

	// public static List<Order> getList(int id) {
	// 	String sql="SELECT *  FROM `order` WHERE `u_id` = ?";
	// 	List<Order> beans=new ArrayList<>();
		
	// 	try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
	// 		ps.setInt(1, id);
	// 		ResultSet eq = ps.executeQuery();
	// 		while(eq.next()){
	// 			Order bean=new Order();
	// 			bean.setId(eq.getInt("id"));
	// 			bean.setUserId(eq.getInt("u_id"));
	// 			bean.setNumber(eq.getInt("number"));
	// 			bean.setStatus(eq.getInt("status"));
	// 			bean.setProductId(eq.getInt("p_id"));
	// 			bean.setProduct(ProductDAO.get(bean.getProductId()));
				
	// 			beans.add(bean);
	// 		}
	// 	}catch (Exception e) {
	// 			e.printStackTrace();
	// 	}
	// 	return beans;
	// }
	
	// public static Product get(int id) {
	// 	String sql = "SELECT * FROM `Product` where id = ? ";
	// 	Product product = new Product();
	// 	try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
	// 		try {
	// 			ps.setInt(1, id);
	// 			ResultSet eq = ps.executeQuery();
	// 			if (eq.next()) {
	// 				product.setId(id);
	// 				product.setName(eq.getString("name"));
	// 				product.setPrice(eq.getFloat("price"));
	// 			}

	// 		} catch (Exception e) {
	// 			// TODO Auto-generated catch block
	// 			e.printStackTrace();
	// 		}

	// 	} catch (SQLException e1) {
	// 		// TODO Auto-generated catch block
	// 		e1.printStackTrace();
	// 	}

	// 	return product;

	// }

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

	public static void updata(Product bean) {
		String sql = "UPDATE  `mice`.`Product` SET  `name` =  ?,price=? WHERE  `Product`.`id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setString(1, bean.getName());
			ps.setFloat(2, bean.getPrice());
			ps.setInt(3, bean.getId());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

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
	// public static void main(String[] args) {
	// 	System.out.println( getList(15).get(1).getProductId());
	// }
}

package mice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mice.bean.Product;
import mice.util.DBUtil;

public class ProductDAO {
	public static void add(Product bean) {

		String sql = "INSERT INTO `mice`.`product` (`id`, `name`, `price`) VALUES (null,?,?);";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setString(1, bean.getName());
			ps.setFloat(2, bean.getPrice());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				bean.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Product get(int id) {
		String sql = "SELECT * FROM `product` where id = ? ";
		Product product = new Product();
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			try {
				ps.setInt(1, id);
				ResultSet eq = ps.executeQuery();
				if (eq.next()) {
					product.setId(id);
					product.setName(eq.getString("name"));
					product.setPrice(eq.getFloat("price"));
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return product;

	}

	public static Boolean isExist(int id) {
		String sql = "SELECT * FROM `product` where id = ? ";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			try {
				ps.setInt(1, id);
				ResultSet eq = ps.executeQuery();
				if (eq.next())
					return true;
				else
					return false;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return false;

	}

	public static void delete(int id) {
		String sql = "DELETE FROM `mice`.`product` WHERE `product`.`id` = ?";
		if (isExist(id)) {
			try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
				ps.setInt(1, id);
				ps.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void updata(Product bean) {
		String sql = "UPDATE  `mice`.`product` SET  `name` =  ?,price=? WHERE  `product`.`id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setString(1, bean.getName());
			ps.setFloat(2, bean.getPrice());
			ps.setInt(3, bean.getId());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List<Product> get(String name) {
		String sql = "SELECT * FROM `product` where name like ? ";
		List<Product> beans = new ArrayList<Product>();
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql);) {
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product bean = new Product();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setPrice(Float.parseFloat(rs.getString("price")));
				beans.add(bean);
				System.out.println(rs.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return beans;
	}

	public static List<Product> total() {
		String sql = "SELECT * FROM `product`";
		List<Product> beans = new ArrayList<Product>();

		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product bean = new Product();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setPrice(Float.parseFloat(rs.getString("price")));
				beans.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return beans;
	}

	public static void main(String[] args) {
		List<Product> Product = ProductDAO.get("a");
		for (Product g : Product) {
			System.out.println(g.getName());
		}
	}
}

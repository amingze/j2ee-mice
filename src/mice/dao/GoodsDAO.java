package mice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mice.bean.Goods;

import mice.util.DBUtil;

public class GoodsDAO {
	public static void add(Goods bean) {
		String sql = "INSERT INTO `mice`.`goods` (`id`, `name`, `price`) VALUES (null,?,?);";
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

	public static void delete() {
		String sql = "";

	}

	public static void updata(Goods bean) {
		String sql = "UPDATE  `mice`.`goods` SET  `name` =  ?,price=? WHERE  `goods`.`id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setString(1, bean.getName());
			ps.setFloat(2, bean.getPrice());
			ps.setInt(3, bean.getId());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List<Goods> get(String name) {
		String sql = "SELECT * FROM `goods` where name like ? ";
		List<Goods> beans = new ArrayList<Goods>();
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql);) {
			ps.setString(1, "%" + name + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Goods bean = new Goods();
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

	public static List<Goods> total() {
		String sql = "SELECT * FROM `goods`";
		List<Goods> beans = new ArrayList<Goods>();

		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Goods bean = new Goods();
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
		List<Goods> goods = GoodsDAO.get("a");
		for (Goods g : goods) {
			System.out.println(g.getName());
		}
	}
}

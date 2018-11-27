package mice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mice.bean.User;
import mice.util.DBUtil;

public class UserDAO {
	public static void add(User bean) {
		String sql = "INSERT INTO `mice`.`user` (`id`, `name`, `passwd`, `creatdate`) VALUES (null,?,?, CURRENT_TIMESTAMP);";
		try (PreparedStatement ps = DBUtil.prepareStatement(sql);) {
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPasswd());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt("id");
				bean.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(int id) {
		String sql = "DELETE FROM `mice`.`user` WHERE `user`.`id` = ?";
		try (PreparedStatement ps = DBUtil.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(String name) {
		String sql = "DELETE FROM `mice`.`user` WHERE `user`.`name` = ?";
		try (PreparedStatement ps = DBUtil.prepareStatement(sql);) {
			ps.setString(1, name);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updata(User bean) {
		String sql = "UPDATE  `mice`.`user` SET  `name` =  ?,`passwd`=?  WHERE  `user`.`id` =?;";
		try (PreparedStatement ps = DBUtil.prepareStatement(sql);) {
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPasswd());
			ps.setInt(3, bean.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<User> total() {
		String sql = "SELECT * FROM `user`";
		List<User> beans = new ArrayList<User>();

		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User bean = new User();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setPasswd(rs.getString(3));
				bean.setCreatDate(rs.getString(4));
				beans.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return beans;
	}

	public static User get(String name) throws SQLException {
		String sql = "SELECT *  FROM `user` WHERE `name` LIKE ?";
		User bean = new User();
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql);) {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String passwd = rs.getString("passwd");
				String creatDate = rs.getString("creatdate");
				bean.setId(id);
				bean.setName(name);
				bean.setPasswd(passwd);
				bean.setCreatDate(creatDate);
			}
		}
		return bean;
	}

	public static User check(String name, String passwd) {
		String sql = "SELECT *  FROM `user` WHERE `name` = ? and `passwd` =?";
		User bean = null;
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql);) {
			ps.setString(1, name);
			ps.setString(2, passwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				bean = new User();
				bean.setId(id);
				bean.setName(name);
				bean.setPasswd(passwd);
				// bean.setCreatDate(creatDate);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return bean;
	}

	public static boolean isExist(String name) throws SQLException {
		User bean = UserDAO.get(name);
		if (bean.getId() != 0)
			return true;
		else
			return false;
	}

	public static boolean isNoExist(String name) throws SQLException {
		return !isExist(name);
	}

	public static void main(String[] args) throws SQLException {
		// System.out.println(UserDAO.isExist("1243"));
		System.out.println(UserDAO.check("admin", "admin").getId());
		System.out.println(UserDAO.check("1", "1"));
		User user = UserDAO.check("1", "1");
		System.out.println(user);
	}
}

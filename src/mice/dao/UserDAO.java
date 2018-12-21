<<<<<<< HEAD

package mice.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mice.bean.User;
import mice.util.DBUtil;

public class UserDAO {

    public void add(User bean) {

        String sql = "insert into user values(null ,? ,?)";
        try (Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            ps.setString(1, bean.getName());
            ps.setString(2, bean.getPassword());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(User bean) {

        String sql = "update user set name= ? , password = ? where id = ? ";
        try (Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            ps.setString(1, bean.getName());
            ps.setString(2, bean.getPassword());
            ps.setInt(3, bean.getId());

            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from User where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public User get(int id) {
        User bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from User where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new User();
                String name = rs.getString("name");
                bean.setName(name);
                String password = rs.getString("password");
                bean.setPassword(password);
                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public List<User> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<User> list(int start, int count) {
        List<User> beans = new ArrayList<User>();

        String sql = "select * from User order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection();
                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User bean = new User();
                int id = rs.getInt(1);

                String name = rs.getString("name");
                bean.setName(name);
                String password = rs.getString("password");
                bean.setPassword(password);

                bean.setId(id);
                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }

    public boolean isExist(String name) {
        User user = get(name);
        return user != null;

    }

    public User get(String name) {
        User bean = null;

        String sql = "select * from User where name = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bean = new User();
                int id = rs.getInt("id");
                bean.setName(name);
                String password = rs.getString("password");
                bean.setPassword(password);
                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public User get(String name, String password) {
        User bean = null;

        String sql = "select * from User where name = ? and password=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bean = new User();
                int id = rs.getInt("id");
                bean.setName(name);
                bean.setPassword(password);
                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from User";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }
}
=======
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
	protected static UserDAO userDAO = new UserDAO();

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

	public static User get(User userBean) {
		String sql = "SELECT *  FROM `user` WHERE `name` = ? and `passwd` =?";
		User bean = null;
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql);) {
			ps.setString(1, userBean.getName());
			ps.setString(2, userBean.getPasswd());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				bean = new User();
				bean.setId(id);
				bean.setName(rs.getString("name"));
				bean.setPasswd(rs.getString("passwd"));
				// bean.setCreatDate(creatDate);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return bean;
	}

	public static User get(int userId) {
		String sql = "SELECT *  FROM `user` WHERE `id` = ? ";
		User bean = null;
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql);) {
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				bean = new User();
				bean.setId(id);
				bean.setName(rs.getString("name"));
				bean.setPasswd(rs.getString("passwd"));
				// bean.setCreatDate(creatDate);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return bean;
	}

	public static boolean loginCheck(String name, String passwd) {
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
		return null == bean;
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
		User bean = userDAO.get(name);
		if (bean.getId() != 0)
			return true;
		else
			return false;
	}

	public static boolean isNoExist(String name) throws SQLException {
		return !isExist(name);
	}

	public static void main(String[] args) throws SQLException {

	}
}
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544

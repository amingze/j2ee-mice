package mice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mice.bean.Category;
import mice.bean.Product;
import mice.util.DBUtil;

public class CategoryDAO {
    public void add(Category bean) {
        String sql = "INSERT INTO `mice`.`category` (`id`, `name`) VALUES (null,?);";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setString(1, bean.getName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                bean.setId(rs.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM `mice`.`category` WHERE `category`.`id` = ?";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updata(Category bean) {
        String sql = "UPDATE  `mice`.`category` SET  `name` =  ?, WHERE  `category`.`id` =?;";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setString(1, bean.getName());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Category get(int id) {
        String sql = "SELECT * FROM `category` where id = ? ";
        Category bean = new Category();
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            try {
                ps.setInt(1, id);
                ResultSet eq = ps.executeQuery();
                if (eq.next()) {
                    bean.setId(id);
                    bean.setName(eq.getString("name"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return bean;
    }

}
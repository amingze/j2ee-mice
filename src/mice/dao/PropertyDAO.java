package mice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import mice.bean.Property;
import mice.util.DBUtil;

/**
 * PropertyDAO
 */
public class PropertyDAO {
    public void add(Property bean) {
        String sql = "INSERT INTO `mice`.`property` (`id`, `name`,`c_id`) VALUES (null,?,?);";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setString(1, bean.getName());
            ps.setInt(2, bean.getCategoryId());

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
        String sql = "DELETE FROM `mice`.`property` WHERE `property`.`id` = ?";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updata(Property bean) {
        String sql = "UPDATE  `mice`.`property` SET  `name` =  ?, `c_id` = ?, WHERE  `property`.`id` =?;";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setString(1, bean.getName());
            ps.setInt(2, bean.getCategoryId());
            ps.setInt(3, bean.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Property get(int id) {
        String sql = "SELECT * FROM `property` where id = ? ";
        Property bean = new Property();
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            try {
                ps.setInt(1, id);
                ResultSet eq = ps.executeQuery();
                if (eq.next()) {
                    bean.setId(id);
                    bean.setName(eq.getString("name"));
                    bean.setCategoryId(eq.getInt("c_id"));
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
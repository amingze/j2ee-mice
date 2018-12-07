package mice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mice.bean.PropertyValue;
import mice.util.DBUtil;

/**
 * PropertyValue
 */
public class PropertyValueDAO {
    public void add(PropertyValue bean) {
        String sql = "INSERT INTO `mice`.`propertyvalue` (`id`, `pid`,`c_id`) VALUES (null,?,?);";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, bean.getProductId());
            ps.setInt(2, bean.getPropertyId());
            ps.setString(3, bean.getValue());
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
        String sql = "DELETE FROM `mice`.`propertyvalue` WHERE `propertyvalue`.`id` = ?";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updata(PropertyValue bean) {
        String sql = "UPDATE  `mice`.`propertyvalue` SET  `p_id` =  ?, `pt_id` = ?, `value` = ?,WHERE  `propertyvalue`.`id` =?;";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, bean.getProductId());
            ps.setInt(2, bean.getPropertyId());
            ps.setString(3, bean.getValue());
            ps.setInt(3, bean.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PropertyValue get(int id) {
        String sql = "SELECT * FROM `propertyvalue` where id = ? ";
        PropertyValue bean = new PropertyValue();
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            try {
                ps.setInt(1, id);
                ResultSet eq = ps.executeQuery();
                if (eq.next()) {
                    bean.setId(id);
                    bean.setProductId(eq.getInt("p_id"));
                    bean.setPropertyId(eq.getInt("pt_id"));
                    bean.setValue(eq.getString("value"));
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
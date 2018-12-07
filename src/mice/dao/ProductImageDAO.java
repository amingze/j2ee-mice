package mice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mice.bean.ProductImage;
import mice.util.DBUtil;

/**
 * CategoryDAO
 */
public class ProductImageDAO {
    public void add(ProductImage bean) {
        String sql = "INSERT INTO `mice`.`productimage` (`id`, `p_id`,`type`) VALUES (null,?,?);";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, bean.getId());
            ps.setInt(2, bean.getProductId());
            ps.setString(3, bean.getType());
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
        String sql = "DELETE FROM `productimage`.`product` WHERE `productimage`.`id` = ?";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updata(ProductImage bean) {
        String sql = "UPDATE  `mice`.`productimage` SET  `p_id` =  ?,`type` =  ?,WHERE  `productimage`.`id` =?;";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, bean.getId());
            ps.setString(2, bean.getType());
            ps.setInt(3, bean.getProductId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ProductImage get(int id) {
        String sql = "SELECT * FROM `productimage` where id = ? ";
        ProductImage bean = new ProductImage();
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            try {
                ps.setInt(1, id);
                ResultSet eq = ps.executeQuery();
                if (eq.next()) {
                    bean.setId(eq.getInt("id"));
                    bean.setProductId(eq.getInt("p_id"));
                    bean.setType(eq.getString("type"));
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
package mice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mice.bean.PropertyValue;
import mice.bean.Review;
import mice.util.DBUtil;

/**
 * PropertyValue
 */
public class ReviewDAO {
    public void add(Review bean) {
        String sql = "INSERT INTO `mice`.`Review` (`id`, `u_id`,`p_id`,`content`,`createtime`) VALUES (null,?,?,?,null);";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, bean.getProductId());
            ps.setInt(2, bean.getUserId());
            ps.setInt(3, bean.getProductId());
            ps.setString(4, bean.getContent());
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
        String sql = "DELETE FROM `mice`.`Review` WHERE `Review`.`id` = ?";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updata(Review bean) {
        String sql = "UPDATE  `mice`.`Review` SET  `u_id` =  ?, `p_id` = ?, `content` = ?,WHERE  `Review`.`id` =?;";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, bean.getUserId());
            ps.setInt(2, bean.getProductId());
            ps.setString(3, bean.getContent());
            ps.setInt(4, bean.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Review get(int id) {
        String sql = "SELECT * FROM `Review` where id = ? ";
        Review bean = new Review();
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            try {
                ps.setInt(1, id);
                ResultSet eq = ps.executeQuery();
                if (eq.next()) {
                    bean.setId(id);
                    bean.setProductId(eq.getInt("p_id"));
                    bean.setUserId(eq.getInt("u_id"));
                    bean.setContent(eq.getString("content"));
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
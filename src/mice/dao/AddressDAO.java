package mice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mice.bean.Address;
import mice.util.DBUtil;

public class AddressDAO {
    public void add(Address bean) {
        String sql = "INSERT INTO `mice`.`address` (`id`, `name`, `address`,`phone`,`u_id`) VALUES (null,?,?,?,?);";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getAddress());
            ps.setString(3, bean.getPhone());
            ps.setInt(4, bean.getUserId());
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
        String sql = "DELETE FROM `mice`.`address` WHERE `address`.`id` = ?";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updata(Address bean) {
        String sql = "UPDATE  `mice`.`address` SET  `name` =  ?,address=?,phone=?, WHERE  `address`.`id` =?;";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getAddress());
            ps.setString(3, bean.getPhone());
            ps.setInt(4, bean.getUserId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Address get(int id) {
        String sql = "SELECT * FROM `address` where id = ? ";
        Address bean = new Address();
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            try {
                ps.setInt(1, id);
                ResultSet eq = ps.executeQuery();
                if (eq.next()) {
                    bean.setId(id);
                    bean.setName(eq.getString("name"));
                    bean.setAddress(eq.getString("bean"));
                    bean.setPhoneNumber(eq.getString("phone"));
                    bean.setUserId(eq.getInt("u_id"));
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
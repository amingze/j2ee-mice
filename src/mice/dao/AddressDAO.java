package mice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mice.bean.Address;
import mice.util.DBUtil;

public class AddressDAO {
    public void add(Address bean) {
        String sql = "INSERT INTO `mice`.`address` (`id`, `name`, `address`,`phonenume`,`u_id`) VALUES (null,?,?,?,?);";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setString(1, bean.getName());
            ps.setString(2, bean.getAddress());
            ps.setInt(3, bean.getPhoneNumber());
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
        String sql = "DELETE FROM `mice`.`product` WHERE `address`.`id` = ?";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updata(Address bean) {
		String sql = "UPDATE  `mice`.`address` SET  `name` =  ?,address=?,phonenume=?, WHERE  `address`.`id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getAddress());
            ps.setInt(3, bean.getPhoneNumber());
            ps.setInt(4,bean.getUserId());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public static Address get(int id) {
		String sql = "SELECT * FROM `address` where id = ? ";
		Address product = new Address();
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			try {
				ps.setInt(1, id);
				ResultSet eq = ps.executeQuery();
				if (eq.next()) {
					product.setId(id);
					product.setName(eq.getString("name"));
                    product.setAddress(eq.getString("address"));
                    product.setPhoneNumber(eq.getInt("phonenume"));
                    product.setUserId(eq.getInt("u_id"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return product;
	}

}
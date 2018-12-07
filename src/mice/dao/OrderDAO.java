package mice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mice.bean.Order;
import mice.bean.OrderItem;
import mice.bean.Product;
import mice.util.DBUtil;

public class OrderDAO {

	// public void add(Order bean) {
    //     String sql = "INSERT INTO `mice`.`Order` (`id`, `u_id`,`p_id`,`content`,`createtime`) VALUES (null,?,?,?,null);";
    //     try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
    //         ps.setInt(1, bean.getId());
    //         ps.setInt(2, bean.getUserId());
    //         ps.setInt(3, bean.getOrderItem().getId());
    //         ps.setString(4, bean.getContent());
    //         ps.execute();
    //         ResultSet rs = ps.getGeneratedKeys();
    //         if (rs.next()) {
    //             bean.setId(rs.getInt("id"));
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
	// }
	
    public static int createOrder() {
        int id=0;
        String sql = "INSERT INTO `mice`.`order` (`id`, `datetime`) VALUES (null,null);";
        try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id=rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;

    }



	public void setTotal(float total){
		String sql = "UPDATE  `mice`.`Order` SET  `total` =  ?WHERE  `Order`.`id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setFloat(1,total);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public static void updata(Order bean) {
		String sql = "UPDATE  `mice`.`order` SET  `u_id`=? WHERE  `order`.`id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, bean.getUserId());
			ps.setFloat(2, bean.getId());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}


    }
    
    public static List<List<OrderItem>> getByUser(int userId) {
        List<List<OrderItem>> beans=new ArrayList<>();
		String sql = "SELECT * FROM `orderitem` where `u_id` = ?";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
			while (rs.next()) {
                int id=rs.getInt("id");
                List<OrderItem> bean=new ArrayList<OrderItem>();
                bean=OrderItemDAO.getByOrder(id);
                beans.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return beans;
    }
    public static void changeStatus(int id ,int status){
        String sql = "UPDATE  `mice`.`orderitem` SET  `status` =  ? WHERE  `orderitem`.`o_id` =?;";
		try (PreparedStatement ps = DBUtil.connection().prepareStatement(sql)) {
			ps.setInt(1, status);
			ps.setInt(2, id);
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public static void main(String[] args) {
        List<List<OrderItem>> order=new ArrayList<>();
        order=OrderDAO.getByUser(16);

        for(List<OrderItem> beans:order){
            for(OrderItem bean:beans)
                System.out.println("bean:~"+bean.getProductId());
        }
    }
}

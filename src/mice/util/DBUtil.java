package mice.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import mice.bean.Category;

/**
 * KCYDBCPUtil
 */


    
    

public  class DBUtil {
    private static DataSource ds;//定义一个连接池对象
    static{
        try {
            Properties pro = new Properties();
            pro.load(DBUtil.class.getClassLoader().getResourceAsStream("dbcp.properties"));
            ds = BasicDataSourceFactory.createDataSource(pro);//得到一个连接池对象
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExceptionInInitializerError("初始化连接错误，请检查配置文件！");
        }
    }
    //从池中获取一个连接
    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
    
    public static void closeAll(ResultSet rs,Statement stmt,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if(conn!=null){
            try {
                conn.close();//关闭
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
    	try {
			System.out.println(DBUtil.getConnection()); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(DBUtil.class.getResource("/").getPath());
		System.out.println(DBUtil.class.getResource("/").getPath());
		System.out.println(DBUtil.class.getClassLoader().getResource("").getPath());
		Category bean=new Category();
		bean.setId(1);
		bean.setName("a");
		
        String sql = "insert into category values(null,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);) {

            ps.setString(1, bean.getName());

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
}
    
    
    
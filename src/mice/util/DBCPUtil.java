package mice.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

import mice.util.DB;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.pool.KeyedObjectPoolFactory;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DBCPUtil {
    static int SELECT_SQL = 0;
    private final static String DB_IP = "132.232.49.18";
    // private final static String DB_IP = "10.160.16.10";
    // private final static String DB_IP = "localhost";
    private final static int DB_PORT = 3307;
    // private final static int DB_PORT = 3306;
    // private final static String DB_LOGIN_NAME = "root";
    private final static String DB_LOGIN_NAME = "root";
    // private final static String DB_LOGIN_PASS = "123";
    private final static String DB_LOGIN_PASS = "ZZT2gZa2";
    // private final static String DB_LOGIN_PASS = "usbw";
    private final static String DB_DBNAME = "mice";
    private final static String DB_ENCODE = "UTF-8";

    private static DataSource ds;
    static {
        try {
            InputStream in = DBCPUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            System.out.println(in);
            Properties props = new Properties();
            props.load(in);
            ds = BasicDataSourceFactory.createDataSource(props);

            System.err.println("SQLUtil Error;ClassNotFoundException;");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return null;
    }

    public static Connection connection(String ip, int port, String dbname, String encode, String loginName,
            String loginPass) throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, dbname, encode);
        return DriverManager.getConnection(url, loginName, loginPass);
    }

    public static Connection connection() throws SQLException {
        return connection(DB_IP, DB_PORT, DB_DBNAME, DB_ENCODE, DB_LOGIN_NAME, DB_LOGIN_PASS);
    }

    public static Statement createStatement() throws SQLException {
        return DBCPUtil.connection().createStatement();
    }

    public static PreparedStatement prepareStatement(String sql) throws SQLException {
        return DBCPUtil.connection().prepareStatement(sql);
    }

    public static Statement createStatement(String ip, int port, String dbname, String encode, String loginName,
            String loginPass) throws SQLException {
        return DBCPUtil.connection().createStatement();
    }

    public static PreparedStatement prepareStatement(String ip, int port, String dbname, String encode,
            String loginName, String loginPass, String sql) throws SQLException {
        return DBCPUtil.connection().prepareStatement(sql);
    }

    public static Statement createStatement(DB bean) throws SQLException {
        return DBCPUtil.createStatement(bean.DB_IP, bean.DB_PORT, bean.DB_DBNAME, bean.DB_ENCODE, bean.DB_LOGIN_NAME,
                bean.DB_LOGIN_PASS);
    }

    public static PreparedStatement prepareStatement(DB bean) throws SQLException {
        return DBCPUtil.prepareStatement(bean.DB_IP, bean.DB_PORT, bean.DB_DBNAME, bean.DB_ENCODE, bean.DB_LOGIN_NAME,
                bean.DB_LOGIN_PASS, bean.sql);
    }

    public static void main(String[] args) {
        try {
            System.out.println(DBCPUtil.connection());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection conn = DBCPUtil.getConnection();
        DatabaseMetaData metaData;
        try {
            metaData = conn.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getDatabaseProductVersion());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}

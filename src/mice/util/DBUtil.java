package mice.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import mice.util.DB;

import java.sql.Connection;

public class DBUtil {
	static int SELECT_SQL = 0;
	// private final static String DB_IP = "132.232.49.18";
	// private final static String DB_IP = "10.160.16.10";
	private final static String DB_IP = "localhost";
	private final static int DB_PORT = 3307;
	// private final static int DB_PORT = 3306;
	// private final static String DB_LOGIN_NAME = "root";
	private final static String DB_LOGIN_NAME = "root";
	// private final static String DB_LOGIN_PASS = "123";
	// private final static String DB_LOGIN_PASS = "ZZT2gZa2";
	private final static String DB_LOGIN_PASS = "usbw";
	private final static String DB_DBNAME = "mice";
	private final static String DB_ENCODE = "UTF-8";
	static {
		
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("SQLUtil Error;ClassNotFoundException;");
			e.printStackTrace();
		}
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
		return DBUtil.connection().createStatement();
	}

	public static PreparedStatement prepareStatement(String sql) throws SQLException {
		return DBUtil.connection().prepareStatement(sql);
	}

	public static Statement createStatement(String ip, int port, String dbname, String encode, String loginName,
			String loginPass) throws SQLException {
		return DBUtil.connection().createStatement();
	}

	public static PreparedStatement prepareStatement(String ip, int port, String dbname, String encode,
			String loginName, String loginPass, String sql) throws SQLException {
		return DBUtil.connection().prepareStatement(sql);
	}

	public static Statement createStatement(DB bean) throws SQLException {
		return DBUtil.createStatement(bean.DB_IP, bean.DB_PORT, bean.DB_DBNAME, bean.DB_ENCODE, bean.DB_LOGIN_NAME,
				bean.DB_LOGIN_PASS);
	}

	public static PreparedStatement prepareStatement(DB bean) throws SQLException {
		return DBUtil.prepareStatement(bean.DB_IP, bean.DB_PORT, bean.DB_DBNAME, bean.DB_ENCODE, bean.DB_LOGIN_NAME,
				bean.DB_LOGIN_PASS, bean.sql);
	}

	public static void main(String[] args) {
		try {
			System.out.println(DBUtil.connection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package mice.util;

public class DB {
	// public final String DB_IP = "132.232.49.18";
	public final String DB_IP = "127.0.0.1";
	public final int DB_PORT = 3306;
	public final String DB_LOGIN_NAME = "root";
	public final String DB_LOGIN_PASS = "root";
	public final String DB_DBNAME = "mice";
	public final String DB_ENCODE = "UTF-8";
	public static String sql;

	public static String getSql() {
		return sql;
	}

	public static void setSql(String sql) {
		DB.sql = sql;
	}

	public String getDB_IP() {
		return DB_IP;
	}

	public int getDB_PORT() {
		return DB_PORT;
	}

	public String getDB_LOGIN_NAME() {
		return DB_LOGIN_NAME;
	}

	public String getDB_LOGIN_PASS() {
		return DB_LOGIN_PASS;
	}

	public String getDB_DBNAME() {
		return DB_DBNAME;
	}

	public String getDB_ENCODE() {
		return DB_ENCODE;
	}

}

package registrationSystem.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class DBUtil {

	private static String driver = "com.mysql.jdbc.Driver";// 驱动程序名
	private static String URL = "jdbc:mysql://localhost:3306/nadrs?useSSL=false&allowPublicKeyRetrieval=true";// URL指向访问的数据库
	private static Connection con = null;
	private static Statement smt = null;
	private static ResultSet rs = null;

	private static Connection createConnection() {
		try {
			Class.forName(driver);// 加载驱动程序
			return DriverManager.getConnection(URL, "root", "123456");// 以root权限连接数据库
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (java.lang.ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Can't load Driver");
		}
		return null;
	}

	public static int runUpdate(String sql) throws SQLException {
		int count = 0;
		if (con == null) {
			con = createConnection();
		}
		if (smt == null) {
			smt = con.createStatement();
		}

		count = smt.executeUpdate(sql);

		if (smt != null) {
			smt.close();
			smt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
		return count;
	}

	public static void runBatch(ArrayList<String> s) throws SQLException {
		if (con == null) {
			con = createConnection();
		}
		if (smt == null) {
			smt = con.createStatement();
		}
		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i));
			smt.addBatch(s.get(i));
		}
		smt.executeBatch();
		return;
	}

	public static ResultSet runQuery(String sql) throws SQLException {
		if (con == null) {
			con = createConnection();
		}
		if (smt == null) {
			smt = con.createStatement();
		}
		return smt.executeQuery(sql);
	}

	public static void realeaseAll() {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (smt != null) {
			try {
				smt.close();
				smt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException ex) {
				Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
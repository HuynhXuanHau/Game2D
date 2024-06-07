package dao;

import java.sql.*;


public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			
			String url = "jdbc:sqlserver://DESKTOP-1EPEOV5\\SQLEXPRESS:1433;databaseName=game2D;encrypt=false;trustServerCertificate=true";
	        String user = "sa";
	        String password = "123456789";
	        
	        c= DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if (c!= null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static ResultSet getLeaderboard() throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		return stmt.executeQuery("SELECT * FROM Leaderboard ORDER BY score DESC");
	}
	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

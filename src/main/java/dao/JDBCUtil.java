package dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


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
	public static void printInfor(Connection c) {
		if(c!= null) {
			try {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
				System.out.println("Driver name: " + mtdt.getDriverName());
			      System.out.println("Driver version: " + mtdt.getDriverVersion());
			      System.out.println("Product name: " + mtdt.getDatabaseProductName());
			      System.out.println("Product version: " + mtdt.getDatabaseProductVersion());

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

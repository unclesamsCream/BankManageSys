package batabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/bank?useSSL=true";//?userUnicode=true&amp;characterEncoding=utf-8
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	private static Connection conn = null;
	
	static {
		try {
			// 1 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			// 2 获得数据库的连接
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return conn;
	}
	
	/*
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Connection con = DBUtil.getConnection();
		
		if(con!=null){
			System.out.println("connect success!");
		}else
		{
			System.out.println("connect fail!");
		}
	}
	*/
}

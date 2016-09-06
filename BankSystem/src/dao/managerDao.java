package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import batabase.DBUtil;
import entity.manager;

public class managerDao {
	
	// 查询是否有此账号
	public boolean checkAccount(String account, String password) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String sql = " " + 
				" select password from manager where account=? ;";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, account);
		ResultSet rs = pre.executeQuery();
		if(rs.next() && password.equals( rs.getString("password")) )
		{
			return true;
		}
		
		return false;
	}
	
	public void newManager(manager m) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String sql = " " +
					" insert into manager " +
					" (account, password) " +
					" values (?, ?);";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, m.getAccount());
		pre.setString(2, m.getPassword());
		pre.execute();
		
	}
	
	
	public static void main(String[] args) throws SQLException {
		managerDao m = new managerDao();
		manager ma = new manager();
		ma.setAccount("lalala");
		ma.setPassword("super");
		m.newManager(ma);
	}
	
}

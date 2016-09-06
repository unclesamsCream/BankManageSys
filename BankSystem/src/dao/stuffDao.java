package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import batabase.DBUtil;
import entity.stuff;

public class stuffDao {
	
	// 查询是否有此账号
	public boolean checkAccount(String account, String password) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String sql = " " + 
				" select password from stuff where account=? ;";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, account);
		ResultSet rs = pre.executeQuery();
		if(rs.next() && password.equals(rs.getString("password")) )
		{
			return true;
		}
		
		return false;
	}
	
	
	// 新增员工
	public boolean newStuff(stuff s) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String sql = " " +
					" insert into stuff " +
					" (account, password, openable, closeable, modifiable, viewable, quaryable) " +
					" values(?,?,?,?,?,?,?);";
		PreparedStatement pre = conn.prepareStatement(sql);
		
		pre.setString(1, s.getAccount());
		pre.setString(2, s.getPassword());
		pre.setByte(3, s.getOpenable());
		pre.setByte(4, s.getCloseable());
		pre.setByte(5, s.getModifiable());
		pre.setByte(6, s.getViewable());
		pre.setByte(7, s.getQueryable());
		pre.execute();
		
		return true;
	}
	
	// 删除员工
	public boolean DelStuff(String account) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String sql = " " + 	
					" delete from stuff " + 
					" where account=? ;";
		PreparedStatement pre = conn.prepareStatement(sql);
		
		pre.setString(1, account);
		pre.execute();
		return true;
	}
	
	// 修改员工权限
	public boolean ModifyStuff(stuff s) throws SQLException
	{
		//account, password, openable, closeable, modifiable, viewable, quaryable
		Connection conn = DBUtil.getConnection();
		String sql = " " + 
					" update stuff " +
					" set account=?, password=?, openable=?, closeable=?,  modifiable=?, viewable=?, quaryable=?" +
					" where account=? ;";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, s.getAccount());
		pre.setString(2, s.getPassword());
		pre.setByte(3, s.getOpenable());
		pre.setByte(4, s.getCloseable());
		pre.setByte(5, s.getModifiable());
		pre.setByte(6, s.getViewable());
		pre.setByte(7, s.getQueryable());
		pre.setString(8, s.getAccount());
		pre.execute();
		
		return true;
	}
	
	// 查询员工信息
	public stuff QueryStuff(String account) throws SQLException
	{
		stuff s = null;
		Connection conn = DBUtil.getConnection();
		String sql = " " +
				" select * from stuff where account=? ;";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, account);
		ResultSet rs = pre.executeQuery();
		if(rs.next())
		{
			s = new stuff();
			s.setAccount(rs.getString("account"));
			s.setCloseable(rs.getByte("closeable"));
			s.setModifiable(rs.getByte("modifiable"));
			s.setOpenable(rs.getByte("openable"));
			s.setPassword(rs.getString("password"));
			s.setQueryable(rs.getByte("quaryable"));
			s.setViewable(rs.getByte("viewable"));
			return s;
		}
		
		return null;
	}
	
	public static void main(String[] args) throws SQLException {
//		stuff s = new stuff();
//		s.setAccount("12346");
//		s.setCloseable((byte)1);
//		s.setModifiable((byte)1);
//		s.setOpenable((byte)1);
//		s.setPassword("123456");
//		s.setQueryable((byte)1);
//		s.setViewable((byte)1);
//		
//		//sd.newStuff(s);
////		sd.DelStuff("12346");
//		s.setCloseable((byte)0);
//		//sd.ModifyStuff(s);
//		System.out.println(sd.QueryStuff("12346").toString());
		stuffDao sd = new stuffDao();
		System.out.println(sd.checkAccount("666666", "951027"));;
		
		
	}
}

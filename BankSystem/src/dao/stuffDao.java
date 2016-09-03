package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import batabase.DBUtil;
import entity.stuff;

public class stuffDao {
	
	// 新增员工
	public boolean NewStuff(stuff s) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String sql = " " +
					" insert into stuff " +
					" (account, password, openable, closeable, modifiable, viewable, quaryable) " +
					" values(?,?,?,?,?,?,?);";
		PreparedStatement pre = conn.prepareStatement(sql);
		
		pre.setString(1, s.getAccount());
		pre.setByte(2, s.getModifiable());
		pre.setByte(3, s.getOpenable());
		pre.setByte(4, s.getQueryable());
		pre.setByte(5, s.getCloseable());
		pre.setByte(7, s.getViewable());
		pre.setString(6, s.getPassword());
		pre.execute();
		
		return true;
	}
	
	// 删除员工
	public boolean DelStuff(String account) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String sql = " " + 	
					" delete from users " + 
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
					" account=?, password=?, openable=?, closeable=?,  modifiable=?, viewable=?, queryable=?" +
					" where account=? ;";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, s.getAccount());
		pre.setString(2, s.getPassword());
		pre.setByte(3, s.getCloseable());
		pre.setByte(4, s.getModifiable());
		pre.setByte(5, s.getOpenable());
		pre.setByte(6, s.getQueryable());
		pre.setByte(7, s.getViewable());
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
			s.setQueryable(rs.getByte("queryable"));
			s.setViewable(rs.getByte("viewable"));
			return s;
		}
		
		return null;
	}
	
	
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import batabase.DBUtil;
import entity.users;

/*
 * 实现用户表相关的业务逻辑操作类
 * 
 * */
public class usersDao {
	
	// 查询是否有足够的余额
	public boolean checkResidual(String account, float amount) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String sql = " " +
					" select residual from users where account=? ;";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, account);
		ResultSet rs = pre.executeQuery();
		if(rs.next() && amount <= rs.getFloat("residual"))
			return true;
		else 
			return false;
		
	}
			
	
	// 查询是否有此账号
	public boolean checkAccount(String account, String password) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String sql = " " + 
				" select password from users where account=? ;";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, account);
		ResultSet rs = pre.executeQuery();
		if(rs.next() && password.equals( rs.getString("password")) )
		{
			return true;
		}
		
		return false;
	}
	
	// 开户，添加新的用户
	public boolean NewUser(users u) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String sql = "" + 
					" insert into users" +
					" (account, name, id, type, residual, rate," +
					" password, address, telphone, email)" + 
					" values(?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement pre = conn.prepareStatement(sql);
		
		pre.setString(1, u.getAccount());
		pre.setString(2, u.getName());
		pre.setString(3, u.getId());
		pre.setByte(4, u.getType());
		pre.setFloat(5, u.getResidual());
		pre.setByte(6, u.getRate());
		pre.setString(7, u.getPassword());
		pre.setString(8, u.getAddress());
		pre.setString(9, u.getTelphone());
		pre.setString(10, u.getEmail());
		pre.execute();
		return true;
	}
	
	
	//销户，返回余额并删除用户信息(如何删除operation内相关的操作表，不去处理？)
	public boolean DelUser(String account) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String sql = "" +
					" delete from users" +
					" where account=? ;";
		PreparedStatement pre = conn.prepareStatement(sql);
		
		pre.setString(1, account);
		pre.execute();
		
		return true;
	}
	
	//修改客户信息，
	public boolean ModifyUser(users u) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String sql = "" + 
					" update users " +
					" set account=?, name=?, id=?, type=?, residual=?, rate=?, " +
					" password=?, address=?, telphone=?, email=? " +
					" where account=? ;";
		PreparedStatement pre = conn.prepareStatement(sql);
		
		pre.setString(1, u.getAccount());
		pre.setString(2, u.getName());
		pre.setString(3, u.getId());
		pre.setByte(4, u.getType());
		pre.setFloat(5, u.getResidual());
		pre.setByte(6, u.getRate());
		pre.setString(7, u.getPassword());
		pre.setString(8, u.getAddress());
		pre.setString(9, u.getTelphone());
		pre.setString(10, u.getEmail());
		pre.setString(11, u.getAccount());
		pre.execute();
		
		return true;
	}
	
	// 显示用户信息
	public users ViewUser(String account) throws SQLException
	{
		users u = null;
		Connection conn = DBUtil.getConnection();
		String sql = " " + 
					" select * from users where account=? ;";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, account);
		ResultSet rs = pre.executeQuery();
		if(rs.next())
		{
			u = new users();
			u.setAccount(rs.getString("account"));
			u.setAddress(rs.getString("address"));
			u.setEmail(rs.getString("email"));
			u.setId(rs.getString("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setRate(rs.getByte("rate"));
			u.setResidual(rs.getFloat("residual"));
			u.setTelphone(rs.getString("telphone"));
			u.setType(rs.getByte("type"));
		}
		
		return u;
	
	}
	
	// 查询客户信息
	public users QueryUser(String name,String id, String address ) throws SQLException
	{
		users u = null;
		Connection conn = DBUtil.getConnection();
		String sql = "" +
					" select * from users " +
					" where name like ? and id like ? and address like ? " ;
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, "%"+name+"%");
		pre.setString(2, "%"+id+"%");
		pre.setString(3, "%"+address+"%");
		
		ResultSet rs = pre.executeQuery();
		if(rs.next())
		{
			u = new users();
			u.setAccount(rs.getString("account"));
			u.setAddress(rs.getString("address"));
			u.setEmail(rs.getString("email"));
			u.setId(rs.getString("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setRate(rs.getByte("rate"));
			u.setResidual(rs.getFloat("residual"));
			u.setTelphone(rs.getString("telphone"));
			u.setType(rs.getByte("type"));
		}
		return u;
	}
	
	// 修改密码
	public boolean ModifyPassword(String account,String oldPassword, String NewPassword) throws SQLException
	{
		users u = null;
		Connection conn = DBUtil.getConnection();
		String sql = " " + 
					" select password from users where account=? ;";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, account);
		ResultSet rs = pre.executeQuery();
		if(rs.next() && oldPassword.equals(rs.getString("password")))
		{
			sql = " " +
					"update users set password=? where account=? ;";
			pre = conn.prepareStatement(sql);
			pre.setString(1, NewPassword);
			pre.setString(2, account);
			pre.execute();
			return true;
			
		}else{
			
			return false;
			
		}
		
		
		
	}
	
	public static void main(String[] args) throws SQLException {
		usersDao ud = new usersDao();
		
//		users u = new users();
//		u.setAccount("123456");
//		u.setAddress("大青海");
//		u.setEmail("123@123.com");
//		u.setId("632223199510270576");
//		u.setName("tangrui");
//		u.setPassword("951027");
//		u.setRate((byte) 5);
//		u.setResidual((float) 95584.25);
//		u.setType((byte) 1);
//		//ud.NewUser(u);
//		
//		
//		//ud.DelUser("123456");
//		
//		u.setName("lalalal");
//		
//		ud.ModifyUser(u);
//		System.out.println(ud.ViewUser("132").getName());
//		System.out.println(ud.QueryUser("", "", "青海"));
//		ud.ModifyPassword("asdf", "1324", "666223");
		
//		System.out.println(ud.checkAccount("123", "951027"));;
		System.out.println(ud.checkResidual("321", 10200));
		
	}
}

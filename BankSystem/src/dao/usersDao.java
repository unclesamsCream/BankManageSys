package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import batabase.DBUtil;
import entity.users;

/*
 * ʵ���û�����ص�ҵ���߼�������
 * 
 * */
public class usersDao {
	
	// ����������µ��û�
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
	
	
	//������������ɾ���û���Ϣ(���ɾ��operation����صĲ�������ȥ����)
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
	
	//�޸Ŀͻ���Ϣ��
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
	
	// ��ʾ�û���Ϣ
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
	
	// ��ѯ�ͻ���Ϣ
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
	
	// �޸�����
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
		
		users u = new users();
		u.setAccount("123456");
		u.setAddress("���ຣ");
		u.setEmail("123@123.com");
		u.setId("632223199510270576");
		u.setName("tangrui");
		u.setPassword("951027");
		u.setRate((byte) 5);
		u.setResidual((float) 95584.25);
		u.setType((byte) 1);
		//ud.NewUser(u);
		
		
		//ud.DelUser("123456");
		
		u.setName("lalalal");
		
		ud.ModifyUser(u);
		System.out.println(ud.ViewUser("132").getName());
		System.out.println(ud.QueryUser("", "", "�ຣ"));
		ud.ModifyPassword("asdf", "1324", "666223");
	}
}

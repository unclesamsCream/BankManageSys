package action;

import java.sql.SQLException;

import dao.usersDao;
import entity.users;

public class stuffAction {
	
//	 �������ܣ�����ͻ������ϣ��˺š����������֤�š��˻����͡�������ȣ����û���������ӵ��û����С�����Ϊ6λ�����������Ϊ10Ԫ��
//	�½�һ���˻���Ϊ��ָ��һ��Ψһ���˺�����־���û����˻���Ϊ�������ͣ��ֱ��Ǵ����˻��������˻���������˻��ʹ��������˻���
//	�û��ɹ���¼֮��
//
//		�����˻����Դ���ȡ�
//
//		�����˻����Դ�ȡ�������͸֧��ȣ�
//
//		������˻����Դ�ȡ��������ͻ���������˺ſɴ��ͬ���֡���ͬ���͵Ĵ��������ںͶ��ڡ����ڴ���ʱ�䳤���޶�Ϊ�������¡����ꡢһ�ꡢ���ꡢ��������ꡣ
//		
//		���������˻����Դ�ȡ������������������͸֧��ȡ�
//
//	ϵͳ���ݿͻ��ĳ���������������Ԥ���趨һ��͸֧��ȡ���ÿ��Ϊ��λ���н��㣬�ͻ����������ܶ�ܳ���͸֧��ȡ�
	public boolean newUser(users u) throws SQLException
	{
		usersDao uDao = new usersDao();
		uDao.NewUser(u);
		return true;
	}

//	�������ܣ�����Ҫ�����Ŀ��ţ��ӻ�ȡ���ŵ���Ϣ�Ϳ��ŵ����û��������뾭����֤�ɹ���
//	���������򷵻����û����������Ϊ0����ɾ�����ŵ����ϡ�
	public boolean delUser(String account) throws SQLException
	{
		usersDao uDao = new usersDao();
		uDao.DelUser(account);
		return true;
	}
	
//	�޸Ŀͻ���Ϣ���ܣ������뿨�ţ�Ȼ���û��������뾭����֤�ɹ��󣬴����ݿ���û����л�ȡ�ͻ�����Ϣ�������ͻ�����Ϣ��ʾ��ҳ���ϣ�
//	���ڴ˻������޸ģ�ȷ���󣬽��޸ĺ�Ŀͻ���Ϣ���µ����ݿ⣬����ʾ��ҳ���ϡ�
//	���Զ��˻����͡��˻����롢�û����������֤�š���ͥסַ����ϵ�绰�͵�����������޸ģ����˺ź��˻��ϵĽ��ܱ��û��޸ġ�
	public boolean ModUsers(users u) throws SQLException
	{
		usersDao uDao = new usersDao();
		uDao.ModifyUser(u);
		return true;
	}
	
//	�ͻ���Ϣ��ʾ���ܣ�ͨ�����Ż�ȡ���ݿ����û������Ϣ�����÷�ҳ�ķ�ʽ��ʾ����
	public users viewUser(String account) throws SQLException
	{
		usersDao uDao = new usersDao();
		users u = uDao.ViewUser(account);
		return u;
	}
//	��ѯ������ָ����ʽ���в����˻���Ϣ�����������������֤�ź͵绰���в��ң�Ҳ���԰��յ�ַ����ģ�����ҡ�
	public users queryUser(String name,String id, String address ) throws SQLException
	{
		usersDao uDao = new usersDao();
		users u = uDao.QueryUser(name, id, address);
		return u;
	}
	public static void main(String[] args) throws SQLException {
		users u = new users();
		u.setAccount("123");
		u.setAddress("123132");
		u.setEmail("123@123.com");
		u.setId("63222319951027s0576");
		u.setName("tangrui");
		u.setPassword("951027");
		u.setRate((byte) 5);
		u.setResidual((float) 95584.25);
		u.setType((byte) 1);
		
		stuffAction sa = new stuffAction();
//		sa.newUser(u);
//		sa.delUser("123456789");
//		u.setName("balalalala");
//		sa.ModUsers(u);
//		System.out.println(sa.viewUser("123").toString());
//		System.out.println(sa.queryUser("", "63222319951027", ""));
	}
	
}

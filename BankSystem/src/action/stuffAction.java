package action;

import java.sql.SQLException;

import dao.usersDao;
import entity.users;

public class stuffAction {
	
//	 开户功能：输入客户的资料（账号、姓名、身份证号、账户类型、余额，密码等），用户的资料添加到用户表中。密码为6位数，开户余额为10元。
//	新建一个账户，为其指定一个唯一的账号来标志该用户。账户分为四种类型，分别是储蓄账户、信用账户、贷款储蓄账户和贷款信用账户。
//	用户成功登录之后，
//
//		储蓄账户可以存款和取款；
//
//		信用账户可以存款、取款和设置透支额度；
//
//		贷款储蓄账户可以存款、取款、申请贷款和还贷款，储蓄账号可储蓄不同币种、不同类型的存款，包括活期和定期。定期存款的时间长度限定为：三个月、半年、一年、两年、三年和五年。
//		
//		贷款信用账户可以存款、取款、申请贷款、还贷款和设置透支额度。
//
//	系统根据客户的偿还能力和信誉度预先设定一个透支额度。以每月为单位进行结算，客户当月消费总额不能超过透支额度。
	public boolean newUser(users u) throws SQLException
	{
		usersDao uDao = new usersDao();
		uDao.NewUser(u);
		return true;
	}

//	销户功能：输入要销户的卡号，从获取卡号的信息和卡号的余额，用户输入密码经过验证成功后，
//	如果有余额则返还给用户余额，将余额设为0后，再删除卡号的资料。
	public boolean delUser(String account) throws SQLException
	{
		usersDao uDao = new usersDao();
		uDao.DelUser(account);
		return true;
	}
	
//	修改客户信息功能：先输入卡号，然后用户输入密码经过验证成功后，从数据库的用户表中获取客户的信息，并将客户的信息显示在页面上，
//	并在此基础上修改，确定后，将修改后的客户信息更新到数据库，并显示在页面上。
//	可以对账户类型、账户密码、用户姓名、身份证号、家庭住址、联系电话和电子邮箱进行修改，而账号和账户上的金额不能被用户修改。
	public boolean ModUsers(users u) throws SQLException
	{
		usersDao uDao = new usersDao();
		uDao.ModifyUser(u);
		return true;
	}
	
//	客户信息显示功能：通过卡号获取数据库中用户表的信息，并用分页的方式显示出。
	public users viewUser(String account) throws SQLException
	{
		usersDao uDao = new usersDao();
		users u = uDao.ViewUser(account);
		return u;
	}
//	查询：按照指定方式进行查找账户信息，包括按姓名、身份证号和电话进行查找，也可以按照地址进行模糊查找。
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

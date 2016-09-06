package action;

import java.util.Date;
import java.sql.SQLException;

import dao.operationDao;
import dao.usersDao;
import entity.operation;
import entity.users;

public class userAction {
	Date date = new Date();
	
	//	取款功能：输入金额之后，执行取款计算，将账户余额减去输入的金额，并把最终余额、卡号信息、类型等信息添加到操作表中。
	public boolean withdraw(String account, float amount) throws SQLException
	{
		
		usersDao ud = new usersDao();
		if(ud.checkResidual(account, amount))
		{
			operation op = new operation();
			// 改变用户的账户信息 先得到该user对象
			
			users u = ud.ViewUser(account);
			u.setResidual(u.getResidual() - amount);
			ud.ModifyUser(u);
			
			// 生成operation记录
			op.setResidual(u.getResidual());
			op.setCard_number(account);
			Date date = new Date();
			op.setDeal_date(new java.sql.Date (date.getTime()) );
			op.setTransaction_amount(amount);
			op.setTransaction_from(account);
			op.setTransaction_to(account);
			op.setType((byte)1);
			
			// 将操作记录写入 operation 表之中
			operationDao opDao = new operationDao();
			opDao.withdraw(op);
			
			return true;
		}else{
			return false;
		}
		
	}
	
	//存款功能：输入金额后，执行存款计算，将账户余额加上输入的金额，并且把最终余额、卡号信息、类型等信息添加到操作表中。 
	public boolean deposit(String account, float amount) throws SQLException
	{
		usersDao ud = new usersDao();
		operation op = new operation();
		// 改变用户的账户信息 先得到该user对象
		
		users u = ud.ViewUser(account);
		u.setResidual(u.getResidual() + amount);
		ud.ModifyUser(u);
		
		// 生成operation记录
		op.setResidual(u.getResidual());
		op.setCard_number(account);
		Date date = new Date();
		op.setDeal_date(new java.sql.Date (date.getTime()) );
		op.setTransaction_amount(amount);
		op.setTransaction_from(account);
		op.setTransaction_to(account);
		op.setType((byte)1);
		
		// 将操作记录写入 operation 表之中
		operationDao opDao = new operationDao();
		opDao.withdraw(op);
		
		
		return true;
	}
	
	// 转账功能：	输入转入卡号和金额之后，将转出卡号的账户余额减去输入的金额，
	// 得到新的余额，把转出卡号、日期、类型、转出金额、新余额信息添加到操作表中。
	// 同时，获取转入的卡号，把其账户余额加上转入的金额，得到新的余额。把转入卡
	// 号、日期、类型、转出金额、新余额信息添加到操作表中。活期账号之间可以转账
	// ，可以设置单笔转账的最大额度和每天转账的最大额度。
	public boolean transaction(String from, String to, float amount) throws SQLException
	{
		usersDao ud = new usersDao();
		if(ud.checkResidual(from, amount))
		{
			users uFrom = ud.ViewUser(from);
			users uTo = ud.ViewUser(to);
			uFrom.setResidual(uFrom.getResidual() - amount);
			uTo.setResidual(uTo.getResidual() + amount);
			ud.ModifyUser(uFrom);
			ud.ModifyUser(uTo);
			
			// 生成operation表
			operation op = new operation();
			op.setCard_number(from);
			Date date = new Date();
			op.setDeal_date(new java.sql.Date (date.getTime()) );
			op.setResidual(uFrom.getResidual());
			op.setTransaction_amount(amount);
			op.setTransaction_from(from);
			op.setTransaction_to(to);
			op.setType((byte)1);
			operationDao opD = new operationDao();
			opD.transaction(op);
			
			return true;
		}else{
			return false;
		}
		
	}
	
	// 	修改密码功能：输入新密码和确认新密码，判断成功后，更新用户表中的密码。
	public boolean ModifyPassword(String account, String oldPW, String newPW) throws SQLException
	{
		usersDao uDao = new usersDao();
		uDao.ModifyPassword(account, oldPW, newPW);
		return true;
	}
	
	// 查询明细功能：通过卡号获取数据库的操作表中的信息，显示出明细，包括卡号、日期、类型、交易金额和余额。并将明细表可分页显示。
	// 这个功能有点难，先放在一边
	
	
	
	
	public static void main(String[] args) throws SQLException {
		userAction ua = new userAction();
//		ua.deposit("321", 100);
//		ua.withdraw("321", 100);
//		ua.transaction("321", "123", 100);
	}
}

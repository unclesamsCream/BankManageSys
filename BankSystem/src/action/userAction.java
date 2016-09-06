package action;

import java.util.Date;
import java.sql.SQLException;

import dao.operationDao;
import dao.usersDao;
import entity.operation;
import entity.users;

public class userAction {
	Date date = new Date();
	
	//	ȡ��ܣ�������֮��ִ��ȡ����㣬���˻�����ȥ����Ľ�����������������Ϣ�����͵���Ϣ��ӵ��������С�
	public boolean withdraw(String account, float amount) throws SQLException
	{
		
		usersDao ud = new usersDao();
		if(ud.checkResidual(account, amount))
		{
			operation op = new operation();
			// �ı��û����˻���Ϣ �ȵõ���user����
			
			users u = ud.ViewUser(account);
			u.setResidual(u.getResidual() - amount);
			ud.ModifyUser(u);
			
			// ����operation��¼
			op.setResidual(u.getResidual());
			op.setCard_number(account);
			Date date = new Date();
			op.setDeal_date(new java.sql.Date (date.getTime()) );
			op.setTransaction_amount(amount);
			op.setTransaction_from(account);
			op.setTransaction_to(account);
			op.setType((byte)1);
			
			// ��������¼д�� operation ��֮��
			operationDao opDao = new operationDao();
			opDao.withdraw(op);
			
			return true;
		}else{
			return false;
		}
		
	}
	
	//���ܣ��������ִ�д����㣬���˻�����������Ľ����Ұ�������������Ϣ�����͵���Ϣ��ӵ��������С� 
	public boolean deposit(String account, float amount) throws SQLException
	{
		usersDao ud = new usersDao();
		operation op = new operation();
		// �ı��û����˻���Ϣ �ȵõ���user����
		
		users u = ud.ViewUser(account);
		u.setResidual(u.getResidual() + amount);
		ud.ModifyUser(u);
		
		// ����operation��¼
		op.setResidual(u.getResidual());
		op.setCard_number(account);
		Date date = new Date();
		op.setDeal_date(new java.sql.Date (date.getTime()) );
		op.setTransaction_amount(amount);
		op.setTransaction_from(account);
		op.setTransaction_to(account);
		op.setType((byte)1);
		
		// ��������¼д�� operation ��֮��
		operationDao opDao = new operationDao();
		opDao.withdraw(op);
		
		
		return true;
	}
	
	// ת�˹��ܣ�	����ת�뿨�źͽ��֮�󣬽�ת�����ŵ��˻�����ȥ����Ľ�
	// �õ��µ�����ת�����š����ڡ����͡�ת�����������Ϣ��ӵ��������С�
	// ͬʱ����ȡת��Ŀ��ţ������˻�������ת��Ľ��õ��µ�����ת�뿨
	// �š����ڡ����͡�ת�����������Ϣ��ӵ��������С������˺�֮�����ת��
	// ���������õ���ת�˵�����Ⱥ�ÿ��ת�˵�����ȡ�
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
			
			// ����operation��
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
	
	// 	�޸����빦�ܣ������������ȷ�������룬�жϳɹ��󣬸����û����е����롣
	public boolean ModifyPassword(String account, String oldPW, String newPW) throws SQLException
	{
		usersDao uDao = new usersDao();
		uDao.ModifyPassword(account, oldPW, newPW);
		return true;
	}
	
	// ��ѯ��ϸ���ܣ�ͨ�����Ż�ȡ���ݿ�Ĳ������е���Ϣ����ʾ����ϸ���������š����ڡ����͡����׽�����������ϸ��ɷ�ҳ��ʾ��
	// ��������е��ѣ��ȷ���һ��
	
	
	
	
	public static void main(String[] args) throws SQLException {
		userAction ua = new userAction();
//		ua.deposit("321", 100);
//		ua.withdraw("321", 100);
//		ua.transaction("321", "123", 100);
	}
}

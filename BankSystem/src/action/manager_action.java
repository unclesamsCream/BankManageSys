package action;

import java.sql.SQLException;

import dao.stuffDao;
import entity.stuff;

public class manager_action {
//	���й�Ա�����ܣ����Զ����й�Ա����Ϣ��������ɾ���ġ���Ȳ��������ң���Ϊ���й�Ա��������˺źͲ���Ȩ�ޡ�
	public void newStuff(stuff s) throws SQLException
	{
		stuffDao sd = new stuffDao();
		sd.newStuff(s);
	}
	
	public void delStuff(String account) throws SQLException
	{
		stuffDao sd = new stuffDao();
		sd.DelStuff(account);
	}
	
	public void modStuff(stuff s) throws SQLException
	{
		stuffDao sd = new stuffDao();
		sd.ModifyStuff(s);
	}
	
	public stuff quaryStuff(String account) throws SQLException
	{
		stuffDao sd = new stuffDao();
		stuff s = sd.QueryStuff(account);
		return s;
	}
	
	public static void main(String[] args) throws SQLException {
		manager_action ma = new manager_action();
		stuff s = new stuff();
		s.setAccount("666666");
		s.setCloseable((byte)1);
		s.setModifiable((byte)1);
		s.setOpenable((byte)1);
		s.setPassword("951027");
		s.setViewable((byte)1);
		//ma.newStuff(s);
//		ma.delStuff("666666");
		//s.setCloseable((byte)0);
//		ma.modStuff(s);
		System.out.println(ma.quaryStuff("666666").toString());
	}
}

package dao;

import java.util.ArrayList;

import entity.operation;

/**
 * ���������ҵ����
 * @author rui
 *
 */
public class operationDao {
	
	// ȡ���¼������
	public boolean withdraw(operation op)
	{
		return true;
	}
	
	
	// ����¼������
	public boolean deposit(operation op)
	{
		return true;
	}
	
	// ת�˼�¼������
	public boolean transaction(operation op)
	{
		return true;
	}
	
	// ��ѯ�˺���ز�������Ϣ
	public ArrayList<operation> query(String account)
	{
		return null;
	}
}

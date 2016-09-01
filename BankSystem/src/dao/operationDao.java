package dao;

import java.util.ArrayList;

import entity.operation;

/**
 * 操作表具体业务类
 * @author rui
 *
 */
public class operationDao {
	
	// 取款记录添加入表
	public boolean withdraw(operation op)
	{
		return true;
	}
	
	
	// 存款记录添加入表
	public boolean deposit(operation op)
	{
		return true;
	}
	
	// 转账记录添加入表
	public boolean transaction(operation op)
	{
		return true;
	}
	
	// 查询账号相关操作表信息
	public ArrayList<operation> query(String account)
	{
		return null;
	}
}

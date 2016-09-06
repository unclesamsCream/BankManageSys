package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import batabase.DBUtil;
import entity.operation;
import entity.stuff;

/**
 * 操作表具体业务类
 * @author rui
 *
 */
public class operationDao {
	
	// 取款记录添加入表
	public boolean withdraw(operation op) throws SQLException
	{
		 Connection conn = DBUtil.getConnection();
		 String sql = " " +
		 			" insert into operation " +
		 			" ( card_number, type, residual, transaction_to, " +
		 			" transaction_from, transaction_amount, deal_date)" +
		 			" values (?,?,?,?,?,?,?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, op.getCard_number());
		pre.setByte(2, op.getType());
		pre.setFloat(3, op.getResidual());
		pre.setString(4, op.getTransaction_to());
		pre.setString(5, op.getTransaction_from());
		pre.setFloat(6, op.getTransaction_amount());
		pre.setDate(7, (Date) op.getDeal_date());
		pre.execute();
		return true;
	}
	
	
	// 存款记录添加入表
	public boolean deposit(operation op) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		 String sql = " " +
		 			" insert into operation " +
		 			" ( card_number, type, residual, transaction_to, " +
		 			" transaction_from, transaction_amount, deal_date)" +
		 			" values (?,?,?,?,?,?,?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, op.getCard_number());
		pre.setByte(2, op.getType());
		pre.setFloat(3, op.getResidual());
		pre.setString(4, op.getTransaction_to());
		pre.setString(5, op.getTransaction_from());
		pre.setFloat(6, op.getTransaction_amount());
		pre.setDate(7, (Date) op.getDeal_date());
		pre.execute();
		return true;
	}
	
	// 转账记录添加入表
	public boolean transaction(operation op) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		 String sql = " " +
		 			" insert into operation " +
		 			" ( card_number, type, residual, transaction_to, " +
		 			" transaction_from, transaction_amount, deal_date)" +
		 			" values (?,?,?,?,?,?,?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, op.getCard_number());
		pre.setByte(2, op.getType());
		pre.setFloat(3, op.getResidual());
		pre.setString(4, op.getTransaction_to());
		pre.setString(5, op.getTransaction_from());
		pre.setFloat(6, op.getTransaction_amount());
		pre.setDate(7, (Date) op.getDeal_date());
		pre.execute();
		return true;
	}
	
	// 查询账号相关操作表信息
	public ArrayList<operation> query(String card_number) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String sql = " " +
					" select * from operation where card_number=? ;";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, card_number);
		ResultSet rs = pre.executeQuery();
		ArrayList<operation> opList = new ArrayList<operation>();
		operation op = null;
		while(rs.next())
		{
			op = new operation();
			op.setCard_number(rs.getString("card_number"));
			op.setDeal_date(rs.getDate("deal_date"));
			op.setResidual(rs.getFloat("residual"));
			op.setTransaction_amount(rs.getFloat("transaction_amount"));
			op.setTransaction_from(rs.getString("transaction_from"));
			op.setTransaction_to(rs.getString("transaction_to"));
			op.setType(rs.getByte("type"));
			opList.add(op);
			
		}
		
		return opList;
	}
	
	public static void main(String[] args) throws SQLException {
		operation op = new operation();
		op.setCard_number("123456");
		op.setDeal_date(new Date(0));
		op.setResidual((float)19555.55);
		op.setTransaction_amount((float)2548.4);
		op.setTransaction_from("124");
		op.setTransaction_to("254");
		op.setType((byte)1);
		operationDao opD = new operationDao();
		/*
		opD.withdraw(op);
		opD.deposit(op);
		opD.transaction(op);
		*/
		ArrayList<operation> opList = opD.query("123456");
		for(operation o: opList)
		{
			System.out.println(o.toString());
//			System.out.println("what's hell ??");
		}
		
		
	}
}

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="dao.*"%>
<%
/*
	用户登录验证页面，提交的账号密码如果有记录，就跳转到用户主页，否则跳回登陆页面
*/
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String account = request.getParameter("managerAccount");
	String password = request.getParameter("managerPassword");
	managerDao md = new managerDao();
	if(md.checkAccount(account, password))
	{
		out.print("success");
	}else{
		out.print("fail");
	}
%>

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="dao.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
stuffDao sd = new stuffDao();
String account = request.getParameter("stuffAccount");
String password = request.getParameter("stuffPassword");
if(sd.checkAccount(account, password))
{
	out.print("success");
}else{
	out.print("fail");
}
%>


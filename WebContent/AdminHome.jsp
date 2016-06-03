<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="service.LogInService" %>
<jsp:include page="WEB-INF/MyStyle.css"/>
<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Home</title>
</head>
<body bgcolor="cyan">
	<h1 align="center">Inventory Management System</h1>
	<h2 align="center">University of Chittagong</h2>
	<h4 align="center">Zobra, Hathazari,Chittagong - 4331</h4>
	<p align="center">This is Inventory Management System of Chittagong
		University</p>
	<br>
	<div align="center">
		<a href=InitBudget.jsp> Initiate Budget </a>
	</div>
	<br>
	<div align="center">
		<a href=CheckBudget.jsp> Budget Info </a>
	</div>
	<br>
	<div align="center">
		<a href=UpdateBudget.jsp> Update Budget </a>
	</div>
	<br>
	<div align="center">
		<a href=ReportGenerate.jsp> Report Generate </a>
	</div>
	<br>
	<br>
	<br>
	<p align="center">
		<a href=LogOut.jsp> Log Out </a>
	</p>
	<%
	if("Admin".equals(request.getSession().getAttribute("LoggedInUser"))==false) 
	response.sendRedirect("AdminLogin.jsp");
	%>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="control.UpdateBudget"%>
<%@ page import="control.AdminLogin"%>
<jsp:include page="WEB-INF/MyStyle.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Budget Check</title>
</head>
<body bgcolor="cyan">
	<h1 align="center">Inventory Management System</h1>
	<h2 align="center">University of Chittagong</h2>
	<h4 align="center">Zobra, Hathazari,Chittagong - 4331</h4>
	<p align="center">This is Inventory Management System of Chittagong
		University</p>
	<br>
	<center>
		<%
			System.out.print("AMi ekhane 19 Number Line a, Jsp te\n");
			String BudgetFound = request.getSession().getAttribute("BudgetFound").toString();
			String DepartmentName = (String) request.getSession().getAttribute("DepartmentName").toString();
			String Year = (String) request.getSession().getAttribute("Year").toString();
			System.out.print("AMi ekhane 23 Number Line a, Jsp te\n BudgetFound = "+BudgetFound+"\n\n");
			System.out.println(DepartmentName);
			System.out.println(Year);
		%>
		
		<p> <strong> Budget Not Found for <%= DepartmentName%> Department of Year <%= Year%> > </strong> </p>	
		
		
	</center>
</body>
</html>
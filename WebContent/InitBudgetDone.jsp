<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="WEB-INF/MyStyle.css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stuff Login</title>
</head>
<body bgcolor="cyan">
	<h1 align="center">Inventory Management System</h1>
	<h2 align="center">University of Chittagong</h2>
	<h4 align="center">Zobra, Hathazari,Chittagong - 4331</h4>
	<p align="center">This is Inventory Management System of Chittagong
		University</p>
	<br><br>
	<center>
		<%
			String Dept = request.getParameter("department");
			String Year = request.getParameter("year");
		%>
		<strong>Budget Initialization for <%=Dept%> of <%=Year%> Done!! &nbsp; &nbsp; <a href=InitBudget.jsp >Init Another?</a> </strong>
		<br>
		<br>
		<br>
		<a href=AdminHome.jsp>Back To Home</a>
	</center>
</body>
</html>
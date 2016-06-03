<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="WEB-INF/MyStyle.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Budget for Requisition</title>
</head>
<body bgcolor="cyan">
	<h1 align="center">Inventory Management System</h1>
	<h2 align="center">University of Chittagong</h2>
	<h4 align="center">Zobra, Hathazari,Chittagong - 4331</h4>
	<p align="center">This is Inventory Management System of Chittagong
		University</p>
	<br>
	<center>
		<form action="CheckBudgetForReq" method="post">
			<strong><font size=5 >Check Budget for Requisition</font></strong> <br>
			<strong><font size=3 >Please Enter Required Info Click Check</font></strong>
			<br>
			<br> Department: <select name="department">
				<option>-Select Department-</option>
				<option value="CSE">CSE</option>
				<option value="APECE">APECE</option>
				<option value="LAW">L.L.B</option>
				<option value="STAT">Statistics</option>
			</select> <br>
			<br> Year: <select name="year">
				<option>-Select Year-</option>
				<option value="2015">2015</option>
				<option value="2016">2016</option>
				<option value="2017">2017</option>
				<option value="2018">2018</option>
				<option value="2019">2019</option>
				<option value="2020">2020</option>
			</select> <br> <br>
			<strong>Requisition Details:</strong> <br><br>
			Scientific:<input type=text name=sci_eq style="width: 94px; "> &nbsp; Stationary: <input type=text name=sta_eq style="width: 97px; "> &nbsp; Tools:<input type="text" name=tools style="width: 92px; "><br><br>
			 <input type="submit" value="Check">
		</form>
		<% System.out.println("Going to Servlet"); %>
		<br><br><br><h4> <a href=StuffHome.jsp> Back to Home </a></h4>
	</center>
</body>
</html>
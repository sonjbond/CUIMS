<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="WEB-INF/MyStyle.css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login as Admin</title>
</head>
<body bgcolor="cyan">
	<h1 align="center">Inventory Management System</h1>
	<h2 align="center">University of Chittagong</h2>
	<h4 align="center">Zobra, Hathazari,Chittagong - 4331</h4>
	<p align="center">This is Inventory Management System of Chittagong
		University</p>
	<center>
		<form action="AdminLogin" method="post">
			
			<strong><font size=5 >Admin Login</font></strong> <br>
			<strong><font size=3 >Please Login</font></strong>
			<br>
			<br>
			<table>
				<tr>
					<td>username</td>
					<td><input type="text" name="name" placeholder=username>
					</td>
				</tr>
				<tr>
					<td>password</td>
					<td><input type="password" name="password"
						placeholder=password></td>
				</tr>
				<tr>
					<td><input type="submit" value="Log in">
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
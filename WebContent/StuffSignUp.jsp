<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="WEB-INF/MyStyle.css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stuff SignUp</title>
</head>
<body bgcolor="cyan">
	<h1 align="center">Inventory Management System</h1>
	<h2 align="center">University of Chittagong</h2>
	<h4 align="center">Zobra, Hathazari,Chittagong - 4331</h4>
	<p align="center">This is Inventory Management System of Chittagong
		University</p>
	<br>
	<center>
		<form action="StuffSignUp" method="post">
			<h3>Stuff  Sign Up</h3>
			<h4>Please Sign Up</h4>
			<table>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="FirstName"
						placeholder="First Name"></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="LastName" placeholder="Last Name">
					</td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input type="text" name="email" placeholder=E-mail>
					</td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" placeholder=username>
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"
						placeholder=password></td>
				</tr>
				<tr>
					<td><input type="submit" value="Sign Up"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
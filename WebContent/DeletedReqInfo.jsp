<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector"%>
<%@ page import="control.DeleteReqInfo"%>
<jsp:include page="WEB-INF/MyStyle.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select and delete Info</title>
</head>
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
			String Del= request.getSession().getAttribute("Deleted").toString();
			if(Del.equals("true")){
				out.print("<br> <strong> Requisition Info Successfully Deleted from the Database</strong><br>");
			}
			else{
				out.print("<br> <strong> Requisition Info Can not be Deleted from the Database</strong><br>");
			}
		 %>
	</center>
</body>
</html>
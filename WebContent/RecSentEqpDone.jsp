<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="WEB-INF/MyStyle.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Record Success!</title>
</head>
<body bgcolor="cyan">
	<h1 align="center">Inventory Management System</h1>
	<h2 align="center">University of Chittagong</h2>
	<h4 align="center">Zobra, Hathazari,Chittagong - 4331</h4>
	<p align="center">This is Inventory Management System of Chittagong
		University</p>
	
	<center>
		<%
			String S=request.getSession().getAttribute("Record").toString();
			if("true".equals(S)){
				out.print("<h4> <font color='green'>Record Sent Equipment Success!!</font> <a href=RecordSentEquipmentInfo.jsp>Record Another?</a> </h4> <h4> <br><br><br> <a href=StuffHome.jsp> Back to Home </a></h4>");
			}
			else{
				out.print("<h4> <font color='red'>Record Sent Equipment Failed!!</font> <a href=RecordSentEquipmentInfo.jsp>Try Again?</a> </h4> <h4> <br><br><br> <a href=StuffHome.jsp> Back to Home </a></h4>");
			}
		 %>
	</center>
</body>
</html>
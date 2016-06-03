<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="WEB-INF/MyStyle.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stuff Home</title>
</head>
<body bgcolor="cyan">
	<h1 align="center">Inventory Management System</h1>
	<h2 align="center">University of Chittagong</h2>
	<h4 align="center">Zobra, Hathazari,Chittagong - 4331</h4>
	<p align="center">This is Inventory Management System of Chittagong
		University</p>
	<br>
	<p align="center"> <a href=CheckBudget.jsp>Budget Info</a> </p>
	<p align="center"> <a href=RecordRequisitionInfo.jsp>Record Requisition Info</a> </p>
	<p align="center"> <a href=DeleteReqInfo.jsp>Delete Requisition Info</a> </p>
	<p align="center"> <a href=CheckBudgetForReq.jsp>Check Budget for Requisition</a> </p>
	<p align="center"> <a href=RecordSentEquipmentInfo.jsp>Record Sent Equipment Info</a> </p>
	<p align="center"> <a href=DeleteSentEquipmentInfo.jsp>Delete Sent Equipment Info</a> </p>
	<p align="center"> <a href=RecordPurchaseInfo.jsp>Record Purchase Info</a> </p>
	<p align="center"> <a href=EditPurchaseInfo.jsp>Edit Purchase Info</a> </p>
	<p align="center"> <a href=DeletePurchaseInfo.jsp>Delete Purchase Info</a> </p>
	<br>
	<p align="center"> <a href=LogOut.jsp>Log Out</a> </p>
	
	<% System.out.println("Now LoggedInUser = "+request.getSession().getAttribute("LoggedInUser")); %>
	<% //request.getSession().removeAttribute("LoggedInUser"); %>
	<% System.out.println("Now LoggedInUser = "+request.getSession().getAttribute("LoggedInUser")); %>
	<% 
	if("Stuff".equals(request.getSession().getAttribute("LoggedInUser"))==false) 
	response.sendRedirect("StuffLogin.jsp"); 
	%>
	
</body>
</html>
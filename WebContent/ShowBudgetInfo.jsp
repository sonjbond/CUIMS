<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector"%>
<jsp:include page="WEB-INF/MyStyle.css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Budget Info</title>

<style>
table,th {
	border: 4px outset black;
}

td {
	border: 2px solid black;
}
</style>

</head>
<body bgcolor="cyan">
	<h1 align="center">Inventory Management System</h1>
	<h2 align="center">University of Chittagong</h2>
	<h4 align="center">Zobra, Hathazari,Chittagong - 4331</h4>
	<p align="center">This is Inventory Management System of Chittagong
		University</p>
	<br>
	<br>
	
	<%
		System.out.println("Now LoggedInUser = " + request.getSession().getAttribute("LoggedInUser"));
	%>
	
	
	<center>
		<%
			String found = request.getSession().getAttribute("BudgetFound").toString();
			String Dept = request.getSession().getAttribute("Dept").toString();
			String Year = request.getSession().getAttribute("Year").toString();
			if (found.equals("Yes")) {
				Vector<String> res = (Vector<String>) request.getSession().getAttribute("BudgetInfo");
				out.print("<br> <div> <strong> <font color=green> Budget Details Found for " + Dept + " Department of " + Year + " </font> </strong> </div><br>");
				out.print("<table> <tr> <td> <strong> Total Budget Amount</strong></td> <td><strong>" + res.get(0) + "Tk. </strong></td> </tr>");
				out.print("<tr> <td> <strong> Remaining Amount </strong> </td> <td> <strong> " + res.get(1) + "Tk. </strong> </td> </tr>");
				out.print("<tr> <td> <strong> Issue Date </strong> </td> <td> <strong> " + res.get(2) + " </strong> </td> </tr></table>");
			}
			else {
				out.print("<strong><font color=red>No Budget Info Found for " + Dept + " Department of " + Year + "!!</font></strong>");
			}
		%>
		<br>
		<br>
		<br> 
		<a href="StuffHome.jsp">Back To Home</a>
	</center>

	

</body>
</html>
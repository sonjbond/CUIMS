<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector"%>
<jsp:include page="WEB-INF/MyStyle.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Budget Status For Requirement</title>

<style>
table, th {
    border: 4px outset black;
}
td{
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
	<center>
		<%
			String found=request.getSession().getAttribute("BudgetFound").toString();
			String Dept = request.getSession().getAttribute("Dept").toString();
			String Year = request.getSession().getAttribute("Year").toString();
			if(found.equals("Yes")){
				//Vector< String > res = (Vector< String >) request.getSession().getAttribute("BudgetInfo");
				out.print("<br> <div> <strong> <font color=green> Budget Details Found for " + Dept + " Department of "+Year+" for given Requisition </font> </strong> </div><br>");
				String status = request.getSession().getAttribute("Status").toString();
				if(status.equals("Passed")){
					int Rem = Integer.parseInt(request.getSession().getAttribute("Rem").toString());
					int Cost = Integer.parseInt(request.getSession().getAttribute("Cost").toString());
					int AfterRem=Rem-Cost;
					out.print("<strong> <font color=green> Requisition Cost is Under Budget!</font></strong><br>");
					out.print("<strong> Total Budget Amount = "+request.getSession().getAttribute("TotalBudget")+"<br> Requisition Cost = "+Cost+"<br> Available Budget Amount = "+Rem+ "<br> Remaining Budget After Sending Given Requisition Amount = "+AfterRem+"<br> </strong>");
				}
				else{
				out.print("<strong> <font color=red> Requisition Cost is Exceeding Budget! </font> </strong><br>");
					out.print("<strong> Total Budget Amount = "+request.getSession().getAttribute("TotalBudget")+"<br> Available Budget Amount = "+request.getSession().getAttribute("Rem")+"<br>Requisition Cost = "+request.getSession().getAttribute("Cost")+ "<br> </strong>");
				}
			}
			else{
				out.print("<strong><font color=red>No Budget Info Found for "+Dept+" Department of "+Year+"!! Requisition Cost Can't Be Checked</font></strong>");
			}
		 %>
		 <br><br><br>
		 <a href="StuffHome.jsp">Back To Home</a>
	</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="control.UpdateBudget"%>
<%@ page import="control.AdminLogin"%>
<jsp:include page="WEB-INF/MyStyle.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Budget Update</title>
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
			String TotalBudget="";String RemainingBudget="";String IssueDate ="";
			if ("NotFound".equals(BudgetFound)) {
				//out.print(" <strong> No Budget Found For " + DepartmentName + " of Year " + Year + " </strong> <br> want to <a href=InitBudget.jsp> Initiate Budget </a> ? <br> ");
				response.sendRedirect("BudgetNotFound.jsp");
			}
			else if("Found".equals(BudgetFound)){
				TotalBudget = (String) request.getSession().getAttribute("TotalBudget");
				RemainingBudget = (String) request.getSession().getAttribute("RemainingBudget");
				IssueDate =(String)request.getSession().getAttribute("IssueDate");
				//out.print(" <br> <strong> Department: " + DepartmentName + " Total Budget: " + TotalBudget + "  RemainingBudget: "+RemainingBudget+"  Issue Date: "+IssueDate+" </strong> <br>" );
			}
		%>
			
		<form action="UpdateBudgetSelected" method="post">
			<br>
			<font size=5px ><strong>Budget Details</strong></font><br>
			<font size=4px ><strong>Edit Info and Click Update</strong></font>
			<br><br>
			<table border=4 cellpadding=10>
				<tr>
					<th align="center">Total Budget</th><th align="center">Remaining Budget</th><th>Action</th>
				</tr>
				
				<tr>
					<td><input type="text" value=<%= TotalBudget%> name=Total ></td> <td> <input type="text" value=<%= RemainingBudget%> name=Rem > </td>
					<td><input type="submit" value="Update"></td>
					
				</tr>
			</table>
				<input type="hidden" name=Dept value=<%=DepartmentName %> >
				<input type="hidden" name=Year value=<%=Year %> >
				<br><br>
		</form>
		
		<br><br> <a href=AdminHome.jsp>Back To Home</a>
		
		
		
	</center>
</body>
</html>
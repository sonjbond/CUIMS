<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector"%>
<%@ page import="control.DeleteReqInfo"%>
<jsp:include page="WEB-INF/MyStyle.css" />
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
		<form action="DeleteSelectedSent" method="post">

			<%
				String Dept = (String) request.getParameter("Department");
				String Year = (String) request.getParameter("Year");
			%>

			<input type="hidden" name="Department" value='<%=Dept%>'> 
			<input type="hidden" name="Year" value='<%=Year%>'>

			<%
				Vector<Vector<String>> data = new Vector<Vector<String>>();
				data = (Vector<Vector<String>>) (request.getSession().getAttribute("SentInfoTable"));
				System.out.println("From Jsp :D");

				if (data.size() != 0) {
					out.print("<table border=4 style='width:40%'>");
					out.print("<br> <strong> Sent Equipment Records of " + Dept + " Department for " + Year + "</strong> <br> <br> Select which one You want to Delete and Click Delete!<br>");
					System.out.println("Department = " + Dept + "  Year = " + Year);
					out.print("<br><tr> <td><strong>Scientific Eqp.</strong></td> <td><strong>Stationary Eqp.</strong></td> <td><strong>Tools</strong></td> <td><strong>Date of Supply</strong></td> <td><strong>Action</strong></td> </strong> </tr>");
					for (int i = 0; i < data.size(); i++) {
						out.print("<tr>");
						for (int j = 2; j < data.get(i).size(); j++) {
							System.out.print(data.get(i).get(j) + "  ");
							out.print("<td><input type='text' name='inp" + i + "_" + j + "' value = '" + data.get(i).get(j) + "' style='width: 100px;'> </td>");
							System.out.print("<td><input type='text' name='inp" + i + "_" + j + "' value = '" + data.get(i).get(j) + "'> </td>");
						}
						out.print("<td><input type=submit name=button" + i + " value=Delete></td>");
						System.out.println("");
						out.print("</tr>");
					}
					out.print("</table><br><br>");
				}
				else {
					out.print("<br><br> <strong> <font color=red> No Sent Equipment Info Found for " + Dept + " Department of " + Year + ". So Nothing to Delete! </font></strong><br><br><br>");
				}
				System.out.println(data.size());
			%>

		</form>
		<br>
		<br> <a href=StuffHome.jsp> Back To Home </a>
	</center>
</body>
</html>
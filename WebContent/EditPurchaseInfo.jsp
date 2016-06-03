<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector"%>
<%@ page import="util.MyDate"%>
<%@ page import="service.GetPurInfo"%>
<jsp:include page="WEB-INF/MyStyle.css" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Purchase Info</title>
</head>
<body bgcolor="cyan">
	<h1 align="center">Inventory Management System</h1>
	<h2 align="center">University of Chittagong</h2>
	<h4 align="center">Zobra, Hathazari,Chittagong - 4331</h4>
	<p align="center">This is Inventory Management System of Chittagong
		University</p>
	<br>
	<center>
		<form action="EditSelectedPurchase" method="post">

			<%
				GetPurInfo gpi = new GetPurInfo();
				Vector<Vector<String>> data = gpi.Get();
				System.out.println(data.size());
				if (data.size() != 0) {
					out.print("<table border=4 style='width:40%'>");
					out.print("<br> <strong> Purchase Info </strong> <br> <br> Select which one You want to Edit Then Change info and Click Edit!<br>");
					out.print("<br><tr> <td><strong>Store Name</strong></td> <td><strong>Scientific Eqp.</strong></td> <td><strong>Stationary Eqp.</strong></td> <td><strong>Tools</strong></td> <td><strong>Date of Purchase</strong></td> <td><strong>Action</strong></td> </strong> </tr>");
					for (int i = 0; i < data.size(); i++) {
						out.print("<tr>");
						for (int j = 0; j < data.get(i).size(); j++) {
							//System.out.print(data.get(i).get(j) + "  ");
							out.print("<td><input type='text' name='inp" + i + "_" + j + "' value = '" + data.get(i).get(j) + "' style='width: 100px;' > </td>");
							//System.out.print("<td><input type='text' name='inp" + i + "_" + j + "' value = '" + data.get(i).get(j) + "' style='width: 80px;'> </td>");
						}
						out.print("<td><input type=submit name=button" + i + " value=Edit></td>");
						//System.out.println("");
						out.print("</tr>");
					}
					out.print("</table><br><br>");
				}
				else {
					out.print("<br><br> <strong> <font color=red> No Purchase Info Found!!!</font></strong><br><br><br>");
				}
			%>


		</form>
		<br><br><a href=StuffHome.jsp>Back To Home</a>
	</center>
</body>
</html>
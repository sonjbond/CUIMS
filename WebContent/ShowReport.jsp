<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="service.LogInService"%>
<%@ page import="util.Price"%>
<jsp:include page="WEB-INF/MyStyle.css"/>

<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report!</title>
<style>
table {
	border: 3px solid blue; padding: 2px 2px 2px 2px; background: grey; color: white; border-collapse: collapse;
}

td,th {
	border: 2px solid blue; padding: 5px 5px 5px 5px; background: grey; color: white;
	width: 130px; text-decoration: bold; width: 150px; text-align: center; vertical-align: middle;
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
			String Dept = request.getParameter("Dept");
			String Year = request.getParameter("Year");
		%>
		<h2>
			Report of
			<%=Dept%>
			Department -
			<%=Year%></h2>
		<table border=4>
			<tr>
				<th>Date</th>
				<th>Scientific eqp.</th>
				<th>Stationary eqp.</th>
				<th>Tools</th>
				<th>Price</th>
			</tr>
			<%
				Vector< Vector<String> > Sent = (Vector< Vector<String> >)request.getSession().getAttribute("Sent");
				Vector<String> Budget= (Vector<String>)request.getSession().getAttribute("Budget");
				int sc=0,st=0,tools=0,totalprice=0;
				for(int i=0;i<Sent.size();i++){
					out.print("<tr>");
					out.print("<td>"+Sent.get(i).get(5)+" </td>");
					for(int j=2;j+1<Sent.get(i).size();j++){
						out.print("<td>"+Sent.get(i).get(j)+" </td>");
					}
					sc+=Integer.parseInt(Sent.get(i).get(2));
					st+=Integer.parseInt(Sent.get(i).get(3));
					tools+=Integer.parseInt(Sent.get(i).get(4));
					Price price = (Price)request.getSession().getAttribute("Price");
					int t_price=( Integer.parseInt(Sent.get(i).get(2))*price.getSci_price()+Integer.parseInt(Sent.get(i).get(3))*price.getSta_price()+Integer.parseInt(Sent.get(i).get(4))*price.getTools_price() );
					totalprice+=t_price;
					out.print("<td>"+t_price+" </td>");
					
					out.print("</tr>");
				}
				out.print("<tr><td>Total</td> <td>"+sc+"</td><td>"+st+"</td><td>"+tools+"</td><td>"+totalprice+"</td></tr>");
				System.out.println("JSP - > budget = "+Budget.get(2));
				int Rem=Integer.parseInt( Budget.get(0) ) - totalprice;
			%>


		</table>
		<br><br>
		<strong>Total Budget Initiated = <%=Budget.get(0)%>Tk.</strong><br>
		<strong>Budget Used = <%=totalprice %>, Remaining Budget = <%=Rem %> </strong>
		<br><br><br>
		<a href=AdminHome.jsp>Back To Home</a>
	</center>
</body>
</html>
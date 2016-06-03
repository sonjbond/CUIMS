<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector"%>
<jsp:include page="WEB-INF/MyStyle.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Record Purchase Info</title>
</head>

<body bgcolor="cyan">
	<h1 align="center">Inventory Management System</h1>
	<h2 align="center">University of Chittagong</h2>
	<h4 align="center">Zobra, Hathazari,Chittagong - 4331</h4>
	<p align="center">This is Inventory Management System of Chittagong
		University</p>
	<br>
	<center>
		<form action="RecPurInfo" method="post" >
	
			<strong><font size=5 > Record Purchase Info</font></strong> <br>
			<strong><font size=3 >Please Enter Required Info and Click Record</font></strong>
			<br><br>
			Store Name:<input type="text"
				name="store" style='width: 190px; height: 23px'>
			<br><br>
			<strong>Purchase Details:</strong><br><br> Scientific:<input type="text"
				name="sci_equip" style='width: 80px; height: 23px'>
			Stationary:<input type="text" name="sta_equip"
				style="width: 80px; height: 23px"> Tools: <input type="text"
				name="tools" style="width: 78px; height: 23px"> <br> <br>
			Purchase Date:<select name="DD" style="width: 61px; ">
				<option>DD</option>
				<option value="1">01</option>
				<option value="2">02</option>
				<option value="3">03</option>
				<option value="4">04</option>
				<option value="5">05</option>
				<option value="6">06</option>
				<option value="7">07</option>
				<option value="8">08</option>
				<option value="9">09</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
			</select> <select name="MM" style="width: 103px; ">
				<option>MM</option>
				<option value="01">January</option>
				<option value="02">February</option>
				<option value="03">March</option>
				<option value="04">April</option>
				<option value="05">May</option>
				<option value="06">June</option>
				<option value="07">July</option>
				<option value="08">August</option>
				<option value="09">September</option>
				<option value="10">October</option>
				<option value="11">November</option>
				<option value="12">December
			</select> <select name="YY" style="width: 68px; ">
				<option>YY</option>
				<option value="2015">2015</option>
				<option value="2016">2016</option>
				<option value="2017">2017</option>
				<option value="2018">2018</option>
				<option value="2019">2019</option>
				<option value="2020">2020</option>
			</select> <br> <br>
			<input type=submit name=submit value=Record> <br> <br>
		</form>
		<br> <br>
		<a href=StuffHome.jsp >Back To Home</a>
		 <br>
	</center>
</body>
</html>
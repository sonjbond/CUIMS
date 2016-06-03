<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Multiple Button</title>
</head>
<body>
	<center>
		<form action="Test" method="post">
			<input name="MyName" value="SONJOY">
			<input name=but1 type="submit" value="sub1">
			<input name=but2 type="submit" value="sub1">
			<%
			//@page import = java.io.*
			//PrintWriter out = response.getWriter();
			out.print("<br>Hello");
			for(int i=0;i<5;i++){
				String S="<input name=button"+(i+1)+" type=submit value=submit"+(i+1)+">";
				out.print(S);
			}
			
			%>
		</form>
	</center>

</body>
</html>
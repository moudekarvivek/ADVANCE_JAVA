<%@ page errorPage="AdminError.jsp" %>

<html>

<head>
	<title>Admin Panel</title>
</head>

<body>
<%
	String user = request.getParameter("user");
	String pass = request.getParameter("pass");
	if(user.equals("admin") && pass.equals("admin"))
	{
%>
		<form action="http://localhost:8080/Admin.jsp" method="post">
		Add Event : <input type="text" name="event" required><br><br>
		<input type="submit" value="Submit">
		<input type="reset" value="Reset"><br>
		</form>
		<a href="A10Q1.html">Main Page</a>
<%
	}
	else
		throw new Exception("Invalid Credentials");
%>
</body>

</html>

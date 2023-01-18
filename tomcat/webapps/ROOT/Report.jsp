<%@ page import="java.sql.*" %>

<html>

<head>
	<title>Report</title>
</head>

<body>
<%
	Connection cn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");
%>
		<form action="http://localhost:8080/A10Report.jsp" method="post">
		<center><h1>Report</h1>
		<hr>
		<select name="event">
<%
		stmt = cn.createStatement();
		rs = stmt.executeQuery("select * from event");
		while(rs.next())
		{
%>	
			<option><% out.println(rs.getString(1)); %></option>
<%
		}
%>
		</select>
		<br><br>
		<input type="submit" value="Submit"><br>
		</form>
		<a href="A10Q1.html">Main Page</a><br>
		<a href="Admin.html">Admin Page</a></center>
<%
	}
	catch(SQLException e)
	{
		out.println(e);
	}
	catch(ClassNotFoundException ce)
	{
		out.println(ce);
	}
	finally
	{
		try
		{
			cn.close();
		}
		catch(SQLException e)
		{
			out.println(e);
		}
	}
%>
		

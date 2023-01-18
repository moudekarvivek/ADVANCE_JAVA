<%@ page import="java.sql.*" %>
<%@ page errorPage="AdminError.jsp" %>

<html>

<head>
	<title>Admin Panel</title>
</head>

<body>
<%
	Connection cn = null;
	PreparedStatement ps = null;
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");

		String event = request.getParameter("event");
		ps = cn.prepareStatement("insert into event values(?)");
		ps.setString(1,event);
		ps.executeUpdate();
		out.println("<h1>Event Added Successfully</h1><br>");
		out.println("<a href='A10Q1.html'>Main Page</a>");
	}
	catch(SQLIntegrityConstraintViolationException se)
	{
		throw new Exception("Event already exist");
	}
	catch(SQLException e)
	{
		throw new Exception(e);
	}
	catch(ClassNotFoundException ce)
	{
		throw new Exception(ce);
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
			

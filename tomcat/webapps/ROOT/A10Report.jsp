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
	String event = request.getParameter("event");
	String qry;
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");
		
		qry = "select s.* from student s, student_event se where s.roll_no = se.roll_no and se.event_name='"+event+"'";
		stmt = cn.createStatement();
		rs = stmt.executeQuery(qry);
		out.println("<h1>"+event+" Event Report</h1><hr>");
		if(rs.next())
		{
%>
		<table border=1>
			<tr>
				<th>Sr.No.</th>
				<th>Student Number</th>
				<th>Student Name</th>
				<th>Course Name</th>
			</tr>
<%
		int i=1;
		stmt = cn.createStatement();
		rs = stmt.executeQuery(qry);
		while(rs.next())
		{
%>
			<tr>
				<td><%= i++ %></td>
				<td><% out.println(rs.getString(1)); %></td>
				<td><% out.println(rs.getString(2)); %></td>
				<td><% out.println(rs.getString(3)); %></td>			
			</tr>
<%
		}
%>
		</table>
		<br>
<%
		}
		else
			out.println("<h4>No Record Found</h4>");
		out.println("<a href='Report.jsp'>Go Back</a><br><br>");
		out.println("<a href='AdminProf.html'>Admin Page</a>");
		out.println("<a href='main.html'>Main Page</a>");
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

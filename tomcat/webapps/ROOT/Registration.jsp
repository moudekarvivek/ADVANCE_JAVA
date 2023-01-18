<%@ page import="java.sql.*" %>

<html>

<head>
	<title>Registration Form</title>
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
		<form action="http://localhost:8080/Register.jsp" method="post">
		<h1>Registration Form</h1>
		<hr>
		<table>
			<tr>
				<td>Roll Number</td>
				<td> : <input type="text" name="rollNo"></td>
			</tr>
			<tr>
				<td>Student Name</td>
				<td> : <input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Course</td>
				<td> : <select name="course">
					<option>FYBSc Computer Science</option>
					<option>SYBSc Computer Science</option>
					<option>TYBSc Computer Science</option>
					<option>FY BCA</option>
					<option>SY BCA</option>
					<option>TY BCA</option>
					<option>FYMSc Computer Science</option>
					<option>SYMSc Computer Science</option>
					<option>FYMSc Computer Application</option>
					<option>SYMSc Computer Application</option> 
					<option>FYMSc IMCA</option>
					<option>SYMSc IMCA</option>
					<option>TYMSc IMCA</option>
				</td>
			</tr>
			<tr>
				<td>Event</td>
				<td> : <select name="event">
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
				</td>
			</tr>	
		</table><br>
		<input type="submit" value="Submit">
		<input type="reset" value="Reset"><br>
		</form>
		<a href="A10Q1.html">Main Page</a>
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
</body>

</html>

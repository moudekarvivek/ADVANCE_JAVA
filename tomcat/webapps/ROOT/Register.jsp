<%@ page import="java.sql.*" %>
<%@ page errorPage="A10Error.jsp" %>

<html>

<head>
	<title>Register</title>
</head>

<body>
<%
	Connection cn = null;
	PreparedStatement ps = null;
	Statement stmt = null;
	ResultSet rs = null;
	Statement stmt1 = null;
	ResultSet rs1 = null;
	String rn = request.getParameter("rollNo");
	String nm = request.getParameter("name");
	String co = request.getParameter("course");
	String ev = request.getParameter("event");
	
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");
		
		stmt = cn.createStatement();
		rs = stmt.executeQuery("select * from student_event where roll_no='"+rn+"' and event_name='"+ev+"'");
		stmt1 = cn.createStatement();
		rs1 = stmt1.executeQuery("select * from student where roll_no='"+rn+"' and course_name='"+co+"'");
		
		if(rs.next() && !rs1.next())
			throw new Exception("Student with this roll no already exist, please check course details");
			
		stmt = cn.createStatement();
		rs = stmt.executeQuery("select * from student_event where roll_no='"+rn+"' and event_name='"+ev+"'");
		stmt1 = cn.createStatement();
		rs1 = stmt1.executeQuery("select * from student where roll_no='"+rn+"' and course_name='"+co+"'");
		
		if(rs.next())
			throw new Exception("Student with this roll no already registered for this event");
			
		stmt = cn.createStatement();
		rs = stmt.executeQuery("select * from student_event where roll_no='"+rn+"' and event_name='"+ev+"'");
		stmt1 = cn.createStatement();
		rs1 = stmt1.executeQuery("select * from student where roll_no='"+rn+"' and course_name='"+co+"'");
		
		if(rs1.next())
		{
			ps = cn.prepareStatement("insert into student_event values(?,?)");
			ps.setString(1,rn);
			ps.setString(2,ev);
			ps.executeUpdate();
			out.println("<h1>Registration Successful</h1><br>");
			out.println("<a href='A10Q1.html'>Main Page</a>");
		}
		
		stmt = cn.createStatement();
		rs = stmt.executeQuery("select * from student_event where roll_no='"+rn+"' and event_name='"+ev+"'");
		stmt1 = cn.createStatement();
		rs1 = stmt1.executeQuery("select * from student where roll_no='"+rn+"' and course_name='"+co+"'");
		
		if(!rs.next() && !rs1.next())
		{ 
			stmt = cn.createStatement();
			rs = stmt.executeQuery("select * from student where roll_no='"+rn+"'");
			if(rs.next())
				throw new Exception("Student with this roll no already exist, please check course details");
			else
			{
				ps = cn.prepareStatement("insert into student values(?,?,?)");
				ps.setString(1,rn);
				ps.setString(2,nm);
				ps.setString(3,co);
				ps.executeUpdate();
				
				ps = cn.prepareStatement("insert into student_event values(?,?)");
				ps.setString(1,rn);
				ps.setString(2,ev);
				ps.executeUpdate();
				out.println("<h1>Registration Successful</h1>");
				out.println("<a href='A10Q1.html'>Main Page</a>");
			}
		}
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
			throw new Exception(e);
		}
	}
%>
</body>

</html>			

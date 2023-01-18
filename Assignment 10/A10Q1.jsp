<%@ page session="false"%>
<%@ page errorPage="A10Error.jsp"%>
<%@ page import="java.sql.*"%>

<html>
	<head><title> Success </title></head>
	<body>
		<%
			Connection cn = null;
            PreparedStatement ps = null;
            Statement st = null;
            String qry = null; 

			int rn = Integer.parseInt(request.getParameter("rollno"));
            String fn = request.getParameter("fname");
            String ln = request.getParameter("lname");
            String phn = request.getParameter("phone");
            String cou = request.getParameter("course");
			String yr = request.getParameter("year");
            String comp = request.getParameter("competition");

			if(cou != null && yr != null)
        	{
        		if((cou.equals("MCA") || cou.equals("MCS") || cou.equals("MSc(DS)")) && yr.equals("TY"))
       			{
            		throw new Exception("MSc Courses are of two years only");
       			}
        		else
        		{
            
					try
					{
						Class.forName("com.mysql.cj.jdbc.Driver");
						cn = DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");
						qry = "insert into registration values(?,?,?,?,?,?,?)";
						ps = cn.prepareStatement(qry);

						ps.setInt(1,rn);
						ps.setString(2,fn);
						ps.setString(3,ln);
						ps.setString(4,phn);
						ps.setString(5,cou);
						ps.setString(6,yr);
						ps.setString(7,comp);
						
						ps.executeUpdate();

        %>
               <center><h1>You are successfully registered for the competition!!</h1></center>

               <center><h3>Our team will contact you shortly</h3></center>
               <br><br><a href=A10Q1.html>Go Back</a>
			   <br><br><a href=A10.html>Main Page</a>

        <%
					}
					catch(SQLIntegrityConstraintViolationException err)
					{
						throw new Exception("Already Registered for selected compition..");
					}
					catch(Exception e)
					{
						throw new Exception(e);
					}
				}
			}
		%>
	</body>
</html>


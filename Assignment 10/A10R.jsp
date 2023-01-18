<%@ page session="false"%>
<%@ page import="java.sql.*"%>
000000
<html>
	<head><title> Success </title></head>
	<body>
		<%
            Connection cn = null;
            Statement st = null;
            ResultSet rs = null;
            String qry = null;
            int r = Integer.parseInt(request.getParameter("a1"));
            int i = 0;
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
 				cn = DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");
		
			if(r == 4)
			{
				qry = "select * from registration where  comp = 'Bits and Bytes'";
                st = cn.createStatement();
				rs = st.executeQuery(qry);
        %>

                <h1>Bits and Bytes Registration</h1><br>
                <table border=1>
                    <tr>
                        <th>SR No.</th>
                        <th>Roll No</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone No</th>
                        <th>Course</th>
                        <th>Year</th>
                    </tr>
                    
            <%
                i = 1;
                while(rs.next())
                {
                    
            %>
                    <tr>
                        <td><% out.println(i); %></td>
                        <td><% out.println(rs.getInt("rollno")); %></td>
                        <td><% out.println(rs.getString("fname")); %></td>
                        <td><% out.println(rs.getString("lname")); %></td>
                        <td><% out.println(rs.getString("phone")); %></td>
                        <td><% out.println(rs.getString("course")); %></td>
                        <td><% out.println(rs.getString("year")); %></td>
                    </tr>
                    
            <%
                i++;
                }
            %>
                </table>
                <br>
                <br><br><a href=A10R.html>Go Back</a>
            
            
       
            <%
                }
                else if(r == 2)
                {
                    qry = "select * from registration where  comp = 'Project Competition'";
                    st = cn.createStatement();
                    rs = st.executeQuery(qry);
            %>

                <h1>Project Competition Registration</h1><br>
                <table border=1>
                    <tr>
                        <th>SR No.</th>
                        <th>Roll No</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone No</th>
                        <th>Course</th>
                        <th>Year</th>
                    </tr>
                    
            <%
                i = 1;
                while(rs.next())
                {
                    
            %>
                    <tr>
                        <td><% out.println(i); %></td>
                        <td><% out.println(rs.getInt("rollno")); %></td>
                        <td><% out.println(rs.getString("fname")); %></td>
                        <td><% out.println(rs.getString("lname")); %></td>
                        <td><% out.println(rs.getString("phone")); %></td>
                        <td><% out.println(rs.getString("course")); %></td>
                        <td><% out.println(rs.getString("year")); %></td>
                    </tr>
                    
            <%
                i++;
                }
            %>
                </table>
                <br>
                <br><br><a href=A10R.html>Go Back</a>

         
            <%
                }
                else if(r == 1)
                {
                    qry = "select * from registration where  comp = 'Programming Competition'";
                    st = cn.createStatement();
                    rs = st.executeQuery(qry);
            %>

                    <h1>Programming Competition Registration</h1><br>
                    <table border=1>
                        <tr>
                            <th>SR No.</th>
                            <th>Roll No</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Phone No</th>
                            <th>Course</th>
                            <th>Year</th>
                        </tr>
                        
            <%
                    i = 1;
                    while(rs.next())
                    {
                        
            %>
                        <tr>
                            <td><% out.println(i); %></td>
                            <td><% out.println(rs.getInt("rollno")); %></td>
                            <td><% out.println(rs.getString("fname")); %></td>
                            <td><% out.println(rs.getString("lname")); %></td>
                            <td><% out.println(rs.getString("phone")); %></td>
                            <td><% out.println(rs.getString("course")); %></td>
                            <td><% out.println(rs.getString("year")); %></td>
                        </tr>
                        
            <%
                    i++;
                    }
            %>
                    </table>
                    <br>
                    <br><br><a href=A10R.html>Go Back</a>

          
            <%
                }
                else
                {
                    qry = "select * from registration where  comp = 'Encryption and Decryption'";
                    st = cn.createStatement();
                    rs = st.executeQuery(qry);
            %>

                <h1>Encryption and Decryption Registration</h1><br>
                <table border=1>
                    <tr>
                        <th>SR No.</th>
                        <th>Roll No</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone No</th>
                        <th>Course</th>
                        <th>Year</th>
                    </tr>
                    
            <%
                i = 1;
                while(rs.next())
                {
                    
            %>
                    <tr>
                        <td><% out.println(i); %></td>
                        <td><% out.println(rs.getInt("rollno")); %></td>
                        <td><% out.println(rs.getString("fname")); %></td>
                        <td><% out.println(rs.getString("lname")); %></td>
                        <td><% out.println(rs.getString("phone")); %></td>
                        <td><% out.println(rs.getString("course")); %></td>
                        <td><% out.println(rs.getString("year")); %></td>
                    </tr>
                    
            <%
                i++;
                }
            %>
                </table>
                <br>
                <br><br><a href=A10R.html>Go Back</a>
        
            <%
                }						
                }
                catch(Exception e)
                {
                    out.println(e);
                }
                finally
                {
                    try
                    {
                        cn.close();
                        rs.close();
                    }
                    catch(SQLException se)
                    {
                        out.println(se);
                    }
                }
		%>
	</body>
</html>


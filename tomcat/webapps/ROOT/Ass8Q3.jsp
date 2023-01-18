<%@ page session="false"%>
<%@ page import="java.sql.*"%>

<html>
	<head><title> Entity Relationship </title></head>
	<style>
		h1{color : darkorange; text-align: center;}
		table
		{
			background-color:lightblue;
		}
	</style>
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
				cn=DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");
		
			if(r == 1)
			{
				qry = "select * from Employe";
				
				st = cn.createStatement();
				rs = st.executeQuery(qry);
		%>
			<center>
			<h1>Database Details</h1><br>
			<h3>Employee Table</h3>
			<table border=1>
				<tr>
					<th>SR No.</th>
					<th>Emp ID</th>
					<th>Emp Name</th>
					<th>Emp Salary</th>
					<th>Dept No</th>
				</tr>
				
		<%
			i = 1;
			while(rs.next())
			{
				
		%>
				<tr>
					<td><% out.println(i); %></td>
					<td><% out.println(rs.getInt("eno")); %></td>
					<td><% out.println(rs.getString("ename")); %></td>
					<td><% out.println(rs.getInt("sal")); %></td>
					<td><% out.println(rs.getInt("dno")); %></td>
				</tr>
				
		<%
			i++;
			}
		%>
			</table>
			</center>
			<br>
		<%
			qry = "select * from Department";
			st = cn.createStatement();
			rs = st.executeQuery(qry);
		%>
			<center>
			<h3>Department Table</h3>
			<table border=1>
				<tr>
					<th>SR No.</th>
					<th>Dept No</th>
					<th>Dept Name</th>
				</tr>
				
		<%
			i = 1;
			while(rs.next())
			{
				
		%>
				<tr>
					<td><% out.println(i); %></td>
					<td><% out.println(rs.getInt("dno")); %></td>
					<td><% out.println(rs.getString("dname")); %></td>
				</tr>
				
		<%
			i++;
			}
		%>
			</table>
			</center>
			<br>
		<%
			qry = "select * from Project";
			st = cn.createStatement();
			rs = st.executeQuery(qry);
		%>
			<center>
			<h3>Project Table</h3>
			<table border=1>
				<tr>
					<th>SR No.</th>
					<th>Project Name</th>
					<th>No of days</th>
				</tr>
				
		<%
			i = 1;
			while(rs.next())
			{
				
		%>
				<tr>
					<td><% out.println(i); %></td>
					<td><% out.println(rs.getString("pname")); %></td>
					<td><% out.println(rs.getInt("no_of_days")); %></td>
				</tr>
				
		<%
			i++;
			}
		%>
			</table>
			</center>
			<br>
		<%
			qry = "select * from emp_pro";
			st = cn.createStatement();
			rs = st.executeQuery(qry);
		%>
			<center>
			<h3>Emp_Project Table</h3>
			<table border=1>
				<tr>
					<th>SR No.</th>
					<th>Project name</th>
					<th>Employee ID</th>
				</tr>
				
		<%
			i = 1;
			while(rs.next())
			{
				
		%>
				<tr>
					<td><% out.println(i); %></td>
					<td><% out.println(rs.getString("pname")); %></td>
					<td><% out.println(rs.getInt("eno")); %></td>
				</tr>
				
		<%
			i++;
			}
		%>
			</table>
			</center>
			<center>
			<br><br><button><a href=Ass8Q3.html>Go Back</a></button>
		<%
			}
			else if(r == 2)
			{
				qry = "select e.* from Employe e,Project p,emp_pro ep where e.eno = ep.eno and p.pname = ep.pname and ep.pname = 'Inventory control project'";
				st = cn.createStatement();
				rs = st.executeQuery(qry);
		%>
			<br>
			</center>
			<center>			
			<h3>1. Details of all employees working on Inventory control project</h3></br>
			<table border=1>
				<tr>
					<th>SR No.</th>
					<th>Emp ID</th>
					<th>Emp Name</th>
					<th>Emp Salary</th>
					<th>Dept No</th>
				</tr>
				
		<%
			i = 1;
			while(rs.next())
			{
				
		%>
				<tr>
					<td><% out.println(i); %></td>
					<td><% out.println(rs.getInt("eno")); %></td>
					<td><% out.println(rs.getString("ename")); %></td>
					<td><% out.println(rs.getInt("sal")); %></td>
					<td><% out.println(rs.getInt("dno")); %></td>
				</tr>
				
		<%
			i++;
			}
		%>
			</table>
			</center>
			<center>
			<br><button><a href=Ass8Q3.html>Go Back</a></button>

		<%
			}
			else
			{
					qry = "select * from Employe where dno in(select dno from Department where dname = 'CA')";
					st = cn.createStatement();
					rs = st.executeQuery(qry);

		%>
				<br>
			</center>
			<center>
				<h3>2. Details of all employees of Computer Department</h3></br>
				<table border=1>
					<tr>
						<th>SR No.</th>
						<th>Emp ID</th>
						<th>Emp Name</th>
						<th>Emp Salary</th>
					</tr>
					
		<%
				i = 1;
				while(rs.next())
				{
					
		%>
					<tr>
						<td><% out.println(i); %></td>
						<td><% out.println(rs.getInt("eno")); %></td>
						<td><% out.println(rs.getString("ename")); %></td>
						<td><% out.println(rs.getInt("sal")); %></td>
					</tr>
					
		<%
				i++;
				}
		%>
				</table>
				</center>
				<center>
				<br><button><a href=Ass8Q3.html>Go Back</a></button>
				</center>
		<%
			}						
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				try
				{
					cn.close();
				}
				catch(SQLException se)
				{
					System.out.println(se);
				}
			}
		%>
	</body>
</html>



	

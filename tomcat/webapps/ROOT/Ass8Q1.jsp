<html>

<body>
	<head><title> Information about Database </title></head>
<style>

	table
	{
		border-collapse:collapse;
		background-color:yellow;
	}
</style>

<%@page import="java.sql.*"%>
<%
	Connection con=null;
	try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");
			
			
			DatabaseMetaData dbmt=con.getMetaData();
%>
			<center>
			<h1>Information about Database</h1>
		
			<table border=1>

			<tr><th>Database Information</th><th>Output</th></tr>
			<tr><td>Database driver name</td><td><% out.println(dbmt.getDriverName());%></td></tr>
			<tr><td>Database driver version</td><td><% out.println(dbmt.getDriverVersion());%></td></tr>
			<tr><td>Database Username</td><td><% out.println(dbmt.getUserName());%></td></tr>			
			<tr><td>Database Product name</td><td><% out.println(dbmt.getDatabaseProductName());%></td></tr>		
			
			</table>

			<br><br>
<%
			ResultSet tbls=dbmt.getTables(null,null,null,new String[]{"TABLE"});
%>
			<h2>Tables in database are </h2>
		
			<table border=1>
			<tr>
					<th>Sr.no</th>			
					<th>Table names</th>
				</tr>

<%
			int i=1;
			while(tbls.next())
			{
				
%>
				<tr>	
					<td><% out.println(i); %></td>
					<td><% out.println("   "+tbls.getString("Table_NAME"));%></td>
				</tr>
<%
				i++;
				
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
					con.close();
				}
				catch(SQLException se)
				{
					System.out.println(se);
				}
		}
%>

</body>
</html>

<%@ page session="false"%>
<%@ page import="java.sql.*"%>

<html>
	<head><title> Product </title></head>
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
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");
				
				String qry = "select * from product";
				Statement st = cn.createStatement();
				ResultSet rs = st.executeQuery(qry);
		%>
			<br>

			<h1>Product Table</h1></br>
			<center>			
			<table border=1>
				<tr>
					<th>Sr No.</th>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Quantity</th>
				</tr>
				
		<%
			int i = 1;
			while(rs.next())
			{
				
		%>
				<tr>
					<td><% out.println(i); %></td>
					<td><% out.println(rs.getInt("ProdID")); %></td>
					<td><% out.println(rs.getString("name")); %></td>
					<td><% out.println(rs.getInt("price")); %></td>
					<td><% out.println(rs.getInt("quantity")); %></td>
				</tr>
		<%
			i++;
			}
		%>
			</table>
			</center>
		<%						
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

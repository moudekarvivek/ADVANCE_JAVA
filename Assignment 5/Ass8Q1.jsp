<%@ page session="false"%>
<%@ page import="java.sql.*"%>

<html>
<body>
	<%
		Connection cn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/syca221574","syca221574","");
			DatabaseMetaData dbmt = cn.getMetaData();
			ResultSet rs = dbmt.getTables(null,null,null,new String[]{"TABLE"});
	%>

	<h3>Database Information</h3><br>
		<table border="1">
		<tr>
			<th>Sr No.</th>
			<th>Database Information</th>
			<th>Output</th>
		</tr>
		<tr>
			<td>1</td>
			<td>Database Driver Name</td>
			<td><% out.println(dbmt.getDriverName()); %></td>
		</tr>
		<tr>
			<td>2</td>
			<td>Database Driver Version</td>
			<td><% out.println(dbmt.getDriverVersion()); %></td>
		</tr>
		<tr>
			<td>3</td>
			<td>Database UserName</td>
			<td><% out.println(dbmt.getUserName()); %></td>
		</tr>
		</td>
	%>
		</td>
		<tr>
			<td>4</td>
			<td>Database Product Name</td>
			<td><% out.println(dbmt.getDatabaseProductName()); %>
		</tr>
		<tr>
			<td>5</td>
			<td>Database Product Version</td>
			<td><% out.println(dbmt.getDatabaseProductVersion());
			%></td>
		</tr>
	</table>

	<br>
		<h3>Table Name</h3><br>
		<table border="1">
			<tr>
				<th>Sr No.</th>
				<th>Table Name</th>
			</tr>
			<%
		int i = 1;
		while(rs.next()) {
			<tr>
				<td><% out.println(i); %></td>
				<td><% out.println(rs.getString("TABLE_NAME")); %>
			</tr>
			i++;
		}
	</table>
		}
	catch(Exception e) {
		out.println(e);
	}
	finally {
		try {
			cn.close();
		} catch(SQLException se) {
			out.println(se);
		}
	}

%>

</body>
</html>

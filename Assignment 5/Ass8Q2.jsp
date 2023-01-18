<%@ page session = "false" %>
<%@ page import = "java.sql.*" %>
<html>
<head><title>Product Details</title></head>
<body>
<%
Connection cn = null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
cn =
DriverManager.getConnection("jdbc:mysql://localhost:3306/syca221574","syca221574","");
String qry = "select * from product";
Statement st = cn.createStatement();
ResultSet rs = st.executeQuery(qry);
%>
<h3>Product Table Deatils From Database</h3><br>
<table border="1">
<tr>
<th>SR No.</th>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Price</th>
<th>Product Quantity</th>
</tr>
<%
%>
<%
%>
<%
%>
</body>
</html>
int i = 1;
while(rs.next())
{
<tr>
<td><%
<td><%
<td><%
<td><%
<td><%
</tr>
out.println(i); %></td>
out.println(rs.getInt("pid")); %></td>
out.println(rs.getString("name")); %></td>
out.println(rs.getInt("price")); %></td>
out.println(rs.getInt("quantity")); %></td>
i++;
}
</table>
rs.close();
st.close();
}
catch(ClassNotFoundException ce){}
catch(SQLException se){}
</dl>

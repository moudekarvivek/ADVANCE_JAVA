import java.sql.*;

class Q3
{
	public static void main(String args[])
	{
		Connection cn=null; 
		Statement stmt=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Found");
		
		cn=DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");

		System.out.println("Connection Found");
		
		stmt=cn.createStatement();
		rs=stmt.executeQuery("select *from employee");
		
		rsmd=rs.getMetaData();
		int noOfColumns=rsmd.getColumnCount();
		System.out.println("Number of Coloumns="+noOfColumns);
		
		for(int i=1;i<=noOfColumns;i++)
		{
			System.out.println("Coloumn no."+ i);
			System.out.println("\tColoumn name."+ rsmd.getColumnName(i));
			System.out.println("\tColoumn Type."+ rsmd.getColumnTypeName(i));
			System.out.println("\tColoumn displaysize."+ rsmd.getColumnDisplaySize(i));
		
		}
		
	}
	catch(SQLException se)
	{
		System.out.println(se);
	}
	catch(ClassNotFoundException ce)
	{
		System.out.println(ce);
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
	}
	

}

import java.sql.*;
import java.io.*;
import java.lang.*;

class Q1
{
	public static void main(String[] args)throws Exception
	{
		Connection cn=null;
		ResultSet rs=null;
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Found");

			cn=DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");
			System.out.println("found");

			DatabaseMetaData dbmd=cn.getMetaData();

			System.out.println("Database Product Name=" + dbmd.getDatabaseProductName());
			System.out.println("Database username:" + dbmd.getUserName());
			System.out.println("Database Driver Name:" + dbmd.getDriverName());
			System.out.println("Database Driver version:" + dbmd.getDriverVersion());
			System.out.println("database product name:" + dbmd.getDatabaseProductName());

			rs=dbmd.getTables(null,null,null,new String[]{"TABLE"});
			
			while(rs.next())
			{
				String tblName=rs.getString("TABLE_NAME");
				System.out.println("Table:" +tblName);
			}
			cn.close();
		}
		catch(SQLException se)
		{
		}
	} 
}

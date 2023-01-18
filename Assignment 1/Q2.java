import java.sql.*;
import java.io.*;
import java.net.*;

class Q2
{
	public static void main(String args[])throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Found");
		try
		{
		Connection cn=DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");
		
		Statement stmt=cn.createStatement();

		String q="create table employee(empid int primary key,empname varchar(30),salary int)";		
		stmt.executeUpdate(q);

		System.out.println("Table is Created in Database");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

}

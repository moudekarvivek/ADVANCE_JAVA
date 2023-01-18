import java.sql.*;
import java.io.*;
import java.net.*;

class Q1
{
	public static void main(String args[]) throws Exception
	{

		Connection cn = null;
		ResultSet rs = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String q;

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Found");
			cn = DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");
			System.out.println("Connection Found");		
			stmt = cn.createStatement();
			int choice, last_emp=0;

			do {
				System.out.println("\n1. Insert\n2. Delete\n3. Exit\nEnter choice: ");			
				choice = Integer.parseInt(br.readLine());
				switch(choice) {
					case 1: q = "select * from employee";
							rs = stmt.executeQuery(q);
							while(rs.next())
								last_emp = rs.getInt(1);

							last_emp = last_emp + 1;

				
					System.out.println("Employee: " + last_emp);
					System.out.println("Enter employee name");
					String name = br.readLine();

					System.out.println("Enter salary: ");
					int sal;

					while(true) {
						sal = Integer.parseInt(br.readLine());
	
						if(sal>0) 
							break;
						else
							System.out.println("Invalid salary, please reenter"); 
					}

					q = "insert into employee values(?,?,?)";
					pstmt = cn.prepareStatement(q);
					pstmt.setInt(1,last_emp);
					pstmt.setString(2,name);
					pstmt.setInt(3,sal);
					int a = pstmt.executeUpdate();
					break;

					case 2: System.out.println("Enter employee id to delete: ");
							int id = Integer.parseInt(br.readLine());
							q = "delete from employee where empid='"+id+"'";
							int n = stmt.executeUpdate(q);

							if(n==0) 
								System.out.println("Record not found");
							else
								System.out.println("Record deleted");
							break;
					case 3: System.exit(0);
				}
			} while(choice<4);
		} catch(Exception e) {
			System.out.println("Exception is "+e);
		}

		finally {
			try {
				cn.close();
			} catch(Exception e) {
				System.out.println("Exception is finally is "+e);
			}		
		}
	}
}



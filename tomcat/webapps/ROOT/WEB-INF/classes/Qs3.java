import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Qs3 extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://192.168.28.3:3306/syca221574","syca221574","");
			
			String login = req.getParameter("login");
			String pass = req.getParameter("pass");

			String qry="select * from login where login_name='"+login+"' and password ='"+pass+"'";

			Statement stmt = con.createStatement();

			HttpSession session = req.getSession();
			ResultSet rs = stmt.executeQuery(qry);
			if(rs.next())
			{
				session.setAttribute("username",rs.getString("login_name"));
				res.sendRedirect("/welcome") ;
			}
			else
			{
				res.sendRedirect("http://localhost:8080/displayerror.html");
			}
		}
		catch(Exception e)
		{
			pw.println(e);
		}
	}
}
			

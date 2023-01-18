import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class welcome extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		HttpSession session =req.getSession(false);
		if(session!=null)
		{
			String name = (String) session.getAttribute("username");
			pw.println("<html><body>");			
			pw.println("<b>Welcome "+name);	
			pw.println("</b></body></html>");
		}
	}
}

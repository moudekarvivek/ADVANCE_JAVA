import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Qs2 extends HttpServlet
{
	int i=1;
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
		String ip=req.getRemoteAddr();
		Cookie c = new Cookie("visit", String.valueOf(i));
		res.addCookie(c);
		
		int j = Integer.parseInt(c.getValue());

		if(j==1)
			out.println("welcome "+ip);	
		else 
			out.println("welcome back "+ip);

		i++;
	}
}

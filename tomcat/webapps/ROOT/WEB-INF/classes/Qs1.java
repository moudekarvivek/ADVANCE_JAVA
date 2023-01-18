import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Qs1 extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("html/text");
		String name=req.getParameter("username");
		Calendar c=Calendar.getInstance();
		int hr=c.get(Calendar.HOUR_OF_DAY);

		String greet="";

		if(hr<12 && hr>0)
			greet="Good morning";
		else if(hr>=12 && hr<=17)
			greet="Good afternoon";
		else
			greet="Good Evening";

		PrintWriter out=res.getWriter();
		out.println(greet+" "+name);
		out.close();
	}
}

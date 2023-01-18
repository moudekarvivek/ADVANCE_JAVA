import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
 
public class mall extends HttpServlet
{
  public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    HttpSession session = req.getSession(true);
 
    String mall1Total[] = req.getParameterValues("m1");
    String mall2Total[] = req.getParameterValues("m2");
    
    int total1 = 0;
    int total2 = 0;

    if(mall1Total != null)
    {
      for(int i=0;i<mall1Total.length;i++)
      {
        total1 += Integer.parseInt(mall1Total[i]);
      }
      session.setAttribute("total1",total1);
      if(total1 != 0)
      {
        out.println("Total Purchase from page 1 ===> "+total1+"<br><br>");
        out.println("<a href='mall1.html'>Page 1</a>");
        out.println("<a href='mall2.html'>Page 2</a>");
      }
    }
    if(mall2Total != null)
    {
      for(int i=0;i<mall2Total.length;i++)
      {
        total2 += Integer.parseInt(mall2Total[i]);
      }
      session.setAttribute("total2",total2);
      if(total2 != 0)
      {
        out.println("Total Purchase from page 2 ===> "+total2+"<br><br>");
        out.println("<a href='mall1.html'>Page 1</a>");
        out.println("<a href='mall2.html'>Page 2</a>");
        out.println("<a href='http://localhost:8080/finalBill'>Final Bill</a>");
      }
    }
  }
}  

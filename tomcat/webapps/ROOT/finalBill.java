import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class finalBill extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HttpSession session = req.getSession(true);

        String n1= String.valueOf(session.getAttribute("total1"));  
        String n2= String.valueOf(session.getAttribute("total2"));  
        
        out.println("<h4> Page 1 Total : "+n1+"</h4><br>");
        out.println("<h4> Page 2 Total : "+n2+"</h4><br><hr>");
        out.println("<h4> Total Bill : "+String.valueOf(Integer.parseInt(n1)+Integer.parseInt(n2))+"</h4>");
    }
}

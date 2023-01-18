<%@ page language="java" import="java.util.*" %>
<%@ page errorPage="errorPage.jsp" %>

<html>
	<%
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int r = Integer.parseInt(request.getParameter("r"));
		
		if(r==1) 
		{
	%>
		<h1>Addition= <%= num1+num2 %></h1>
	<%
		}
		else if(r==2)
		{
	%>
		<h1>Subtraction= <%= num1-num2 %></h1>
	<%
		}
		else if(r==3)
		{
	%>
		<h1>Multiplication= <%= num1*num2 %></h1>
	<%
		}
		else
		{
			if(num2==0)
			{
				throw new Exception("Denominator should not be zero");
			}
	%>
		<h1>Division= <%= num1/num2 %></h1>
	<%
		}
	%>
</html>

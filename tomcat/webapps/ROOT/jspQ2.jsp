<%@ page language="java" import="java.util.*" %>
<%!
	Calendar c = Calendar.getInstance();
	int hr = c.get(Calendar.HOUR_OF_DAY);
%>
<%
	String name=request.getParameter("name");
	if(hr>=0 && hr<12)
	{
%>
	<h1>Good morning <%=name %></h1>
<%
	}
	else if(hr>=12 && hr<15)
	{
%>
	<h1>Good afternoon <%=name %></h1>
<%
	}
	else
	{
%>
	<h1>Good evening <%=name %></h1>
<%
	}
%>

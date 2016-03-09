<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" import = "javax.servlet.RequestDispatcher" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post"></form>

 <%
 	
	HttpSession session = request.getSession(false);
	if(session==null)
	{%>
		<a href="login.jsp">CLICK HERE TO LOGIN</a><br/><br/>
		<a href="register.jsp">CLICK HERE TO REGISTER</a>
		
	<% }
	else
	{
		//System.out.println("hii else");
		String email = (String)session.getAttribute("emailid");
		String pass = (String)session.getAttribute("password");
		//System.out.println(email);
		RequestDispatcher rd = request.getRequestDispatcher("/login1");
		request.setAttribute("email", email);
		request.setAttribute("pass", pass);
		rd.forward(request,response);
		
		
	}


%>
 


</body>
</html>
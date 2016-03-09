<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" import = "javax.servlet.RequestDispatcher" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">


<%
HttpSession session = request.getSession(false);
if(session == null)
{%>

Email ID : <input type ="text" name = "email"><br/>
PASSWORD : <input type = "password" name ="pass"><br/>
<input type = "submit" value = "LOGIN">
<%}
else
{
	String email = (String)session.getAttribute("emailid");
	String pass = (String)session.getAttribute("password");
	//System.out.println(email);
	RequestDispatcher rd = request.getRequestDispatcher("/login1");
	request.setAttribute("email", email);
	request.setAttribute("pass", pass);
	rd.forward(request,response);
}


 %>

</form>
</body>
</html>
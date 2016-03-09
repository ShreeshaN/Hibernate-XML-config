<%@page import="com.rzt.utils.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit your profile and click on save !!</h1>
<% HttpSession session = request.getSession(false); %>
<form action="edit" method ="post">
First name : <input type = "text" name = "fname" value = "<%=session.getAttribute("fname") %>" ><br/>
Last name : <input type = "text" name = "lname" value = "<%=session.getAttribute("lname") %>"><br/>
Age : <input type = "text" name = "age" value = "<%=session.getAttribute("age") %>"><br/>
Email ID : <input type = "text" name = "emailId" value = "<%=session.getAttribute("emailid") %>"><br/>

<input type = submit value = "SAVE">



</form>
</body>
</html>
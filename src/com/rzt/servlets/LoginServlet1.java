package com.rzt.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rzt.beans.EmployeeDetails;
import com.rzt.utils.LoginManager;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */RequestDispatcher rd = null;
		PrintWriter out = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hi aNIAH");
		
		String email = (String)request.getAttribute("email");
		String password = (String)request.getAttribute("pass");
		int hash = password.hashCode();
		hash = hash+65656;
		out = response.getWriter();
		LoginManager manager = new LoginManager();
		if(manager.isValid(email,hash))
		{
			EmployeeDetails em = manager.getData(email);
			String name = em.getFirstName()+" "+em.getLastName();
			
			out.println("<h1>Welcome "+name);
			HttpSession session = request.getSession(true);
			session.setAttribute("fname", em.getFirstName());
			session.setAttribute("lname", em.getLastName());
			session.setAttribute("age", em.getAge());
			session.setAttribute("emailid", email);
			session.setAttribute("password", password);
			
			
			out.println("<a href=logout.jsp><h1>LOGOUT</h1></a>");
			out.println("<a href=editProfile.jsp>EDIT PROFILE</a>");

			
			//Map<String,String> hash = new HashMap<String,string>();
			/*Cookie c = new Cookie("sessionId",id);
			c.setMaxAge(60*60);
			response.addCookie(c);*/
			
		}
		else
		{
			out.println("Please register yourself");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//System.out.println("hello log");
		
	
			
			
		
		
	}
}
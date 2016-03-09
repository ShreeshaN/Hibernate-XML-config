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
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	RequestDispatcher rd = null;
	PrintWriter out = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//System.out.println("hello log");
		
		HttpSession s = request.getSession(false);
		if(s==null)
		{
			//System.out.println("if");
			String email = request.getParameter("email");
			String password = request.getParameter("pass");
			int hash = password.hashCode();
			hash = hash+65656;
			out = response.getWriter();
			LoginManager manager = new LoginManager();
			if(manager.isValid(email,hash))
			{
				EmployeeDetails em = manager.getData(email);
				//System.out.println(em.getEmployeeId());
				String name = em.getFirstName()+" "+em.getLastName();
				
				out.println("<h1>Welcome "+name);
				HttpSession session = request.getSession(true);
				session.setAttribute("fname", em.getFirstName());
				session.setAttribute("lname", em.getLastName());
				session.setAttribute("age", em.getAge());
				session.setAttribute("emailid", email);
				session.setAttribute("password", password);
				session.setAttribute("id",em.getEmployeeId());
				
				out.println("<a href=logout.jsp><h1>LOGOUT</h1></a>");
				out.println("<a href=editProfile.jsp>EDIT PROFILE</a>");
				
				
			}
			
			else
			{
				out.println("Please register yourself");
				response.sendRedirect("index1.jsp");
			}
		}
		/*else if(s.getAttribute("emailid")==null)
		{
			response.sendRedirect("index.jsp");
		}*/
		
		else
		{
			String email = (String)s.getAttribute("emailid");
			String pass = (String)s.getAttribute("password");
			//System.out.println(email);
			RequestDispatcher rd = request.getRequestDispatcher("/login1");
			request.setAttribute("email", email);
			request.setAttribute("pass", pass);
			rd.forward(request,response);
		}
		
		
	}
}

package com.rzt.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rzt.beans.EmployeeDetails;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RegisterServlet() {
        super();
       
    }
    
    public void init()
    {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("hello reg");
		
		HttpSession s = request.getSession(false);
		if(s==null)
		{
			//System.out.println("i");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String password = request.getParameter("pass");
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("emailId");
			
			String name = fname+" " + lname;
			//System.out.println(name);
			
		/*	HttpSession sessionUser = request.getSession();
			sessionUser.setAttribute("email address", email);
			sessionUser.setAttribute("username", name);
			sessionUser.setAttribute("password",password);*/
			
			EmployeeDetails employeeDetails = new EmployeeDetails();
			employeeDetails.setFirstName(fname);
			employeeDetails.setLastName(lname);
			employeeDetails.setPassword(password);
			employeeDetails.setAge(age);
			employeeDetails.setEmail(email);
			
			
			SessionFactory sessionFactory=null;
		    Session session=null;
	    	sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(employeeDetails);
			session.getTransaction().commit();
			
			
		
			PrintWriter writer = response.getWriter();
			writer.println("<h1>Successfully Registered !</h1>");
			writer.println("<a href='index.jsp'>Click here and login</a> ");
		}
		
		
		else
		{
			//System.out.println("else");
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

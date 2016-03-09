package com.rzt.utils;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rzt.beans.EmployeeDetails;

public class LoginManager {
	
	private int count=0;
	int empId=0;
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	String emailId=null;
	String password=null;
	String name = null;
	EmployeeDetails em1=null;
	
	
	public boolean isValid(String e, int p)
	{
		
		
		String query = "select email,password from EmployeeDetails where email='" + e + "' and password='" + p + "'";
		Query DbQuery = session.createQuery(query);
		for(Iterator itr = DbQuery.iterate();itr.hasNext();)
		{
			itr.next();
			count++;
		}
		if(count==1)
		{
		//	System.out.println(count++);
			return true;
		}
		else 
			return false;
		
		
		//return true;
	}
	
	
	public EmployeeDetails getData(String e)
	{
		
		String name =null;
		int age;
		String email=null;
		String fname=null;
		String lname=null;
		String query ="FROM EmployeeDetails where email='"+e+"'";
		Query DbQuery = session.createQuery(query);
		List<EmployeeDetails> list = (List<EmployeeDetails>)DbQuery.list();
	
		for(EmployeeDetails em: list)
		{
			age = em.getAge();
			name = em.getFirstName()+" "+em.getLastName();
			email = e;
			fname = em.getFirstName();
			lname = em.getLastName();
			
			
			System.out.println(empId + "hello");
		//	String password = em.getPassword();
			
			em.setAge(age);
			em.setEmail(email);
			em.setFirstName(fname);
			em.setLastName(lname);
			em.setEmployeeId(em.getEmployeeId());
			//System.out.println(name);
			em1=em;
		}
		return em1 ;
		
		
	}
	
	public void editMe(HttpServletRequest request)
	{
		
		String fname =(String)request.getParameter("fname");
		String lname =(String)request.getParameter("lname");
		int age = Integer.parseInt(request.getParameter("age"));
		String email =(String)request.getParameter("emailId");
		
		HttpSession s = request.getSession(false);
		System.out.println(email);
		System.out.println(age);
		System.out.println(lname);
		System.out.println(fname);
		System.out.println(s.getAttribute("id"));
		session.beginTransaction();
		String hql = "update from EmployeeDetails set firstName = :fname ,lastName = :lname , age = :age ,email = :email where employeeId = :eid";
		Query query = session.createQuery(hql);
		
		query.setParameter("fname", fname);
		query.setParameter("lname", lname);
		query.setParameter("age", age);
		query.setParameter("email", email);
		query.setParameter("eid", s.getAttribute("id"));
		query.executeUpdate();
		session.getTransaction().commit();
		session.flush();
		System.out.println("done");
	}
}

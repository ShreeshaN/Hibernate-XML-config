package com.rzt.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rzt.utils.LoginManager;



public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
    public EditServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginManager manager = new LoginManager();
		manager.editMe(request);
	
		
		
	}

}

package com.teja.login.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.teja.login.dao.LoginDao;
import com.teja.login.model.LoginFormModel;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	LoginDao  loginDao= new LoginDao();
	
	private static final long serialVersionUID = 1L;
     
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginFormModel loginForm = new LoginFormModel();
		loginForm.setUsername(username);
		loginForm.setPassword(password);
		
		try {
			if(loginDao.verifyLogin(loginForm)) {
				response.sendRedirect("LoginSuccess.jsp");
			}
			else {
				response.sendRedirect("LginForm");
			}
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		
		}

}

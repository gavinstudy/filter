package com.iotek.filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String psw=request.getParameter("psw");
		HttpSession session=request.getSession();
		if("liayin".equals(username)&&"fendou".equals(psw)){
			session.setAttribute("username", username);
			response.sendRedirect("success.jsp");
		}
	}

}

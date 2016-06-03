package control;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LogInService;
import service.UserLog;

/**
 * Servlet implementation class LogIn
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// PrintWriter out=response.getWriter();
		// out.println("success");
		String name, password;
		name = request.getParameter("name");
		password = request.getParameter("password");
		UserLog us = new UserLog();
		us.setName(name);
		us.setPassword(password);
		us.setType("admin");
		request.getSession().setAttribute("user", name);
		LogInService log = new LogInService();
		if (log.match(us) == 1) {
			System.out.print("sucesssfulll");
			request.getSession().setAttribute("LoggedInUser", "Admin");
			response.sendRedirect("AdminHome.jsp");
		}
		else {
			System.out.print("unnnnnsucesssfulll");
			response.sendRedirect("AdminLogin.jsp");
		}

	}

}

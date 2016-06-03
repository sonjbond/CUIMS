package control;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LogInService;
import service.UserLog;

/**
 * Servlet implementation class StuffLogin
 */
public class StuffLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuffLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name,password;
		name=request.getParameter("username");
		password=request.getParameter("password");
		UserLog us=new UserLog();
		us.setName(name);
		us.setPassword(password);
		us.setType("stuff");
		LogInService log=new LogInService();
		if(log.match(us)==1)
		{
			request.getSession().setAttribute("LoggedInUser", "Stuff");
			System.out.print("sucesssfulll\n");
			response.sendRedirect("StuffHome.jsp");
		}
		else 
		{
			System.out.print("unnnnnsucesssfulll\n");
			response.sendRedirect("StuffLogin.jsp");
		}
	}

}

package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddUser;
import service.UserLog;

/**
 * Servlet implementation class StuffSignUp
 */
public class StuffSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuffSignUp() {
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
		AddUser AU=new AddUser();
		UserLog UU=new UserLog();
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		UU.name=user;
		UU.password=pass;
		System.out.print("user = "+UU.name+"  password = "+ UU.password+" \n");
		if(AU.Add(UU)==1){
			System.out.print("Success!");
			RequestDispatcher rd = request.getRequestDispatcher("SignUpSuccess.jsp");
			rd.forward(request, response);
		}
		else{
			System.out.print("failed!");
			RequestDispatcher rd = request.getRequestDispatcher("SignUpFailed.jsp");
			rd.forward(request, response);
		}
	}

}

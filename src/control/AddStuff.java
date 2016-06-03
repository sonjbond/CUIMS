package control;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserLog;
import model.AddUser;


/**
 * Servlet implementation class AddStaff
 */
public class AddStuff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStuff() {
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
		String user=request.getParameter("name");
		String pass=request.getParameter("password");
		UU.name=user;
		UU.password=pass;
		System.out.print("user = "+UU.name+"  password = "+ UU.password+" \n");
		if(AU.Add(UU)==1){
			System.out.print("Success!");
			try {
				PrintWriter p = response.getWriter();
				p.print("Success fully Sign Up Done!");
				Thread.sleep(500);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("Index.jsp");
		}
		else{
			System.out.print("failed");
			try {
				PrintWriter p = response.getWriter();
				p.print("Sign Up Failed!");
				Thread.sleep(500);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("StuffSignUp.jsp");
		}
	}
}

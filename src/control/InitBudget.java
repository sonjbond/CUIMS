package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SQL_OPS;
import util.MyDate;

/**
 * Servlet implementation class initBudget
 */
public class InitBudget extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitBudget() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String Dep=request.getParameter("department");
			int Year=Integer.parseInt(request.getParameter("year"));
			double Amount=Double.parseDouble(request.getParameter("amount"));
			System.out.print("Department name:"+Dep+"\nBudget Amount:"+Amount +" year = "+Year);
			int Y=Integer.parseInt( request.getParameter("YY") );
			int M=Integer.parseInt( request.getParameter("MM") );
			int D=Integer.parseInt( request.getParameter("DD") );
			MyDate IssueDate=new MyDate(Y,M,D);
			System.out.print(" Issue Date : "+ IssueDate.getDate());
			
			SQL_OPS SqlOperations = new SQL_OPS();
			int r=SqlOperations.insert_into_budgets(Dep,Year,Amount,IssueDate.getDate());
			if(r==1){
				request.getSession().setAttribute("InitDone", "True");
				RequestDispatcher rd = request.getRequestDispatcher("InitBudgetDone.jsp");
				rd.forward(request, response);
				
			}
			else{
				response.sendRedirect("InitBudget.jsp");
			}
			
		} catch(Exception e){
			response.sendRedirect("InitBudget.jsp");
			e.printStackTrace();
		}
	}
}

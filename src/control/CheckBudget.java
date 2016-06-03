package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SQL_OPS;

/**
 * Servlet implementation class CheckBudget
 */
public class CheckBudget extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckBudget() {
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
		String Dp = request.getParameter("department");
		int Year = Integer.parseInt(request.getParameter("year"));
		System.out.print("Department:" + Dp + "Year:" + Year + "\n");
		SQL_OPS SqlOp = new SQL_OPS();
		Vector<String> res = new Vector<String>();
		request.getSession().setAttribute("Dept", Dp);
		request.getSession().setAttribute("Year", Year);
		if (SqlOp.query_budgets(Dp, Year) == 1) {
			System.out.print("budget info found:\n");
			res = SqlOp.getQueryBudgetResult();
			if (res.size() == 0) {
				request.getSession().setAttribute("BudgetFound", "No");
			}
			else {
				request.getSession().setAttribute("BudgetFound", "Yes");
				request.getSession().setAttribute("BudgetInfo", res);
			}
		}
		else {
			request.getSession().setAttribute("BudgetFound", "No");
		}
		RequestDispatcher rd = request.getRequestDispatcher("ShowBudgetInfo.jsp");
		rd.forward(request, response);
	}
}

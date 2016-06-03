package control;

import java.io.IOException;
//import java.io.PrintWriter;
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
public class UpdateBudget extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBudget() {
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Dp = request.getParameter("department");
		int Year = Integer.parseInt(request.getParameter("year"));
		System.out.print("Department:" + Dp + "Year:" + Year + "\n");
		SQL_OPS SqlOp = new SQL_OPS();
		Vector<String> res = new Vector<String>();
		request.getSession().setAttribute("DepartmentName", Dp);
		request.getSession().setAttribute("Year", Year);
		if (SqlOp.query_budgets(Dp, Year) == 1) {

			System.out.print("budget info found:\n");
			res = SqlOp.getQueryBudgetResult();
			if (res.size() == 0) {
				System.out.print("Budget information not found! query done!\n");
				request.getSession().setAttribute("BudgetFound", "NotFound");
			} else {
				
				System.out.print("Budget information found! query done! we get some result\n");
				for (int i = 0; i < res.size(); i++) {
					System.out.print(i + "th coloumn =  " + res.get(i) + "\n");
				}
				request.getSession().setAttribute("BudgetFound", "Found");
				request.getSession().setAttribute("TotalBudget", res.get(0));
				request.getSession().setAttribute("RemainingBudget", res.get(1).toString());
				request.getSession().setAttribute("IssueDate", res.get(2));
			}
		} else {
			System.out.print("Budget information not found! exceptions\n");
			request.getSession().setAttribute("BudgetFound", "NotFound");
		}
		RequestDispatcher rd = request.getRequestDispatcher("ShowBudgetAndUpdate.jsp");
		rd.forward(request, response);
	}
}

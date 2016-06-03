package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SQL_OPS;
import util.Price;

/**
 * Servlet implementation class CheckBudgetForReq
 */
public class CheckBudgetForReq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckBudgetForReq() {
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
		System.out.println("Now I am in Servlet");
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
				int sci_eq =Integer.parseInt( request.getParameter("sci_eq") );
				int sta_eq =Integer.parseInt( request.getParameter("sci_eq") );
				int tools =Integer.parseInt( request.getParameter("sci_eq") );
				Price price = new Price();
				int Total = sci_eq*price.getSci_price() + sta_eq*price.getSta_price() + tools*price.getTools_price();
				int Rem=Integer.parseInt(res.get(1));
				int Tot_Budget=Integer.parseInt(res.get(0));
				System.out.println("Total Budget = "+Tot_Budget);
				
				if(Rem > Total){
					request.getSession().setAttribute("Status", "Passed");
					System.out.println("Passed");
				}
				else{
					request.getSession().setAttribute("Status", "Failed");
					System.out.println("Failed");
				}
				request.getSession().setAttribute("TotalBudget", Tot_Budget);
				request.getSession().setAttribute("Rem", Rem);
				request.getSession().setAttribute("Cost", Total);
			}
		}
		else {
			request.getSession().setAttribute("BudgetFound", "No");
		}
		RequestDispatcher rd = request.getRequestDispatcher("ShowBudgetStatus.jsp");
		rd.forward(request, response);
	}

}

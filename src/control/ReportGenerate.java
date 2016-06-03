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

import model.FindSentInfo;

/**
 * Servlet implementation class ReportGenerate
 */
public class ReportGenerate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportGenerate() {
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
		
		String Dept = request.getParameter("Dept");
		String Year = request.getParameter("Year");
		int Y = Integer.parseInt(Year);
		FindSentInfo fsi = new FindSentInfo();
		SQL_OPS SqlOp = new SQL_OPS();
		Price price = new Price();
		Vector< Vector<String> > Sent = fsi.find(Dept, Y);
		SqlOp.query_budgets(Dept, Y);
		Vector<String> budget = SqlOp.getQueryBudgetResult();
		request.getSession().setAttribute("Budget", budget);
		request.getSession().setAttribute("Sent", Sent);
		request.getSession().setAttribute("Price", price);
		for(int p=0;p<budget.size();p++)System.out.println(p+"the colm = "+budget.get(p));
		RequestDispatcher rd = request.getRequestDispatcher("ShowReport.jsp");
		rd.forward(request, response);
	}

}

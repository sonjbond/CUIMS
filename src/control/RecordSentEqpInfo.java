package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteRowFromDb;
import model.RecSentEqp;
import service.SQL_OPS;
import util.MyDate;
import util.Price;

/**
 * Servlet implementation class RecordSentEqpInfo
 */
public class RecordSentEqpInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecordSentEqpInfo() {
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

		System.out.println("gotcha!!");
		String Dept = request.getParameter("Department");
		System.out.println(Dept);
		int Year = Integer.parseInt(request.getParameter("Year"));
		int sci_equip = Integer.parseInt(request.getParameter("sci_equip"));
		int sta_equip = Integer.parseInt(request.getParameter("sta_equip"));
		int tools = Integer.parseInt(request.getParameter("tools"));
		int DD = Integer.parseInt(request.getParameter("DD"));
		int MM = Integer.parseInt(request.getParameter("MM"));
		int YY = Integer.parseInt(request.getParameter("YY"));
		MyDate DateOfReq = new MyDate(YY, MM, DD);
		RecSentEqp Obj = new RecSentEqp();
		boolean done = Obj.insert(Dept, Year, sci_equip, sta_equip, tools, DateOfReq.getDate());

		if (done) {
			System.out.println("Record Sent data info Done!");
			SQL_OPS SqlOp = new SQL_OPS();
			Vector<String> res = new Vector<String>();
			if (SqlOp.query_budgets(Dept, Year) == 1) {
				System.out.print("budget info found:\n");
				res = SqlOp.getQueryBudgetResult();
				if (res.size() == 0) {
					System.out.print("Budget information not found! query done!\n");
				}
				else {
					DeleteRowFromDb drdb = new DeleteRowFromDb();
					Price price = new Price();
					int Cost = price.getSci_price() * sci_equip + price.getSta_price() * sta_equip + price.getTools_price() * tools;
					drdb.AlterFromBudget(Dept, request.getParameter("Year"), Integer.parseInt(res.get(0)), Integer.parseInt(res.get(1)) - Cost);
				}
			}
			else {
				System.out.print("Budget information not found! exceptions\n");
			}
			request.getSession().setAttribute("Record", "true");
		}
		else {
			System.out.println("Record Sent info Failed!");
			request.getSession().setAttribute("Record", "false");
		}
		RequestDispatcher rd = request.getRequestDispatcher("RecSentEqpDone.jsp");
		rd.forward(request, response);
	}
}

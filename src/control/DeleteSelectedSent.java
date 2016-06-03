package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteRowFromDb;
import model.FindSentInfo;

/**
 * Servlet implementation class DeleteSelectedSent
 */
public class DeleteSelectedSent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSelectedSent() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("AMi Servlet a achi vai ...  paichen ??");
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		data = ((Vector<Vector<String>>) (request.getSession().getAttribute("SentInfoTable")));
		for (int i = 0; i < data.size(); i++) {
			String Clicked = request.getParameter("button" + i);
			if ("Delete".equals(Clicked)) {
				System.out.println("Clicked Button = " + i);
				// PrintWriter out = response.getWriter();
				// out.println("Clicked Button = "+ i);
				DeleteRowFromDb drdb = new DeleteRowFromDb();
				boolean res = drdb.DelFromSent(data.get(i));
				if (res) {
					// out.print("Deleted!");
					request.getSession().setAttribute("Deleted", true);
				}
				else {
					// out.print("Error Deleting Data");
					request.getSession().setAttribute("Deleted", false);
				}
				System.out.println("I am Here");
				String Dept=request.getParameter("Department");
				int Year=Integer.parseInt(request.getParameter("Year"));
				System.out.println("Department = "+Dept+" Year = "+Year);
				FindSentInfo fsi = new FindSentInfo();
				Vector< Vector<String> > SentInfo =  fsi.find(Dept, Year);
				request.getSession().setAttribute("SentInfoTable", SentInfo);
				RequestDispatcher rd = request.getRequestDispatcher("SentInfoDelete.jsp");
				rd.forward(request, response);
			}
		}
	}

}

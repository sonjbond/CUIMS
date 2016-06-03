package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteRowFromDb;
import model.FindReqInfo;

/**
 * Servlet implementation class DeleteSelected
 */
public class DeleteSelected extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteSelected() {
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
	// @SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("AMi Servlet a achi vai ...  paichen ??");
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		data = ((Vector<Vector<String>>) (request.getSession().getAttribute("ReqInfoTable")));
		for (int i = 0; i < data.size(); i++) {
			String Clicked = request.getParameter("button" + i);
			if ("Delete".equals(Clicked)) {
				System.out.println("Clicked Button = " + i);
				// PrintWriter out = response.getWriter();
				// out.println("Clicked Button = "+ i);
				DeleteRowFromDb drdb = new DeleteRowFromDb();
				boolean res = drdb.Del(data.get(i));
				if (res) {
					// out.print("Deleted!");
					request.getSession().setAttribute("Deleted", true);
				}
				else {
					// out.print("Error Deleting Data");
					request.getSession().setAttribute("Deleted", false);
				}
				System.out.println("I am Here");
				String Dept=request.getParameter("department");
				int Year=Integer.parseInt(request.getParameter("year"));
				System.out.println("Department = "+Dept+" Year = "+Year);
				FindReqInfo fri = new FindReqInfo();
				Vector< Vector<String> > ReqInfo =  fri.find(Dept, Year);
				for(int ii=0;ii<ReqInfo.size();ii++){
					for(int j=0;j<ReqInfo.get(ii).size();j++){
						System.out.print(ReqInfo.get(ii).get(j)+"  ");
					}
					System.out.println("");
				}
				System.out.println(ReqInfo.size());
				request.getSession().setAttribute("ReqInfoTable", ReqInfo);
				RequestDispatcher rd = request.getRequestDispatcher("ReqInfodelete.jsp");
				rd.forward(request, response);
			}
		}
	}

}

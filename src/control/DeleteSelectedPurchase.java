package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteRowFromDb;

import service.GetPurInfo;

/**
 * Servlet implementation class DeleteSelectedPurchase
 */
public class DeleteSelectedPurchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSelectedPurchase() {
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
		System.out.println("AMi Servlet a achi vai ...  paichen ??");
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		GetPurInfo gpi = new GetPurInfo();
		data=gpi.Get();
		
		for (int i = 0; i < data.size(); i++) {
			String Clicked = request.getParameter("button" + i);
			if ("Delete".equals(Clicked)) {
				System.out.println("Clicked Button = " + i);
				DeleteRowFromDb drdb = new DeleteRowFromDb();
				boolean res = drdb.DelFromPur(data.get(i));
				if (res) {
					// out.print("Deleted!");
					System.out.println("Deleted");
					request.getSession().setAttribute("Deleted", true);
				}
				else {
					System.out.println("Cant Delete!!");
					// out.print("Error Deleting Data");
					request.getSession().setAttribute("Deleted", false);
				}
				response.sendRedirect("DeletePurchaseInfo.jsp");
			}
		}
	}

}

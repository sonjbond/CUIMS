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
 * Servlet implementation class EditSelectedPurchase
 */
public class EditSelectedPurchase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSelectedPurchase() {
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
			//System.out.println(i + "th : "+Clicked);
			if ("Edit".equals(Clicked)) {
				System.out.println("Clicked Button = " + i);
				Vector<String> vs= new Vector<String>();
				for(int j=0; j<data.get(i).size();j++){
					vs.add(request.getParameter("inp"+i+"_"+j));
					//System.out.print(j+" th = "+vs.get(j));
				}
				System.out.println();
				DeleteRowFromDb drdb = new DeleteRowFromDb();
				boolean res = drdb.AlterFromPur(data.get(i),vs);
				if (res) {
					// out.print("Deleted!");
					System.out.println("Edited!");
				}
				else {
					System.out.println("Cant Edit!!");
					// out.print("Error Deleting Data");
				}
				response.sendRedirect("EditPurchaseInfo.jsp");
			}
		}
	}

}

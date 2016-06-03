package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteRowFromDb;

/**
 * Servlet implementation class UpdateBudgetSelected
 */
public class UpdateBudgetSelected extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBudgetSelected() {
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
		System.out.println("Inseide The Servlet UpdateSelected");
		String Dept = request.getParameter("Dept");
		String Year = request.getParameter("Year");
		String Total = request.getParameter("Total");
		String Rem = request.getParameter("Rem");
		System.out.println(" Budget info: "+ Dept+" "+Year+" "+ Total+" "+ Rem);
		DeleteRowFromDb drdb = new DeleteRowFromDb();
		boolean res = drdb.AlterFromBudget(Dept, Year, Integer.parseInt(Total), Integer.parseInt( Rem));
		System.out.println("Update DB Done = "+ res);
		
		request.getSession().setAttribute("TotalBudget",Total);
		request.getSession().setAttribute("RemainingBudget",Rem);
		
		RequestDispatcher rd = request.getRequestDispatcher("ShowBudgetAndUpdate.jsp");
		rd.forward(request, response);
	}

}

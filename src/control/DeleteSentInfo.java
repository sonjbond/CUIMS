package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FindSentInfo;

/**
 * Servlet implementation class DeleteSentInfo
 */
public class DeleteSentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSentInfo() {
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
		System.out.println("I am Here");
		String Dept=request.getParameter("Department");
		int Year=Integer.parseInt(request.getParameter("Year"));
		System.out.println("Department = "+Dept+" Year = "+Year);
		FindSentInfo fsi = new FindSentInfo();
		Vector< Vector<String> > SentInfo =  fsi.find(Dept, Year);
		for(int i=0;i<SentInfo.size();i++){
			for(int j=0;j<SentInfo.get(i).size();j++){
				System.out.print(SentInfo.get(i).get(j)+"  ");
			}
			System.out.println("");
		}
		System.out.println(SentInfo.size());
		request.getSession().setAttribute("SentInfoTable", SentInfo);
		RequestDispatcher rd = request.getRequestDispatcher("SentInfoDelete.jsp");
		rd.forward(request, response);
		//response.sendRedirect("SentInfodelete.jsp");
	}

}

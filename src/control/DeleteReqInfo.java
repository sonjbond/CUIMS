package control;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FindReqInfo;

/**
 * Servlet implementation class DeleteReqInfo
 */
public class DeleteReqInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReqInfo() {
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
		String Dept=request.getParameter("department");
		int Year=Integer.parseInt(request.getParameter("year"));
		System.out.println("Department = "+Dept+" Year = "+Year);
		FindReqInfo fri = new FindReqInfo();
		Vector< Vector<String> > ReqInfo =  fri.find(Dept, Year);
		for(int i=0;i<ReqInfo.size();i++){
			for(int j=0;j<ReqInfo.get(i).size();j++){
				System.out.print(ReqInfo.get(i).get(j)+"  ");
			}
			System.out.println("");
		}
		System.out.println(ReqInfo.size());
		request.getSession().setAttribute("ReqInfoTable", ReqInfo);
		request.getSession().setAttribute("department", Dept);
		request.getSession().setAttribute("year", Year);
		RequestDispatcher rd = request.getRequestDispatcher("ReqInfodelete.jsp");
		rd.forward(request, response);
		//response.sendRedirect("ReqInfodelete.jsp");
	}

}

package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.MyDate;

/**
 * Servlet implementation class RecPurInfo
 */
public class RecPurInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecPurInfo() {
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
		String store = request.getParameter("store");
		int sci_equip=Integer.parseInt(request.getParameter("sci_equip"));
		int sta_equip=Integer.parseInt(request.getParameter("sta_equip"));
		int tools=Integer.parseInt(request.getParameter("tools"));
		MyDate md = new MyDate(Integer.parseInt(request.getParameter("YY")), Integer.parseInt(request.getParameter("MM")), Integer.parseInt(request.getParameter("DD")));
		String date = md.getDate();
		model.RecPurInfo rpi = new model.RecPurInfo();
		boolean res = rpi.Add(store, sci_equip, sta_equip, tools, date);
		if(res){
			request.getSession().setAttribute("RecPurInfo", "True");
		}
		else{
			request.getSession().setAttribute("RecPurInfo", "False");
		}
		RequestDispatcher rd = request.getRequestDispatcher("RecPurInfoDone.jsp");
		rd.forward(request, response);
	}

}

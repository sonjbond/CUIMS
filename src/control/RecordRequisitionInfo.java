package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RecordRequisitionData;

import util.MyDate;

/**
 * Servlet implementation class RecordRequisitionInfo
 */
public class RecordRequisitionInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordRequisitionInfo() {
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
		System.out.println("bitch gotcha!!");
		String Dept=request.getParameter("department");
		System.out.println(Dept);
		int Year=Integer.parseInt(request.getParameter("year"));
		int sci_equip=Integer.parseInt(request.getParameter("sci_equip"));
		int sta_equip=Integer.parseInt(request.getParameter("sta_equip"));
		int tools=Integer.parseInt(request.getParameter("tools"));
		int DD=Integer.parseInt(request.getParameter("DD"));
		int MM=Integer.parseInt(request.getParameter("MM"));
		int YY=Integer.parseInt(request.getParameter("YY"));
		MyDate DateOfReq=new MyDate(YY,MM,DD);
		RecordRequisitionData Obj=new RecordRequisitionData();
		boolean res = Obj.insert(Dept, Year, sci_equip, sta_equip, tools, DateOfReq.getDate());
		if(res){
			System.out.println("Record Requisition info Done!");
			response.sendRedirect("RecordRequisitionSuccess.jsp");
		}
		else{
			System.out.println("Record Requisition info Failed!");
			response.sendRedirect("RecordRequisitionFailed.jsp");
		}
	}

}

package service;

import java.util.Vector;

public class ReqQuery {
	DataBase D = DataBase.GetInsatance();
	public Vector<Vector<String>> DoQuery(String S) {
		Vector<Vector<String>> ret = new Vector<Vector<String>>();
		try {
			D.rs = D.statment.executeQuery(S);
			while (D.rs.next()) {
				String Dept = D.rs.getString("Dept");
				String Year = D.rs.getString("Year");
				String sci_eq = D.rs.getString("sci_eq");
				String sta_eq = D.rs.getString("sta_eq");
				String tools = D.rs.getString("tools");
				String DateOfReq = D.rs.getString("DateOfReq");
				Vector<String> vs = new Vector<String>();
				vs.add(Dept);
				vs.add(Year);
				vs.add(sci_eq);
				vs.add(sta_eq);
				vs.add(tools);
				vs.add(DateOfReq);
				ret.add(vs);
				System.out.println("Iside service.Query: "+Dept+" "+Year+" "+sci_eq+" "+sta_eq+" "+tools+" "+DateOfReq);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}

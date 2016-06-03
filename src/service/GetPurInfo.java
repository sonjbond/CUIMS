package service;
import java.util.Vector;

public class GetPurInfo {
	DataBase D = DataBase.GetInsatance();
	public Vector< Vector<String> > Get(){
		Vector< Vector<String> > ret = new Vector< Vector<String> > ();
		String sql = "SELECT * FROM purch_data;";
		try {
			
			D.rs = D.statment.executeQuery(sql);
			while (D.rs.next()) {
				String store = D.rs.getString("store");
				String sci_eq = D.rs.getString("sci_eq");
				String sta_eq = D.rs.getString("sta_eq");
				String tools = D.rs.getString("tools");
				String pur_date = D.rs.getString("pur_date");
				Vector<String> vs = new Vector<String>();
				vs.add(store);
				vs.add(sci_eq);
				vs.add(sta_eq);
				vs.add(tools);
				vs.add(pur_date);
				ret.add(vs);
				//System.out.println("Inside Query: Store = "+store+" sci_eq = "+sci_eq+" sta_eq = "+sta_eq+" tools = "+tools+" Date of Purchase = "+pur_date);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
}

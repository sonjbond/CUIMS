package model;

import java.util.Vector;

import service.ReqQuery;

public class FindReqInfo {
	Vector< Vector<String> > ret = new Vector< Vector<String> >();
	public Vector< Vector<String> > find(String Dept, int Year){
		String S="SELECT * FROM cuims_db.reqdata where cuims_db.reqdata.Dept = '"+Dept+"' and cuims_db.reqdata.Year = "+Year;
		ReqQuery rq = new ReqQuery();
		return ret = rq.DoQuery(S);
	}
}

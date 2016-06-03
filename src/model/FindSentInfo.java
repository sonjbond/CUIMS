package model;

import java.util.Vector;

import service.ReqQuery;

public class FindSentInfo {
	Vector< Vector<String> > ret = new Vector< Vector<String> >();
	public Vector< Vector<String> > find(String Dept, int Year){
		String S="SELECT * FROM cuims_db.sentdata where cuims_db.sentdata.Dept = '"+Dept+"' and cuims_db.sentdata.Year = "+Year;
		ReqQuery rq = new ReqQuery();
		return ret = rq.DoQuery(S);
	}
}

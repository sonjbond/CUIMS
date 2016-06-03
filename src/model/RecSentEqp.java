package model;

import service.SQL_OPS;

public class RecSentEqp {
	public boolean insert(String Dept,int Year,int sci_equip,int sta_equip,int tools,String DateOf){
		String S="INSERT INTO sentdata VALUES ('"+Dept+"',"+Year+","+sci_equip+","+sta_equip+","+tools+",'"+DateOf+"');";
		System.out.println(S);
		SQL_OPS Obj = new SQL_OPS();
		return Obj.ExecuteSql(S);
	}
}

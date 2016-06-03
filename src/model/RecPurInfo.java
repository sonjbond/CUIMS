package model;

import service.SQL_OPS;

public class RecPurInfo {
	public boolean Add(String store, int sci_equip,int sta_equip,int tools, String date){
		String sql="insert into purch_data values(+'"+store+"',"+sci_equip+","+sta_equip+","+tools+",'"+date+"');";
		SQL_OPS Obj = new SQL_OPS();
		return Obj.ExecuteSql(sql);
	}
}

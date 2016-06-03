package model;

import service.SQL_OPS;

public class RecordRequisitionData {
	public boolean insert(String dept,int Year,int sci_eq,int sta_eq,int tools,String DateOfReq){
		String sql = "INSERT into reqdata(Dept, Year, sci_eq, sta_eq, tools, DateOfReq) values('"+dept+"',"+Year+","+sci_eq+","+sta_eq+","+tools+",'"+DateOfReq+"');";
		SQL_OPS Obj=new SQL_OPS();
		return Obj.ExecuteSql(sql);
	}
}

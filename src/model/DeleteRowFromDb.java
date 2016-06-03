package model;

import java.util.Vector;

import service.SQL_OPS;

public class DeleteRowFromDb {
	public boolean Del(Vector<String> vs){
		String S="DELETE FROM reqdata WHERE reqdata.Dept = '"+vs.get(0)+"' and reqdata.Year = "+vs.get(1)+" and reqdata.sci_eq="+vs.get(2)+" and reqdata.sta_eq="+vs.get(3)+" and reqdata.tools = "+vs.get(4)+" and reqdata.DateOfReq = '"+vs.get(5)+"' ;";
		SQL_OPS Obj = new SQL_OPS();
		return Obj.ExecuteSql(S);
	}
	public boolean DelFromSent(Vector<String> vs){
		String S="DELETE FROM sentdata WHERE sentdata.Dept = '"+vs.get(0)+"' and sentdata.Year = "+vs.get(1)+" and sentdata.sci_eq="+vs.get(2)+" and sentdata.sta_eq="+vs.get(3)+" and sentdata.tools = "+vs.get(4)+" and sentdata.DateOfReq = '"+vs.get(5)+"' ;";
		SQL_OPS Obj = new SQL_OPS();
		return Obj.ExecuteSql(S);
	}
	public boolean DelFromPur(Vector<String> vs) {
		// TODO Auto-generated method stub
		String S="DELETE FROM purch_data WHERE purch_data.store = '"+vs.get(0)+"' and purch_data.sci_eq = "+vs.get(1)+" and purch_data.sta_eq="+vs.get(2)+" and purch_data.tools = "+vs.get(3)+" and purch_data.pur_date = '"+vs.get(4)+"' ;";
		SQL_OPS Obj = new SQL_OPS();
		return Obj.ExecuteSql(S);
	}
	public boolean AlterFromPur(Vector<String> vs1, Vector<String> vs2) {
		// TODO Auto-generated method stub
		String sql="UPDATE purch_data SET store='"+vs2.get(0)+"', sci_eq="+vs2.get(1)+", sta_eq="+vs2.get(2)+", tools="+vs2.get(3)+", pur_date='"+vs2.get(4)+"'";
				sql+=" WHERE store='"+vs1.get(0)+"' and sci_eq="+vs1.get(1)+" and sta_eq="+vs1.get(2)+" and tools="+vs1.get(3)+" and pur_date='"+vs1.get(4)+"';";
		System.out.println(sql);
		SQL_OPS Obj = new SQL_OPS();
		return Obj.ExecuteSql(sql);
	}
	public boolean AlterFromBudget(String Dept,String Year,int Total,int Rem){
		String S="UPDATE budgets SET t_amount="+Total+", r_amount="+Rem+" WHERE dept_name='"+Dept+"' and year="+Year+";";
		SQL_OPS Obj = new SQL_OPS();
		return Obj.ExecuteSql(S);
	}
}

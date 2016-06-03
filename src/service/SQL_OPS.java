package service;
import java.util.Vector;

import service.DataBase;

public class SQL_OPS {
	DataBase D = DataBase.GetInsatance();
	Vector<String> res=new Vector<String>();
	public int insert_into_budgets(String Dp, int Year, double Amount,
			String dates) {

		String sql = "INSERT into budgets(dept_name, year, t_amount, r_amount, issue_date) values('"
				+ Dp
				+ "',"
				+ Year
				+ ","
				+ Amount
				+ ","
				+ Amount
				+ ",'"
				+ dates
				+ "');";
		try {
			D.statment.execute(sql);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int query_budgets(String Dp,int Year){
		System.out.println("inside SQL_oPS/query");
		try{
			String sql="SELECT * FROM budgets WHERE budgets.dept_name='"+Dp+"' AND budgets.year='"+Year+"';";
			System.out.println("inside try");
			D.rs=D.statment.executeQuery(sql);
			System.out.println("after executing query");
			res.clear();
			while(D.rs.next()){
				System.out.print("Budget Query Done!\n");
				res.add(D.rs.getString("t_amount"));
				res.add(D.rs.getString("r_amount"));
				res.add(D.rs.getString("issue_date"));
				
				System.out.print(res.get(0)+" "+res.get(1)+res.get(2)+"\n");
				
			}
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	public Vector<String> getQueryBudgetResult(){
		return res;
	}
	
	public boolean ExecuteSql(String S){
		try{
			D.statment.execute(S);
			return true;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean ReleaseResource(){
		try{
		D.connection.close();
		D.statment.close();
		return true;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}

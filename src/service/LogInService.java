package service;

import java.sql.SQLException;

import model.CurrentUser;

import service.DataBase;

public class LogInService {
	DataBase D = DataBase.GetInsatance();
	CurrentUser CurrUser=new CurrentUser();
	public LogInService() {
		super();
	}

	public int match(UserLog user) {
		String name;
		String password;
		name = user.getName();
		password = user.getPassword();
		String Type=user.getType();

		try {
			if(Type.equals("admin"))
				D.rs = D.statment.executeQuery("select * from admin");
			else if(Type.equals("stuff"))
				D.rs = D.statment.executeQuery("select * from staff_info");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Type = " + Type + "Login Failed for (user/pass) : "+ name + "\\" + password );
			e.printStackTrace();
		}
		try {
			while (D.rs.next()) {
//				System.out.println(name + " <name 29| pass> " + password);
//				System.out.print(rs.getString("username") + " <name 30| pass>  "
//						+ rs.getString("password"));
				if (name.equals(D.rs.getString("username"))
						&& password.equals(D.rs.getString("password"))) {
					CurrUser.SetUser(user);
					return 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}

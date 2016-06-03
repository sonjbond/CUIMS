package service;

import java.sql.SQLException;

public class CreateUser {
	DataBase D = DataBase.GetInsatance();
	public int Add(UserLog user) {
		try {
			// insert into table
			D.statment.execute("INSERT INTO staff_info (username, password) VALUES ('"
					+ user.name + "','" + user.password + "')");
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Insertion Failed!\n");
			e.printStackTrace();
			return 0;
		}
	}
}

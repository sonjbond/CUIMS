package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	protected Connection connection;
	protected Statement statment;
	protected ResultSet rs;
	public static DataBase d = DataBase.GetInsatance();

	private DataBase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cuims_db", "root",
						"12345678");
				statment = connection.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DataBase GetInsatance()
	{
		if(d==null)
			return d=new DataBase();
		try {
			if(d.connection.isClosed())
				d=new DataBase();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			d=new DataBase();
		}
		return d;
	}
}
package model;

import service.CreateUser;
import service.UserLog;

public class AddUser {
	public int Add(UserLog user){
		CreateUser Obj=new CreateUser();
		return Obj.Add(user);
	}
}

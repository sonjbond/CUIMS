package model;

import service.UserLog;

public class CurrentUser {
	UserLog User=new UserLog();
	public void SetUser(UserLog U){
		User=U;
	}
}

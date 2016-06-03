package model;

import service.SQL_OPS;

public class LoggingOut {
	public void LogOut(){
		SQL_OPS Obj = new SQL_OPS();
		Obj.ReleaseResource();
	}
}

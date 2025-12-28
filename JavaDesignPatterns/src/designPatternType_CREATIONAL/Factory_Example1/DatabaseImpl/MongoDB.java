package designPatternType_CREATIONAL.Factory_Example1.DatabaseImpl;

import designPatternType_CREATIONAL.Factory_Example1.Database;

public class MongoDB implements Database{

	private String driverName;
	private String userName;
	
	public MongoDB(String driverName, String userName) {
		super();
		this.driverName = driverName;
		this.userName = userName;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public void showConnectionDetails() 
	{
		System.out.println("DriverName : "+this.driverName);
		System.out.println("Username : "+this.userName);
	}

}

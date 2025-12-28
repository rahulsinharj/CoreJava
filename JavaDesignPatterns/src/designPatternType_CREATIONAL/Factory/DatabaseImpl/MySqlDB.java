package designPatternType_CREATIONAL.Factory.DatabaseImpl;

import designPatternType_CREATIONAL.Factory.Database;

public class MySqlDB implements Database{

	private String driverName;
	private String userName;
	
	public MySqlDB(String driverName, String userName) {
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

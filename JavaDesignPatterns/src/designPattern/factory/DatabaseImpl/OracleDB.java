package designPattern.factory.DatabaseImpl;

import designPattern.factory.Database;

public class OracleDB implements Database{

	private String driverName;
	private String userName;
	
	public OracleDB(String driverName, String userName) {
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

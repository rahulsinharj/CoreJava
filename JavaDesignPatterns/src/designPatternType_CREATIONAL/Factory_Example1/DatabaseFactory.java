package designPatternType_CREATIONAL.Factory_Example1;

import designPatternType_CREATIONAL.Factory_Example1.DatabaseImpl.MongoDB;
import designPatternType_CREATIONAL.Factory_Example1.DatabaseImpl.MySqlDB;
import designPatternType_CREATIONAL.Factory_Example1.DatabaseImpl.OracleDB;

public class DatabaseFactory {

	public DatabaseFactory() throws IllegalAccessException {
		throw new IllegalAccessException("Obj can't be created from contructor !");
	}

	public static Database getInstance(DatabaseType type)
	{
		switch(type) {
			case mysqldb:
				return new MySqlDB("com.mysql.cj.jdbc.Driver", "mysql@123");
			case oracledb:
				return new OracleDB("com.jdbc.driver.OracleDriver", "oracle@123");
			case mongodb:
				return new MongoDB("com.mongodb.driver", "mongo@123");
			default:
				return null;
		}
		
	}
	
	
	
}

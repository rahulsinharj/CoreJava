package designPatternType_CREATIONAL.Factory;

import java.util.Scanner;

public class FactoryPattern_Main {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter db name - mysqldb , oracledb, mongodb :: ");
		String dbtype = kb.next();
		
		Database dbInstance = DatabaseFactory.getInstance(DatabaseType.valueOf(dbtype));
//		Database myDbInstance = DatabaseFactory.getInstance(DatabaseType.values()[n-1]);
		
		dbInstance.showConnectionDetails();
		
		
		
	}
}

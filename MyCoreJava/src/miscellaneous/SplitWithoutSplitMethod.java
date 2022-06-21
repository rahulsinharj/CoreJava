package miscellaneous;

import java.util.ArrayList;

public class SplitWithoutSplitMethod {

	public static void main(String[] args) {

		String str = "rah;ul;;sin;ha";
		
		ArrayList<String> splitResult = splitBySemColon(str);
		System.out.println(splitResult);
	
	}

	public static ArrayList<String> splitBySemColon(String str) 
	{
		ArrayList<String> list = new ArrayList<>();

		String temp = "";

		for (int i = 0; i < str.length(); i++) 
		{
			char ch = str.charAt(i);
			if (ch != ';') 
			{
				temp += ch;
			} 
			else if (ch == ';') 
			{
				list.add(temp);
				temp = "";
			}
		}
		
		return list;
	}
}

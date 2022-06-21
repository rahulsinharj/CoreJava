package miscellaneous;

import java.util.ArrayList;

public class SplitWithoutSplitMethod {

	public static void main(String[] args) {

		String str = "rah;ul;;sin;ha";
		
		ArrayList<String> splitResult = splitBySemiColon(str);
		System.out.println(splitResult);
	
	}

	public static ArrayList<String> splitBySemiColon(String str) 
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
				list.add(temp);			// kyuki ab ";" mila hai, to Purana piche ka temp string ko arraylist me daal do, 
				temp = "";				// aur uss temp string ko blank kar do, for undergoing same way aage bhi.	
			}
		}
		
		return list;
	}
}

package java8Features;

@FunctionalInterface
interface Parser
{
	String parse(String str);
}

class StringParser
{
	public static String convert(String s)
	{
		if(s.length() <= 5)
			s = s.toUpperCase();
		else
			s = s.toLowerCase();
		
		return s;
	}
}

class MyPrinter
{
	public void print(String str, Parser p)
	{
		str = p.parse(str);
		System.out.println(str);
	}
}

public class MethodReference_PrinterParsingExample {

	public static void main(String[] args) 
	{
		String myStr = "RahulSinha";
		MyPrinter myPrinter = new MyPrinter();
		
//---------------------------------------------------	
		myPrinter.print(myStr, new Parser() {
			
			@Override										// Using Anonymous class implementation
			public String parse(String str) {			
				return StringParser.convert(myStr);
			}
		});
		
//---------------------------------------------------
		myPrinter.print(myStr, (str) -> {					// Using Lambda implementation of Functional interface
				return StringParser.convert(myStr);
			}
		);

//---------------------------------------------------	
		myPrinter.print(myStr, str -> StringParser.convert(myStr));		// StringParser.convert() method ke andar ka logic yaha bhi likh skte the, but uske bajaye hamne wo chije iss method me rakh ke kewal method call karna easy samjha.  

//---------------------------------------------------
		myPrinter.print(myStr, StringParser::convert);		// providing interface implementation using METHOD REFERENCE


	}

}

package reflectionApi;

import java.lang.reflect.Method;

public class ReflectionMain {			// Reflection API is needed to call show() method of RefA class.
														// Reflection API can be used for testing
	public static void main(String[] args) throws Exception {
		
		Class cls = Class.forName("reflectionApi.RefA");
		RefA a1 = (RefA) cls.newInstance();
		
		// In order to call that private method, we have to create the obj of method class.
		Method m = cls.getDeclaredMethod("show", null);		// 1st parameter will ask for method name, and second parameter for the method-parameter 
		m.setAccessible(true);		// Making the show() private method as accessible
		m.invoke(a1, null);			// 1st parameter will ask for object name, and second parameter for the object-parameter 
		
	}

}

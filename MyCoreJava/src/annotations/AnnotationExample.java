package annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 	REFLECTION API : is a new feature in Java, using which we can get the values/features of the object.
  	
 * // Below are 2 meta annotations ::
   -----------------------------------	
 * 	@Target(ElementType.TYPE)		// We have to spectify the TARGET (or SCOPE level) , till where this annotation will be used.
  		
		ElementType.TYPE			=>  When we say ElementType.TYPE 		-> then annotation will be assigned/work at CLASS level.
		ElementType.METHOD			=>  When we say ElementType.METHOD 		-> then annotation will be assigned/work at METHOD level.
		ElementType.CONSTRUCTOR		=>  When we say ElementType.CONSTRUCTOR -> then annotation will be assigned/work at CONSTRUCTOR level.
		ElementType.FIELD			=>  When we say ElementType.FIELD 		-> then annotation will be assigned/work at FIELD level.
  		
  	
 * 	@Retention(RetentionPolicy.RUNTIME)		// We have to specify the RETENTION POLICY, that till what point you want the annotation to work. 
				
			RetentionPolicy.RUNTIME		=>		this annotation will work till RUNTIME.
			RetentionPolicy.SOURCE		=>		this annotation will work till SOURCE, not be available at compiled time.
			RetentionPolicy.CLASS		=>		this annotation will work at .CLASS file also.

 *	@Documented		//	If you want to introduce your annotation in the documentation itself (for creating the documentation) 
 	
 * 	@Inherited		//	For any other classA which extends NokiaASeries class, if we want our custom annotation "@SmartPhone" to be available in that child classA as well, then we have to use @Inherited in parent class NokiaASeries.   
 	
*/
@Inherited
@Documented
@Target(ElementType.TYPE)					// We have to specify the TARGET , that where this annotation will be used.
@Retention(RetentionPolicy.RUNTIME)			// We have to specify the RETENTION POLICY, that till what point you want the annotation to work. 
@interface SmartPhone
{
	String os() default "NoAndriod";	
	int version() default 1;
}

@SmartPhone(os = "Android" , version = 6)
class NokiaASeries
{
	String model;
	int size;
	
	public NokiaASeries() {
		super();
	}
	public NokiaASeries(String model, int size) {
		super();
		this.model = model;
		this.size = size;
	}
	
}

public class AnnotationExample {

	public static void main(String[] args) 
	{
		NokiaASeries objNokia = new NokiaASeries("Fire" , 7);
		System.out.println("NokiaASeries - model : "+objNokia.model);
		
		// For knowing annotation values of SmartPhone
		Class clsNokia = objNokia.getClass();
		Annotation an = clsNokia.getAnnotation(SmartPhone.class);
		SmartPhone s = (SmartPhone)an ;
		
		System.out.println("@SmartPhone - os : "+s.os());
		System.out.println("@SmartPhone - version : "+s.version());
		
	
		
	}

}

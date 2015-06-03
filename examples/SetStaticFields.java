package examples;

import com.n9mtq4.reflection.ReflectionHelper;
import examples.experementclasses.AnObject;

/**
 * Created by will on 4/28/15 at 10:03 PM.
 */
public class SetStaticFields {
	
	private static String text = "Hello World";
	private static int integer = 5;
	private static AnObject anObject = new AnObject("This is an object");
	
	private static void print(Object o) {
		System.out.println(o);
	}
	
	public static void main(String[] args) {
		
//		before
		print(text);
		print(integer);
		print(anObject.s);
		
//		now lets set some new values, even though they are private
		ReflectionHelper.setStaticObject("Hello CHANGED World", "text", SetStaticFields.class);
		ReflectionHelper.setStaticInt(5555, "integer", SetStaticFields.class);
		ReflectionHelper.setStaticObject(new AnObject("This is a changed object"), "anObject", SetStaticFields.class);
		
//		have they changed?
		print(text);
		print(integer);
		print(anObject.s);
		
	}
	
}

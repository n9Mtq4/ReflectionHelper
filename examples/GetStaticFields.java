package examples;

import com.n9mtq4.reflection.ReflectionHelper;
import examples.experementclasses.AnObject;

/**
 * Created by will on 4/28/15 at 9:54 PM.
 */
public class GetStaticFields {
	
	private static String text = "Hello World";
	private static int integer = 5;
	private static AnObject anObject = new AnObject("This is an object");
	
	public static void main(String[] args) {
		
//		gets field values from the object, by the string
		String gottenText = ReflectionHelper.getStaticObject("text", GetStaticFields.class);
		int gottenInteger = ReflectionHelper.getStaticInt("integer", GetStaticFields.class);
		AnObject gottenObject = ReflectionHelper.getStaticObject("anObject", GetStaticFields.class); // notice how i don't need to cast!
		
		System.out.println(gottenText);
		System.out.println(gottenInteger);
		System.out.println(gottenObject.s);
		
	}
	
}

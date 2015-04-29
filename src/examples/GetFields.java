package examples;

import com.n9mtq4.reflection.ReflectionHelper;
import examples.experementclasses.AnObject;
import examples.experementclasses.TestObject;

/**
 * Created by will on 4/28/15 at 9:46 PM.
 */
public class GetFields {
	
	public static void main(String[] args) {
		
//		makes the test object
		TestObject c = new TestObject();
		
//		gets field values from the object, even though its private
		String gottenText = ReflectionHelper.getObject("text", c);
		int gottenInteger = ReflectionHelper.getInt("integer", c);
		AnObject gottenObject = ReflectionHelper.getObject("anObject", c); // notice how i don't need to cast!
		
		System.out.println(gottenText);
		System.out.println(gottenInteger);
		System.out.println(gottenObject.s);
		
	}
	
}

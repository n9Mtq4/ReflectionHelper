package examples;

import com.n9mtq4.reflection.ReflectionHelper;
import examples.experementclasses.TestObject;

/**
 * Created by will on 4/28/15 at 10:17 PM.
 */
public class CallConstructor {
	
	public static void main(String[] args) {
		
//		call a constructor using reflection
		TestObject c = ReflectionHelper.callConstructor(TestObject.class); //notice the lack of casting!
		
//		print to verify that it worked
		c.printText();
		c.printInteger();
		c.printAnObject();
		
	}
	
}

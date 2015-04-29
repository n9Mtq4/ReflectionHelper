package examples;

import com.n9mtq4.reflection.ReflectionHelper;
import examples.experementclasses.AnObject;
import examples.experementclasses.TestObject;

/**
 * Created by will on 4/28/15 at 10:06 PM.
 */
public class CallMethods {
	
	public static void main(String[] args) {
		
		TestObject c = new TestObject();
		
//		call a void method
		ReflectionHelper.callVoidMethod("printStuff", c);
//		the ints default to Integer.class, so this requires a little more work
		int i = ReflectionHelper.callIntMethod("addIntegers", c, new Class[]{int.class, int.class}, new Object[]{4, 5});
		System.out.println(i);
//		call a method with a return of an object
		AnObject anObject = ReflectionHelper.getObject("anObject", c); //notice how you don't have to cast!
		System.out.println(anObject.s);
		
	}
	
}

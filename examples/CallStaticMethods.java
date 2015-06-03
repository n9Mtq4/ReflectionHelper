package examples;

import com.n9mtq4.reflection.ReflectionHelper;
import examples.experementclasses.AnObject;

/**
 * Created by will on 4/28/15 at 10:19 PM.
 */
public class CallStaticMethods {
	
	private static void printStuff() {
		System.out.println("I am printing stuff");
	}
	
	private static int addIntegers(int a, int b) {
		return a + b;
	}
	
	private static AnObject makeNewObject(String s) {
		return new AnObject(s);
	}
	
	public static void main(String[] args) {
		
//		call a void method
		ReflectionHelper.callStaticVoidMethod("printStuff", CallStaticMethods.class);
//		the ints default to Integer.class, so this requires a little more work
		int i = ReflectionHelper.callStaticIntMethod("addIntegers", CallStaticMethods.class, new Class[]{int.class, int.class}, new Object[]{4, 5});
		System.out.println(i);
//		call a method with a return of an object
		AnObject anObject = ReflectionHelper.callStaticObjectMethod("makeNewObject", CallStaticMethods.class, "Called a method!"); // no casting!
		System.out.println(anObject.s);
		
	}
	
}

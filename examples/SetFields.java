package examples;

import com.n9mtq4.reflection.ReflectionHelper;
import examples.experementclasses.AnObject;
import examples.experementclasses.TestObject;

/**
 * Created by will on 4/28/15 at 9:58 PM.
 */
public class SetFields {
	
	public static void main(String[] args) {
		
//		make an object to experiment with
		TestObject c = new TestObject();
//		before
		c.printText();
		c.printInteger();
		c.printAnObject();
		
//		now lets set some new values, even though they are private
		ReflectionHelper.setObject("Hello CHANGED World", "text", c);
		ReflectionHelper.setInt(5555, "integer", c);
		ReflectionHelper.setObject(new AnObject("This is a changed object"), "anObject", c);
		
//		have they changed?
		c.printText();
		c.printInteger();
		c.printAnObject();
		
	}
	
}

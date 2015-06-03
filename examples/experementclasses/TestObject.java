package examples.experementclasses;

/**
 * Created by will on 4/28/15 at 10:07 PM.
 */
public class TestObject {
	
	private String text;
	private int integer;
	private AnObject anObject;
	
	public TestObject() {
		this.text = "Hello World";
		this.integer = 5;
		this.anObject = new AnObject("This is an object");
	}
	
	private void printStuff() {
		System.out.println("I am printing stuff");
	}
	
	private int addIntegers(int a, int b) {
		return a + b;
	}
	
	private AnObject getAnObject() {
		return anObject;
	}
	
	public void printText() {
		System.out.println(text);
	}
	
	public void printInteger() {
		System.out.println(integer);
	}
	
	public void printAnObject() {
		System.out.println(anObject.s);
	}
	
}

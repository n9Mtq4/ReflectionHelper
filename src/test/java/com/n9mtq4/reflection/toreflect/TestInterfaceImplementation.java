package com.n9mtq4.reflection.toreflect;

/**
 * Created by will on 1/28/16 at 8:27 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class TestInterfaceImplementation implements TestInterface {
	
	public boolean voidMethod = false;
	public boolean booleanMethod = false;
	public boolean charMethod = false;
	public boolean stringMethod = false;
	public boolean intMethod = false;
	public boolean doubleMethod = false;
	
	@Override
	public void voidMethod() {
		voidMethod = true;
		System.out.println(TestInterfaceImplementation.class.getName() + ".voidMethod() was called");
	}
	
	@Override
	public boolean booleanMethod() {
		booleanMethod = true;
		return true;
	}
	
	@Override
	public char charMethod() {
		charMethod = true;
		return 'a';
	}
	
	@Override
	public String stringMethod() {
		stringMethod = true;
		return "Hello World";
	}
	
	@Override
	public int intMethod() {
		intMethod = true;
		return 1;
	}
	
	@Override
	public double doubleMethod() {
		doubleMethod = true;
		return 1.1;
	}
	
}

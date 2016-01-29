package com.n9mtq4.reflection;

import com.n9mtq4.reflection.toreflect.TestInterface;
import com.n9mtq4.reflection.toreflect.TestInterfaceImplementation;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by will on 1/28/16 at 8:24 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class EnhancedProxyTest {
	
	private int methodCalls = 0;
	
	private TestInterfaceImplementation testInterfaceImplementation = new TestInterfaceImplementation();
	private TestInterface ti;
	
	@Before
	public void setUp() throws Exception {
		
		testInterfaceImplementation = new TestInterfaceImplementation();
		ti = EnhancedProxy.newInstance(testInterfaceImplementation, new EnhancedProxy.EnhancedInvocationHandler() {
			@Override
			public Object invoke(Object obj, Object proxy, Method method, Object[] args) throws Throwable {
				
//				does the same thing, but increments methodCalls by one
				methodCalls++;
				return EnhancedProxy.callChild(obj, method, args);
				
			}
		});
		
	}
	
	@Test
	public void testEnhancedProxy() throws Exception {
		
		System.out.println("Testing Enhanced Proxy");
		assertTrue(methodCalls == 0);
		ti.voidMethod();
		assertTrue(methodCalls == 1);
		assertTrue(ti.booleanMethod());
		assertTrue(methodCalls == 2);
		assertTrue(ti.charMethod() == 'a');
		assertTrue(methodCalls == 3);
		assertTrue(ti.stringMethod().equals("Hello World"));
		assertTrue(methodCalls == 4);
		assertTrue(ti.intMethod() == 1);
		assertTrue(methodCalls == 5);
		assertTrue(ti.doubleMethod() == 1.1);
		assertTrue(methodCalls == 6);
		
	}
	
}

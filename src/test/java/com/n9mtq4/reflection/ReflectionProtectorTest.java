package com.n9mtq4.reflection;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by will on 1/28/16 at 8:13 PM.
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
public class ReflectionProtectorTest {
	
	@Test
	public void testUsedReflection() throws Exception {
		
		System.out.println("Testing reflection protector");
		assertFalse("no reflection", usedReflectionToCallMe());
		assertTrue("with reflection", ReflectionHelper.callStaticBooleanMethod("usedReflectionToCallMe", ReflectionProtectorTest.class));
		
	}
	
	public static boolean usedReflectionToCallMe() {
		return ReflectionProtector.usedReflection();
	}
	
}

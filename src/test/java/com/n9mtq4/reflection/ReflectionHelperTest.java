package com.n9mtq4.reflection;

import org.junit.Test;

import static com.n9mtq4.reflection.ReflectionHelper.callVoidMethod;
import static com.n9mtq4.reflection.ReflectionHelper.canBePrimitive;
import static com.n9mtq4.reflection.ReflectionHelper.forceGetPrimitiveClass;
import static com.n9mtq4.reflection.ReflectionHelper.getPrimitiveClass;
import static com.n9mtq4.reflection.ReflectionHelper.isPrimitive;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by will on 1/28/16 at 8:22 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class ReflectionHelperTest {
	
	private void dontUnImport() {
		assertFalse(false);
		callVoidMethod("", null, null, null, null);
	}
	
	@Test
	public void testGetUnsafe() throws Exception {
		
	}
	
	@Test
	public void testGetInt() throws Exception {
		
	}
	
	@Test
	public void testGetInt1() throws Exception {
		
	}
	
	@Test
	public void testSetInt() throws Exception {
		
	}
	
	@Test
	public void testSetInt1() throws Exception {
		
	}
	
	@Test
	public void testGetInt2() throws Exception {
		
	}
	
	@Test
	public void testSetInt2() throws Exception {
		
	}
	
	@Test
	public void testGetStaticInt() throws Exception {
		
	}
	
	@Test
	public void testGetStaticInt1() throws Exception {
		
	}
	
	@Test
	public void testSetStaticInt() throws Exception {
		
	}
	
	@Test
	public void testSetStaticInt1() throws Exception {
		
	}
	
	@Test
	public void testGetByte() throws Exception {
		
	}
	
	@Test
	public void testGetByte1() throws Exception {
		
	}
	
	@Test
	public void testSetByte() throws Exception {
		
	}
	
	@Test
	public void testSetByte1() throws Exception {
		
	}
	
	@Test
	public void testGetByte2() throws Exception {
		
	}
	
	@Test
	public void testSetByte2() throws Exception {
		
	}
	
	@Test
	public void testGetStaticByte() throws Exception {
		
	}
	
	@Test
	public void testGetStaticByte1() throws Exception {
		
	}
	
	@Test
	public void testSetStaticByte() throws Exception {
		
	}
	
	@Test
	public void testSetStaticByte1() throws Exception {
		
	}
	
	@Test
	public void testGetBoolean() throws Exception {
		
	}
	
	@Test
	public void testGetBoolean1() throws Exception {
		
	}
	
	@Test
	public void testSetBoolean() throws Exception {
		
	}
	
	@Test
	public void testSetBoolean1() throws Exception {
		
	}
	
	@Test
	public void testGetBoolean2() throws Exception {
		
	}
	
	@Test
	public void testSetBoolean2() throws Exception {
		
	}
	
	@Test
	public void testGetStaticBoolean() throws Exception {
		
	}
	
	@Test
	public void testGetStaticBoolean1() throws Exception {
		
	}
	
	@Test
	public void testSetStaticBoolean() throws Exception {
		
	}
	
	@Test
	public void testSetStaticBoolean1() throws Exception {
		
	}
	
	@Test
	public void testGetChar() throws Exception {
		
	}
	
	@Test
	public void testGetChar1() throws Exception {
		
	}
	
	@Test
	public void testSetChar() throws Exception {
		
	}
	
	@Test
	public void testSetChar1() throws Exception {
		
	}
	
	@Test
	public void testGetChar2() throws Exception {
		
	}
	
	@Test
	public void testSetChar2() throws Exception {
		
	}
	
	@Test
	public void testGetStaticChar() throws Exception {
		
	}
	
	@Test
	public void testGetStaticChar1() throws Exception {
		
	}
	
	@Test
	public void testSetStaticChar() throws Exception {
		
	}
	
	@Test
	public void testSetStaticChar1() throws Exception {
		
	}
	
	@Test
	public void testGetFloat() throws Exception {
		
	}
	
	@Test
	public void testGetFloat1() throws Exception {
		
	}
	
	@Test
	public void testSetFloat() throws Exception {
		
	}
	
	@Test
	public void testSetFloat1() throws Exception {
		
	}
	
	@Test
	public void testGetFloat2() throws Exception {
		
	}
	
	@Test
	public void testSetFloat2() throws Exception {
		
	}
	
	@Test
	public void testGetStaticFloat() throws Exception {
		
	}
	
	@Test
	public void testGetStaticFloat1() throws Exception {
		
	}
	
	@Test
	public void testSetStaticFloat() throws Exception {
		
	}
	
	@Test
	public void testSetStaticFloat1() throws Exception {
		
	}
	
	@Test
	public void testGetDouble() throws Exception {
		
	}
	
	@Test
	public void testGetDouble1() throws Exception {
		
	}
	
	@Test
	public void testSetDouble() throws Exception {
		
	}
	
	@Test
	public void testSetDouble1() throws Exception {
		
	}
	
	@Test
	public void testGetDouble2() throws Exception {
		
	}
	
	@Test
	public void testSetDouble2() throws Exception {
		
	}
	
	@Test
	public void testGetStaticDouble() throws Exception {
		
	}
	
	@Test
	public void testGetStaticDouble1() throws Exception {
		
	}
	
	@Test
	public void testSetStaticDouble() throws Exception {
		
	}
	
	@Test
	public void testSetStaticDouble1() throws Exception {
		
	}
	
	@Test
	public void testGetLong() throws Exception {
		
	}
	
	@Test
	public void testGetLong1() throws Exception {
		
	}
	
	@Test
	public void testSetLong() throws Exception {
		
	}
	
	@Test
	public void testSetLong1() throws Exception {
		
	}
	
	@Test
	public void testGetLong2() throws Exception {
		
	}
	
	@Test
	public void testSetLong2() throws Exception {
		
	}
	
	@Test
	public void testGetStaticLong() throws Exception {
		
	}
	
	@Test
	public void testGetStaticLong1() throws Exception {
		
	}
	
	@Test
	public void testSetStaticLong() throws Exception {
		
	}
	
	@Test
	public void testSetStaticLong1() throws Exception {
		
	}
	
	@Test
	public void testGetShort() throws Exception {
		
	}
	
	@Test
	public void testGetShort1() throws Exception {
		
	}
	
	@Test
	public void testSetShort() throws Exception {
		
	}
	
	@Test
	public void testSetShort1() throws Exception {
		
	}
	
	@Test
	public void testGetShort2() throws Exception {
		
	}
	
	@Test
	public void testSetShort2() throws Exception {
		
	}
	
	@Test
	public void testGetStaticShort() throws Exception {
		
	}
	
	@Test
	public void testGetStaticShort1() throws Exception {
		
	}
	
	@Test
	public void testSetStaticShort() throws Exception {
		
	}
	
	@Test
	public void testSetStaticShort1() throws Exception {
		
	}
	
	@Test
	public void testGetObject() throws Exception {
		
	}
	
	@Test
	public void testGetObject1() throws Exception {
		
	}
	
	@Test
	public void testSetObject() throws Exception {
		
	}
	
	@Test
	public void testSetObject1() throws Exception {
		
	}
	
	@Test
	public void testGetObject2() throws Exception {
		
	}
	
	@Test
	public void testSetObject2() throws Exception {
		
	}
	
	@Test
	public void testGetStaticObject() throws Exception {
		
	}
	
	@Test
	public void testGetStaticObject1() throws Exception {
		
	}
	
	@Test
	public void testSetStaticObject() throws Exception {
		
	}
	
	@Test
	public void testSetStaticObject1() throws Exception {
		
	}
	
	@Test
	public void testCallConstructor() throws Exception {
		
	}
	
	@Test
	public void testCallConstructor1() throws Exception {
		
	}
	
	@Test
	public void testCallObjectMethod() throws Exception {
		
	}
	
	@Test
	public void testCallObjectMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallObjectMethod2() throws Exception {
		
	}
	
	@Test
	public void testCallObjectMethod3() throws Exception {
		
	}
	
	@Test
	public void testCallObjectMethod4() throws Exception {
		
	}
	
	@Test
	public void testCallStaticObjectMethod() throws Exception {
		
	}
	
	@Test
	public void testCallStaticObjectMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallStaticObjectMethod2() throws Exception {
		
	}
	
	@Test
	public void testCallVoidMethod() throws Exception {
		
	}
	
	@Test
	public void testCallVoidMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallVoidMethod2() throws Exception {
		
	}
	
	@Test
	public void testCallVoidMethod3() throws Exception {
		
	}
	
	@Test
	public void testCallStaticVoidMethod() throws Exception {
		
	}
	
	@Test
	public void testCallStaticVoidMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallIntMethod() throws Exception {
		
	}
	
	@Test
	public void testCallIntMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallIntMethod2() throws Exception {
		
	}
	
	@Test
	public void testCallIntMethod3() throws Exception {
		
	}
	
	@Test
	public void testCallStaticIntMethod() throws Exception {
		
	}
	
	@Test
	public void testCallStaticIntMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallByteMethod() throws Exception {
		
	}
	
	@Test
	public void testCallByteMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallByteMethod2() throws Exception {
		
	}
	
	@Test
	public void testCallByteMethod3() throws Exception {
		
	}
	
	@Test
	public void testCallStaticByteMethod() throws Exception {
		
	}
	
	@Test
	public void testCallStaticByteMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallBooleanMethod() throws Exception {
		
	}
	
	@Test
	public void testCallBooleanMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallBooleanMethod2() throws Exception {
		
	}
	
	@Test
	public void testCallBooleanMethod3() throws Exception {
		
	}
	
	@Test
	public void testCallStaticBooleanMethod() throws Exception {
		
	}
	
	@Test
	public void testCallStaticBooleanMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallCharMethod() throws Exception {
		
	}
	
	@Test
	public void testCallCharMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallCharMethod2() throws Exception {
		
	}
	
	@Test
	public void testCallCharMethod3() throws Exception {
		
	}
	
	@Test
	public void testCallStaticCharMethod() throws Exception {
		
	}
	
	@Test
	public void testCallStaticCharMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallFloatMethod() throws Exception {
		
	}
	
	@Test
	public void testCallFloatMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallFloatMethod2() throws Exception {
		
	}
	
	@Test
	public void testCallFloatMethod3() throws Exception {
		
	}
	
	@Test
	public void testCallStaticFloatMethod() throws Exception {
		
	}
	
	@Test
	public void testCallStaticFloatMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallDoubleMethod() throws Exception {
		
	}
	
	@Test
	public void testCallDoubleMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallDoubleMethod2() throws Exception {
		
	}
	
	@Test
	public void testCallDoubleMethod3() throws Exception {
		
	}
	
	@Test
	public void testCallStaticDoubleMethod() throws Exception {
		
	}
	
	@Test
	public void testCallStaticDoubleMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallLongMethod() throws Exception {
		
	}
	
	@Test
	public void testCallLongMethod1() throws Exception {
		
	}
	
	@Test
	public void testCallLongMethod2() throws Exception {
		
	}
	
	@Test
	public void testCallLongMethod3() throws Exception {
		
	}
	
	@Test
	public void testCallStaticLongMethod() throws Exception {
		
	}
	
	@Test
	public void testCallStaticLongMethod1() throws Exception {
		
	}
	
	@Test
	public void testGetClassesForPackage() throws Exception {
		
	}
	
	@Test
	public void testFindPackageNamesStartingWith() throws Exception {
		
	}
	
	@Test
	public void testGetClassBySimpleName() throws Exception {
		
	}
	
	@Test
	public void testGetClassByFullName() throws Exception {
		
	}
	
	@Test
	public void testGetClass() throws Exception {
		
	}
	
	@Test
	public void testGetAllDeclaredFields() throws Exception {
		
	}
	
	@Test
	public void testGetAllDeclaredField() throws Exception {
		
	}
	
	@Test
	public void testGetAllDeclaredMethods() throws Exception {
		
	}
	
	@Test
	public void testGetAllDeclaredMethod() throws Exception {
		
	}
	
	@Test
	public void testFindAllDeclaredMethodByParams() throws Exception {
		
	}
	
	@Test
	public void testGetClassParams() throws Exception {
		
	}
	
	@Test
	public void testCanBePrimitive() throws Exception {
		assertTrue(canBePrimitive(Double.class));
		assertTrue(canBePrimitive(Integer.class));
		assertTrue(canBePrimitive(Boolean.class));
		assertFalse(canBePrimitive(String.class));
		assertFalse(canBePrimitive(ReflectionHelperTest.class));
	}
	
	@Test
	public void testIsPrimitive() throws Exception {
		assertTrue(isPrimitive(double.class));
		assertTrue(isPrimitive(int.class));
		assertTrue(isPrimitive(boolean.class));
		assertFalse(isPrimitive(Double.class));
		assertFalse(isPrimitive(Integer.class));
		assertFalse(isPrimitive(Boolean.class));
		assertFalse(isPrimitive(String.class));
		assertFalse(isPrimitive(ReflectionHelperTest.class));
	}
	
	@Test
	public void testGetPrimitiveClass() throws Exception {
//		TODO: add all
		assertTrue(getPrimitiveClass(Boolean.class) == boolean.class);
		assertTrue(getPrimitiveClass(Double.class) == double.class);
		assertTrue(getPrimitiveClass(String.class) == null);
	}
	
	@Test
	public void testGetObjectClass() throws Exception {
		
	}
	
	@Test
	public void testForceGetPrimitiveClass() throws Exception {
		assertTrue(forceGetPrimitiveClass(Double.class) == double.class);
		assertTrue(forceGetPrimitiveClass(String.class) == String.class);
	}
	
	@Test
	public void testForceGetObjectClass() throws Exception {
		
	}
}

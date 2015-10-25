package com.n9mtq4.reflection;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static com.n9mtq4.reflection.ReflectionHelper.*;

/**
 * A class that when given an object, it will simplify the calls to ReflectionHelper
 * by automatically passing the obj param to the ReflectionHelper methods.
 * This class takes the static methods from ReflectionHelper and
 * implements them in an instance format.<br>
 * an example:<br>
 * <code>
 *     TestObject obj = new TestObject();<br>
 *     //these next two lines are the same.<br>
 *     ReflectionHelper.callVoidMethod("printStuff", obj);<br>
 *     ReflectionWrapper.attachToObject(obj).callMethod("printStuff");<br>
 * </code>
 * Created by will on 8/19/15 at 11:59 AM.
 * 
 * @param <E> the type of the object that the wrapper contains
 * @see ReflectionHelper
 * @since v1.1
 */
@SuppressWarnings("unused")
public final class ReflectionWrapper<E> implements Serializable {
	
	/**
	 * Wraps a new instance of an object (E) with the ReflectionWrapper.
	 *
	 * @param <E> the type of the object
	 * @param clazz the class to make a new instance of
	 * @param classParams an array of classes that the args are
	 * @param args the args to pass to the class' constructor
	 * @return the reflection wrapper
	 */
	public static <E> ReflectionWrapper<E> newInstance(Class clazz, Class[] classParams, Object... args) {
		E object = callConstructor(clazz, classParams, args);
		return new ReflectionWrapper<E>(object);
	}
	
	/**
	 * Wraps a new instance of an object (E) with the ReflectionWrapper.
	 *
	 * @param <E> the type of the object
	 * @param clazz the class to make a new instance of
	 * @param args the args to pass to the class' constructor
	 * @return the reflection wrapper
	 */
	public static <E> ReflectionWrapper<E> newInstance(Class clazz, Object... args) {
		E object = callConstructor(clazz, args);
		return attachToObject(object);
	}
	
	/**
	 * Wraps an existing object with the ReflectionWrapper.
	 *
	 * @param <E> the type of the object
	 * @param object the object
	 * @return the reflection wrapper
	 */
	public static <E> ReflectionWrapper<E> attachToObject(E object) {
		return new ReflectionWrapper<E>(object);
	}
	
	private final E object;
	
	private ReflectionWrapper(E object) {
		this.object = object;
	}
	
	/**
	 * Gets a member field from the object.
	 *
	 * @param fieldName the field name
	 * @return the field
	 */
	public final <R> R getField(String fieldName) {
		return getObject(fieldName, object);
	}
	
	/**
	 * Gets a member field from the object.
	 *
	 * @param field the field
	 * @return the field
	 */
	public final <R> R getField(Field field) {
		return getObject(field, object);
	}
	
	/**
	 * Sets a member field from the object.
	 *
	 * @param fieldName the field name
	 * @param newValue the new value of the field
	 */
	public final <R> void setField(String fieldName, R newValue) {
		setObject(newValue, fieldName, object);
	}
	
	/**
	 * Sets a member field from the object.
	 *
	 * @param field the field
	 * @param newValue the new value of the field
	 */
	public final <R> void setField(Field field, R newValue) {
		setObject(newValue, field, object);
	}
	
	
	/**
	 * Calls a member method from the object.
	 *
	 * @param <R> what the method returns
	 * @param name the name of the method
	 * @param args the args for the method
	 * @return the return of the method, null if the method is void
	 */
	public final <R> R callMethod(String name, Object... args) {
		return callObjectMethod(name, object, args);
	}
	
	/**
	 * Calls a member method from the object.
	 *
	 * @param <R> what the method returns
	 * @param name the name of the method
	 * @param classParams the class params
	 * @param args the args for the method
	 * @return the return of the method, null if the method is void
	 */
	public final <R> R callMethod(String name, Class[] classParams, Object... args) {
		return callObjectMethod(name, object, classParams, args);
	}
	
	/**
	 * Calls a member method from the object.
	 *
	 * @param <R> what the method returns
	 * @param method the method to call
	 * @param args the args for the method
	 * @return the return of the method, null if the method is void
	 */
	public final <R> R callMethod(Method method, Object... args) {
		return callObjectMethod(method, object, args);
	}
	
	
	/**
	 * Gets the object that the wrapper contains.
	 *
	 * @return the object the wrapper contains
	 */
	public final E getWrappedObject() {
		return object;
	}
	
	/**
	 * @see Object#toString()
	 * */
	@Override
	public final String toString() {
		return "ReflectionWrapper: " + object.toString();
	}
	
}

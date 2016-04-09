package com.n9mtq4.reflection;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
 * @param <R> the type of the object that the wrapper contains
 * @see ReflectionHelper
 * @since v1.1
 */
@SuppressWarnings("unused")
public final class ReflectionWrapper<R> implements Serializable {
	
	/**
	 * Wraps a new instance of an object (E) with the ReflectionWrapper.
	 *
	 * @param <R> the type of the object
	 * @param clazz the class to make a new instance of
	 * @param classParams an array of classes that the args are
	 * @param args the args to pass to the class' constructor
	 * @return the reflection wrapper
	 */
	public static <R> ReflectionWrapper<R> newInstance(Class clazz, Class[] classParams, Object... args) {
		R object = ReflectionHelper.callConstructor(clazz, classParams, args);
		return new ReflectionWrapper<R>(object);
	}
	
	/**
	 * Wraps a new instance of an object (E) with the ReflectionWrapper.
	 *
	 * @param <R> the type of the object
	 * @param clazz the class to make a new instance of
	 * @param args the args to pass to the class' constructor
	 * @return the reflection wrapper
	 */
	public static <R> ReflectionWrapper<R> newInstance(Class clazz, Object... args) {
		R object = ReflectionHelper.callConstructor(clazz, args);
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
	
	private final R object;
	
	private ReflectionWrapper(R object) {
		this.object = object;
	}
	
	/**
	 * Gets a member field from the object.
	 *
	 * @param fieldName the field name
	 * @return the field
	 */
	public final <T> T get(String fieldName) {
		return (T) ReflectionHelper.<T>getObject(fieldName, object);
	}
	
	/**
	 * Gets a member field from the object.
	 *
	 * @param field the field
	 * @return the field
	 */
	public final <T> T get(Field field) {
		return (T) ReflectionHelper.<T>getObject(field, object);
	}
	
	/**
	 * Sets a member field from the object.
	 *
	 * @param fieldName the field name
	 * @param newValue the new value of the field
	 */
	public final void set(String fieldName, Object newValue) {
		ReflectionHelper.setObject(newValue, fieldName, object);
	}
	
	/**
	 * Sets a member field from the object.
	 *
	 * @param field the field
	 * @param newValue the new value of the field
	 */
	public final void set(Field field, Object newValue) {
		ReflectionHelper.setObject(newValue, field, object);
	}
	
	
	/**
	 * Calls a member method from the object.
	 *
	 * @param <T> what the method returns
	 * @param name the name of the method
	 * @param args the args for the method
	 * @return the return of the method, null if the method is void
	 */
	public final <T> T call(String name, Object... args) {
		return (T) ReflectionHelper.<T>callObjectMethod(name, object, args);
	}
	
	/**
	 * Calls a member method from the object.
	 *
	 * @param <T> what the method returns
	 * @param name the name of the method
	 * @param classParams the class params
	 * @param args the args for the method
	 * @return the return of the method, null if the method is void
	 */
	public final <T> T call(String name, Class[] classParams, Object... args) {
		return (T) ReflectionHelper.<T>callObjectMethod(name, object, classParams, args);
	}
	
	/**
	 * Calls a member method from the object.
	 *
	 * @param <T> what the method returns
	 * @param method the method to call
	 * @param args the args for the method
	 * @return the return of the method, null if the method is void
	 */
	public final <T> T call(Method method, Object... args) {
		return (T) ReflectionHelper.<T>callObjectMethod(method, object, args);
	}
	
	
	/**
	 * Gets the object that the wrapper contains.
	 *
	 * @return the object the wrapper contains
	 */
	public final R getWrappedObject() {
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

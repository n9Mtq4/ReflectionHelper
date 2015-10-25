package com.n9mtq4.reflection;

import java.io.Serializable;
import java.lang.reflect.*;

/**
 * Created by will on 8/5/15 at 4:13 PM.<br>
 * A Class that simplifies using Proxies.<br>
 * NOTE: Some javadocs are oracle's.
 */
@SuppressWarnings("unused")
public final class EnhancedProxy implements InvocationHandler, Serializable {
	
	/**
	 * Creates a new instance of the interface with the proxy enabled. EX:<br>
	 * <code>Interface i = newInstance(new InterfaceInstance(args), new EnhancedInvocationHandler() {...})</code>
	 *
	 * @param <E>  the interface you wish for it to return
	 * @param obj the instance of the interface
	 * @param handler the EnhancedInvocationHandler
	 * @return an interface (<code>E</code>) instance (<code>obj</code>) with a proxy with an EnhancedInvocationHandler (<code>handler</code>)
	 */
	@SuppressWarnings("unchecked")
	public static <E> E newInstance(Object obj, EnhancedInvocationHandler handler) throws ClassCastException {
		return (E) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new EnhancedProxy(obj, handler));
	}
	
	/**
	 * Calls a method. This is good to call inside the EnhancedInvocationHandler.
	 * When called and passed the obj, method, and args from the params from
	 * {@link com.n9mtq4.reflection.EnhancedProxy.EnhancedInvocationHandler#invoke(Object, Object, Method, Object[])}
	 * it will call the method that was originally requested.
	 *
	 * @param obj the object the method is a member of. eg: <code>this</code>
	 * @param method the method
	 * @param args the args to pass to the method
	 * @return the object the method returns (Nullable)
	 */
	public static Object callChild(Object obj, Method method, Object[] args) throws Throwable{
		method.setAccessible(true);
		return method.invoke(obj, args);
	}
	
	private final Object obj;
	private final EnhancedInvocationHandler handler;
	
	private EnhancedProxy(Object obj, EnhancedInvocationHandler handler) {
		this.obj = obj;
		this.handler = handler;
	}
	
	@Override
	public final Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return handler.invoke(obj, proxy, method, args);
	}
	
	/**
	 * {@code InvocationHandler} is the interface implemented by
	 * the <i>invocation handler</i> of a proxy instance.
	 *
	 * <p>Each proxy instance has an associated invocation handler.
	 * When a method is invoked on a proxy instance, the method
	 * invocation is encoded and dispatched to the {@code invoke}
	 * method of its invocation handler.
	 *
	 * @author      Peter Jones
	 * @author      Will Bresnahan
	 * @see         Proxy
	 */
	public interface EnhancedInvocationHandler extends Serializable {
		
		/**
		 * Processes a method invocation on a proxy instance and returns
		 * the result.  This method will be invoked on an invocation handler
		 * when a method is invoked on a proxy instance that it is
		 * associated with.
		 * 
		 * @param obj the object the method is a member of. eg: <code>this</code>
		 * 
		 * @param   proxy the proxy instance that the method was invoked on
		 *
		 * @param   method the {@code Method} instance corresponding to
		 * the interface method invoked on the proxy instance.  The declaring
		 * class of the {@code Method} object will be the interface that
		 * the method was declared in, which may be a superinterface of the
		 * proxy interface that the proxy class inherits the method through.
		 *
		 * @param   args an array of objects containing the values of the
		 * arguments passed in the method invocation on the proxy instance,
		 * or {@code null} if interface method takes no arguments.
		 * Arguments of primitive types are wrapped in instances of the
		 * appropriate primitive wrapper class, such as
		 * {@code java.lang.Integer} or {@code java.lang.Boolean}.
		 *
		 * @return  the value to return from the method invocation on the
		 * proxy instance.  If the declared return type of the interface
		 * method is a primitive type, then the value returned by
		 * this method must be an instance of the corresponding primitive
		 * wrapper class; otherwise, it must be a type assignable to the
		 * declared return type.  If the value returned by this method is
		 * {@code null} and the interface method's return type is
		 * primitive, then a {@code NullPointerException} will be
		 * thrown by the method invocation on the proxy instance.  If the
		 * value returned by this method is otherwise not compatible with
		 * the interface method's declared return type as described above,
		 * a {@code ClassCastException} will be thrown by the method
		 * invocation on the proxy instance.
		 *
		 * @throws  Throwable the exception to throw from the method
		 * invocation on the proxy instance.  The exception's type must be
		 * assignable either to any of the exception types declared in the
		 * {@code throws} clause of the interface method or to the
		 * unchecked exception types {@code java.lang.RuntimeException}
		 * or {@code java.lang.Error}.  If a checked exception is
		 * thrown by this method that is not assignable to any of the
		 * exception types declared in the {@code throws} clause of
		 * the interface method, then an
		 * {@link UndeclaredThrowableException} containing the
		 * exception that was thrown by this method will be thrown by the
		 * method invocation on the proxy instance.
		 *
		 * @see     UndeclaredThrowableException
		 */
		Object invoke(Object obj, Object proxy, Method method, Object[] args) throws Throwable;
		
	}
	
}

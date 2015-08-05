package com.n9mtq4.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by will on 8/5/15 at 4:13 PM.
 */
public class EnhancedProxy implements InvocationHandler {
	
	public static <E> E newInstance(Object obj, EnhancedInvocationHandler handler) {
		return (E) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new EnhancedProxy(obj, handler));
	}
	
	public static void callChild(Object obj, Method method, Object[] args) {
		try {
			method.setAccessible(true);
			method.invoke(obj, args);
		}catch (InvocationTargetException e) {
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	private Object obj;
	EnhancedInvocationHandler handler;
	
	public EnhancedProxy(Object obj, EnhancedInvocationHandler handler) {
		this.obj = obj;
		this.handler = handler;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		return handler.invoke(obj, proxy, method, args);
		
	}
	
	public interface EnhancedInvocationHandler {
		
		Object invoke(Object obj, Object proxy, Method method, Object[] args);
		
	}
	
}

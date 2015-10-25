package com.n9mtq4.reflection;

/**
 * A class that contains methods to protect your methods
 * against the use of reflection.
 * 
 * <p>
 * Created by will on 10/24/15 at 7:39 PM.
 * 
 * @since v1.1
 * @author Will "n9Mtq4" Bresnahan
 */
@SuppressWarnings("unused")
public class ReflectionProtector {
	
	/**
	 * Returns if the calling method was invoked with reflection.
	 * <p>
	 * WARNING: this method is (relatively) slow, so use it sparingly.
	 * 
	 * @return boolean - if the calling method was invoked with reflection
	 * */
	public static boolean usedReflection() {
		return usedReflection(Thread.currentThread().getStackTrace());
	}
	
	private static boolean usedReflection(StackTraceElement[] stackTraceElements) {
		return usedReflection(3, stackTraceElements);
	}
	
	/**
	 * Returns if the stacktrace at the given index is a reflection one.
	 * <p>
	 * WARNING: this method is (relatively) slow, so use it sparingly.
	 * 
	 * @param index The index for the stacktrace
	 * @return boolean - if the stacktrace at the given index is a reflection one.
	 * */
	public static boolean usedReflection(int index) {
		return usedReflection(index, Thread.currentThread().getStackTrace());
	}
	
	private static boolean usedReflection(int index, StackTraceElement[] stackTraceElements) {
		return usedReflection(index, index + 1, stackTraceElements);
	}
	
	/**
	 * Returns if the stacktrace within the two ranges is a reflection one.
	 * <p>
	 * WARNING: this method is (relatively) slow, so use it sparingly.
	 * 
	 * @param min The starting stacktrace index
	 * @param max The ending stacktrace index
	 * @return boolean - if the stacktrace within the two ranges is a reflection one
	 * */
	public static boolean usedReflection(int min, int max) {
		return usedReflection(min, max, Thread.currentThread().getStackTrace());
	}
	
	private static boolean usedReflection(int min, int max, StackTraceElement[] stackTraceElements) {
		for (int i = min; i < max; i++) {
			if (stackTraceElements[i].getClassName().startsWith("java.lang.reflect") || stackTraceElements[i].getClassName().startsWith("sun.reflect")) return true;
			
		}
		return false;
	}
	
}

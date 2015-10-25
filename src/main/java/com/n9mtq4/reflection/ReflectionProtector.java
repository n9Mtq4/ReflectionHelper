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
	
	private static final int DEFAULT_INDEX = 3;
	
	/**
	 * In general, it seems that
	 * new Throwable().getStackTrace()
	 * is faster than
	 * Thread.currentThread().getStackTrace()
	 * 
	 * 420 ms, 316 ms, 298 ms, 297 ms, 349 ms, 307 ms, 297 ms, 298 ms, 307 ms - throwable
	 * 482 ms, 474 ms, 340 ms, 325 ms, 360 ms, 339 ms, 333 ms, 347 ms, 340 ms - thread
	 * 
	 * the first one requires the default index to be 3
	 * the second one requires the default index to be 3
	 * */
	private StackTraceElement[] getStackTrace() {
		return new Throwable().getStackTrace();
//		return Thread.currentThread().getStackTrace();
	}
	
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
		return usedReflection(DEFAULT_INDEX, stackTraceElements);
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

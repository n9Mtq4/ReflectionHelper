/*
 * NOTE: This is added by intellij IDE. Disregard this message if there is another copyright later in the file.
 * Copyright (C) 2014-2015  Will (n9Mtq4) Bresnahan
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.n9mtq4.reflection;

import sun.net.www.protocol.file.FileURLConnection;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Note: Use static import for best results.<br>
 * Class to simplify reflection calls.<br>
 */
@SuppressWarnings("unused")
public class ReflectionHelper {
	
	/**
	 * Gets a int.
	 *
	 * @param field the field
	 * @param obj the obj
	 * @return the int
	 */
	public static int getInt(Field field, Object obj) {
		try {
			field.setAccessible(true);
			return field.getInt(obj);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets a int.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 * @return the int
	 */
	public static int getInt(String fieldName, Object obj, Class clazz) {
		try {
			Field field = getAllDeclaredField(fieldName, clazz);
			return getInt(field, obj);
		}catch (NoSuchFieldException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Sets int.
	 *
	 * @param x the x
	 * @param field the field
	 * @param obj the obj
	 */
	public static void setInt(int x, Field field, Object obj) {
		try {
			field.setAccessible(true);
			field.setInt(obj, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets int.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 */
	public static void setInt(int x, String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setInt(x, f, obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a int.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @return the int
	 */
	public static int getInt(String fieldName, Object obj) {
		return getInt(fieldName, obj, obj.getClass());
	}
	
	/**
	 * Sets int.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 */
	public static void setInt(int x, String fieldName, Object obj) {
		setInt(x, fieldName, obj, obj.getClass());
	}
	
	/**
	 * Gets a static int.
	 *
	 * @param field the field
	 * @return the static int
	 */
	public static int getStaticInt(Field field) {
		try {
			field.setAccessible(true);
			return field.getInt(null);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets a static int.
	 *
	 * @param fieldName the field name
	 * @param clazz the class
	 * @return the static int
	 */
	public static int getStaticInt(String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getStaticInt(f);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Sets static int.
	 *
	 * @param x the x
	 * @param field the field
	 */
	public static void setStaticInt(int x, Field field) {
		try {
			field.setAccessible(true);
			field.setInt(null, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets static int.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param clazz the class
	 */
	public static void setStaticInt(int x, String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setStaticInt(x, f);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a byte.
	 *
	 * @param field the field
	 * @param obj the obj
	 * @return the byte
	 */
	public static byte getByte(Field field, Object obj) {
		try {
			field.setAccessible(true);
			return field.getByte(obj);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets a byte.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 * @return the byte
	 */
	public static byte getByte(String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getByte(f, obj);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Sets byte.
	 *
	 * @param x the x
	 * @param field the field
	 * @param obj the obj
	 */
	public static void setByte(byte x, Field field, Object obj) {
		try {
			field.setAccessible(true);
			field.setByte(obj, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets byte.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 */
	public static void setByte(byte x, String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			f.setAccessible(true);
			f.setByte(obj, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a byte.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @return the byte
	 */
	public static byte getByte(String fieldName, Object obj) {
		return getByte(fieldName, obj, obj.getClass());
	}
	
	/**
	 * Sets byte.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 */
	public static void setByte(byte x, String fieldName, Object obj) {
		setByte(x, fieldName, obj, obj.getClass());
	}
	
	/**
	 * Gets a static byte.
	 *
	 * @param field the field
	 * @return the static byte
	 */
	public static byte getStaticByte(Field field) {
		try {
			field.setAccessible(true);
			return field.getByte(null);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets a static byte.
	 *
	 * @param fieldName the field name
	 * @param clazz the class
	 * @return the static byte
	 */
	public static byte getStaticByte(String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getStaticByte(f);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Sets static byte.
	 *
	 * @param x the x
	 * @param field the field
	 */
	public static void setStaticByte(byte x, Field field) {
		try {
			field.setAccessible(true);
			field.setByte(null, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets static byte.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param clazz the class
	 */
	public static void setStaticByte(byte x, String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setStaticByte(x, f);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a boolean.
	 *
	 * @param field the field
	 * @param obj the obj
	 * @return the boolean
	 */
	public static boolean getBoolean(Field field, Object obj) {
		try {
			field.setAccessible(true);
			return field.getBoolean(obj);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Gets a boolean.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 * @return the boolean
	 */
	public static boolean getBoolean(String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getBoolean(f, obj);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Sets boolean.
	 *
	 * @param x the x
	 * @param field the field
	 * @param obj the obj
	 */
	public static void setBoolean(boolean x, Field field, Object obj) {
		try {
			field.setAccessible(true);
			field.setBoolean(obj, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets boolean.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 */
	public static void setBoolean(boolean x, String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setBoolean(x, f, obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a boolean.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @return the boolean
	 */
	public static boolean getBoolean(String fieldName, Object obj) {
		return getBoolean(fieldName, obj, obj.getClass());
	}
	
	/**
	 * Sets boolean.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 */
	public static void setBoolean(boolean x, String fieldName, Object obj) {
		setBoolean(x, fieldName, obj, obj.getClass());
	}
	
	/**
	 * Gets a static boolean.
	 *
	 * @param field the field
	 * @return the static boolean
	 */
	public static boolean getStaticBoolean(Field field) {
		try {
			field.setAccessible(true);
			return field.getBoolean(null);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Gets a static boolean.
	 *
	 * @param fieldName the field name
	 * @param clazz the class
	 * @return the static boolean
	 */
	public static boolean getStaticBoolean(String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getStaticBoolean(f);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Sets static boolean.
	 *
	 * @param x the x
	 * @param field the field
	 */
	public static void setStaticBoolean(boolean x, Field field) {
		try {
			field.setAccessible(true);
			field.setBoolean(null, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets static boolean.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param clazz the class
	 */
	public static void setStaticBoolean(boolean x, String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setStaticBoolean(x, f);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a char.
	 *
	 * @param field the field
	 * @param obj the obj
	 * @return the char
	 */
	public static char getChar(Field field, Object obj) {
		try {
			field.setAccessible(true);
			return field.getChar(obj);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets a char.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 * @return the char
	 */
	public static char getChar(String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getChar(f, obj);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Sets char.
	 *
	 * @param x the x
	 * @param field the field
	 * @param obj the obj
	 */
	public static void setChar(char x, Field field, Object obj) {
		try {
			field.setAccessible(true);
			field.setChar(obj, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets char.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 */
	public static void setChar(char x, String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setChar(x, f, obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a char.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @return the char
	 */
	public static char getChar(String fieldName, Object obj) {
		return getChar(fieldName, obj, obj.getClass());
	}
	
	/**
	 * Sets char.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 */
	public static void setChar(char x, String fieldName, Object obj) {
		setChar(x, fieldName, obj, obj.getClass());
	}
	
	/**
	 * Gets a static char.
	 *
	 * @param field the field
	 * @return the static char
	 */
	public static char getStaticChar(Field field) {
		try {
			field.setAccessible(true);
			return field.getChar(null);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets a static char.
	 *
	 * @param fieldName the field name
	 * @param clazz the class
	 * @return the static char
	 */
	public static char getStaticChar(String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getStaticChar(f);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Sets static char.
	 *
	 * @param x the x
	 * @param field the field
	 */
	public static void setStaticChar(char x, Field field) {
		try {
			field.setAccessible(true);
			field.setChar(null, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets static char.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param clazz the class
	 */
	public static void setStaticChar(char x, String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setStaticChar(x, f);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a float.
	 *
	 * @param field the field
	 * @param obj the obj
	 * @return the float
	 */
	public static float getFloat(Field field, Object obj) {
		try {
			field.setAccessible(true);
			return field.getFloat(obj);
		}catch (Exception e) {
			e.printStackTrace();
			return 0f;
		}
	}
	
	/**
	 * Gets a float.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 * @return the float
	 */
	public static float getFloat(String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getFloat(f, obj);
		}catch (Exception e) {
			e.printStackTrace();
			return 0f;
		}
	}
	
	/**
	 * Sets float.
	 *
	 * @param x the x
	 * @param field the field
	 * @param obj the obj
	 */
	public static void setFloat(float x, Field field, Object obj) {
		try {
			field.setAccessible(true);
			field.setFloat(obj, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets float.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 */
	public static void setFloat(float x, String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setFloat(x, f, obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a float.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @return the float
	 */
	public static float getFloat(String fieldName, Object obj) {
		return getFloat(fieldName, obj, obj.getClass());
	}
	
	/**
	 * Sets float.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 */
	public static void setFloat(float x, String fieldName, Object obj) {
		setFloat(x, fieldName, obj, obj.getClass());
	}
	
	/**
	 * Gets a static float.
	 *
	 * @param field the field
	 * @return the static float
	 */
	public static float getStaticFloat(Field field) {
		try {
			field.setAccessible(true);
			return field.getFloat(null);
		}catch (Exception e) {
			e.printStackTrace();
			return 0f;
		}
	}
	
	/**
	 * Gets a static float.
	 *
	 * @param fieldName the field name
	 * @param clazz the class
	 * @return the static float
	 */
	public static float getStaticFloat(String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getStaticFloat(f);
		}catch (Exception e) {
			e.printStackTrace();
			return 0f;
		}
	}
	
	/**
	 * Sets static float.
	 *
	 * @param x the x
	 * @param field the field
	 */
	public static void setStaticFloat(float x, Field field) {
		try {
			field.setAccessible(true);
			field.setFloat(null, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets static float.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param clazz the class
	 */
	public static void setStaticFloat(float x, String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setStaticFloat(x, f);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a double.
	 *
	 * @param field the field
	 * @param obj the obj
	 * @return the double
	 */
	public static double getDouble(Field field, Object obj) {
		try {
			field.setAccessible(true);
			return field.getDouble(obj);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets a double.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 * @return the double
	 */
	public static double getDouble(String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getDouble(f, obj);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Sets double.
	 *
	 * @param x the x
	 * @param field the field
	 * @param obj the obj
	 */
	public static void setDouble(double x, Field field, Object obj) {
		try {
			field.setAccessible(true);
			field.setDouble(obj, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets double.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 */
	public static void setDouble(double x, String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setDouble(x, f, obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a double.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @return the double
	 */
	public static double getDouble(String fieldName, Object obj) {
		return getDouble(fieldName, obj, obj.getClass());
	}
	
	/**
	 * Sets double.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 */
	public static void setDouble(double x, String fieldName, Object obj) {
		setDouble(x, fieldName, obj, obj.getClass());
	}
	
	/**
	 * Gets a static double.
	 *
	 * @param field the field
	 * @return the static double
	 */
	public static double getStaticDouble(Field field) {
		try {
			field.setAccessible(true);
			return field.getDouble(null);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets a static double.
	 *
	 * @param fieldName the field name
	 * @param clazz the class
	 * @return the static double
	 */
	public static double getStaticDouble(String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getStaticDouble(f);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Sets static double.
	 *
	 * @param x the x
	 * @param field the field
	 */
	public static void setStaticDouble(double x, Field field) {
		try {
			field.setAccessible(true);
			field.setDouble(null, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets static double.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param clazz the class
	 */
	public static void setStaticDouble(double x, String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setStaticDouble(x, f);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a long.
	 *
	 * @param field the field
	 * @param obj the obj
	 * @return the long
	 */
	public static long getLong(Field field, Object obj) {
		try {
			field.setAccessible(true);
			return field.getLong(obj);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets a long.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 * @return the long
	 */
	public static long getLong(String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getLong(f, obj);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Sets long.
	 *
	 * @param x the x
	 * @param field the field
	 * @param obj the obj
	 */
	public static void setLong(long x, Field field, Object obj) {
		try {
			field.setAccessible(true);
			field.setLong(obj, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets long.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 */
	public static void setLong(long x, String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setLong(x, f, obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a long.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @return the long
	 */
	public static long getLong(String fieldName, Object obj) {
		return getLong(fieldName, obj, obj.getClass());
	}
	
	/**
	 * Sets long.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 */
	public static void setLong(long x, String fieldName, Object obj) {
		setLong(x, fieldName, obj, obj.getClass());
	}
	
	/**
	 * Gets a static long.
	 *
	 * @param field the field
	 * @return the static long
	 */
	public static long getStaticLong(Field field) {
		try {
			field.setAccessible(true);
			return field.getLong(null);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets a static long.
	 *
	 * @param fieldName the field name
	 * @param clazz the class
	 * @return the static long
	 */
	public static long getStaticLong(String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getStaticLong(f);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Sets static long.
	 *
	 * @param x the x
	 * @param field the field
	 */
	public static void setStaticLong(long x, Field field) {
		try {
			field.setAccessible(true);
			field.setLong(null, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets static long.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param clazz the class
	 */
	public static void setStaticLong(long x, String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setStaticLong(x, f);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a short.
	 *
	 * @param field the field
	 * @param obj the obj
	 * @return the short
	 */
	public static short getShort(Field field, Object obj) {
		try {
			field.setAccessible(true);
			return field.getShort(obj);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Gets a short.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the clazz
	 * @return the short
	 */
	public static short getShort(String fieldName, Object obj, Class clazz) {
		try {
			Field field = getAllDeclaredField(fieldName, clazz);
			return getShort(field, obj);
		}catch (NoSuchFieldException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Sets short.
	 *
	 * @param x the x
	 * @param field the field
	 * @param obj the obj
	 */
	public static void setShort(short x, Field field, Object obj) {
		try {
			field.setAccessible(true);
			field.setShort(obj, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets short.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the clazz
	 */
	public static void setShort(short x, String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setShort(x, f, obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a short.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @return the short
	 */
	public static short getShort(String fieldName, Object obj) {
		return getShort(fieldName, obj, obj.getClass());
	}
	
	
	/**
	 * Sets short.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 */
	public static void setShort(short x, String fieldName, Object obj) {
		setShort(x, fieldName, obj, obj.getClass());
	}
	
	
	/**
	 * Gets a static short.
	 *
	 * @param field the field
	 * @return the static short
	 */
	public static short getStaticShort(Field field) {
		try {
			field.setAccessible(true);
			return field.getShort(null);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	/**
	 * Gets a static short.
	 *
	 * @param fieldName the field name
	 * @param clazz the clazz
	 * @return the static short
	 */
	public static short getStaticShort(String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getStaticShort(f);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * Sets static short.
	 *
	 * @param x the x
	 * @param field the field
	 */
	public static void setStaticShort(short x, Field field) {
		try {
			field.setAccessible(true);
			field.setShort(null, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Sets static short.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param clazz the clazz
	 */
	public static void setStaticShort(short x, String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setStaticShort(x, f);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a object.
	 *
	 * @param field the field
	 * @param obj the obj
	 * @return the object
	 */
	public static <E> E getObject(Field field, Object obj) {
		try {
			field.setAccessible(true);
			return (E) field.get(obj);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Gets a object.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 * @return the object
	 */
	public static <E> E getObject(String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getObject(f, obj);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Sets object.
	 *
	 * @param x the x
	 * @param field the field
	 * @param obj the obj
	 */
	public static void setObject(Object x, Field field, Object obj) {
		try {
			field.setAccessible(true);
			field.set(obj, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets object.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 * @param clazz the class
	 */
	public static void setObject(Object x, String fieldName, Object obj, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setObject(x, f, obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets a object.
	 *
	 * @param fieldName the field name
	 * @param obj the obj
	 * @return the object
	 */
	public static <E> E getObject(String fieldName, Object obj) {
		return getObject(fieldName, obj, obj.getClass());
	}
	
	/**
	 * Sets object.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param obj the obj
	 */
	public static void setObject(Object x, String fieldName, Object obj) {
		setObject(x, fieldName, obj, obj.getClass());
	}
	
	/**
	 * Gets a static object.
	 *
	 * @param field the field
	 * @return the static object
	 */
	public static <E> E getStaticObject(Field field) {
		try {
			field.setAccessible(true);
			return (E) field.get(null);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Gets a static object.
	 *
	 * @param fieldName the field name
	 * @param clazz the class
	 * @return the static object
	 */
	public static <E> E getStaticObject(String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			return getStaticObject(f);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Sets static object.
	 *
	 * @param x the x
	 * @param field the field
	 */
	public static void setStaticObject(Object x, Field field) {
		try {
			field.setAccessible(true);
			field.set(null, x);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets static object.
	 *
	 * @param x the x
	 * @param fieldName the field name
	 * @param clazz the class
	 */
	public static void setStaticObject(Object x, String fieldName, Class clazz) {
		try {
			Field f = getAllDeclaredField(fieldName, clazz);
			setStaticObject(x, f);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Call constructor.
	 *
	 * @param <E>  the type parameter
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the object
	 */
	public static <E> E callConstructor(Class clazz, Class[] classParams, Object[] params) {
		try {
			Constructor c = clazz.getDeclaredConstructor(classParams);
			c.setAccessible(true);
			return (E) c.newInstance(params);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Call constructor.
	 *
	 * @param <E>  the type parameter
	 * @param clazz the class
	 * @param params the params
	 * @return the object
	 */
	public static <E> E callConstructor(Class clazz, Object... params) {
		return callConstructor(clazz, getClassParams(params), params);
	}
	
	/**
	 * Call object method.
	 *
	 * @param <E>  the type parameter
	 * @param method the method
	 * @param obj the obj
	 * @param params the params
	 * @return the e
	 */
	public static <E> E callObjectMethod(Method method, Object obj, Object... params) {
		method.setAccessible(true);
		try {
			return (E) method.invoke(obj, params);
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		}catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Call object method.
	 *
	 * @param <E>  the type parameter
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the object
	 */
	public static <E> E callObjectMethod(String methodName, Object obj, Class clazz, Class[] classParams, Object[] params) {
		try {
			Method m = getAllDeclaredMethod(methodName, classParams, clazz);
			return callObjectMethod(m, obj, params);
		}catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Call object method.
	 *
	 * @param <E>  the type parameter
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param params the params
	 * @return the object
	 */
	public static <E> E callObjectMethod(String methodName, Object obj, Class clazz, Object... params) {
		return callObjectMethod(methodName, obj, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call object method.
	 *
	 * @param <E>  the type parameter
	 * @param methodName the method name
	 * @param obj the obj
	 * @param classParams the class params
	 * @param params the params
	 * @return the object
	 */
	public static <E> E callObjectMethod(String methodName, Object obj, Class[] classParams, Object[] params) {
		return callObjectMethod(methodName, obj, obj.getClass(), classParams, params);
	}
	
	/**
	 * Call object method.
	 *
	 * @param <E>  the type parameter
	 * @param methodName the method name
	 * @param obj the obj
	 * @param params the params
	 * @return the object
	 */
	public static <E> E callObjectMethod(String methodName, Object obj, Object... params) {
		return callObjectMethod(methodName, obj, getClassParams(params), params);
	}
	
	/**
	 * Call static object method.
	 *
	 * @param <E>  the type parameter
	 * @param methodName the method name
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the object
	 */
	public static <E> E callStaticObjectMethod(String methodName, Class clazz, Class[] classParams, Object[] params) {
		return callObjectMethod(methodName, null, clazz, classParams, params);
	}
	
	/**
	 * Call static object method.
	 *
	 * @param <E>  the type parameter
	 * @param methodName the method name
	 * @param clazz the class
	 * @param params the params
	 * @return the object
	 */
	public static <E> E callStaticObjectMethod(String methodName, Class clazz, Object... params) {
		return callStaticObjectMethod(methodName, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call void method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param params the params
	 */
	public static void callVoidMethod(String methodName, Object obj, Class clazz, Object[] params) {
		callVoidMethod(methodName, obj, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call void method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 */
	public static void callVoidMethod(String methodName, Object obj, Class clazz, Class[] classParams, Object[] params) {
		callObjectMethod(methodName, obj, clazz, classParams, params);
	}
	
	/**
	 * Call void method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param classParams the class params
	 * @param params the params
	 */
	public static void callVoidMethod(String methodName, Object obj, Class[] classParams, Object[] params) {
		callVoidMethod(methodName, obj, obj.getClass(), classParams, params);
	}
	
	/**
	 * Call void method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param params the params
	 */
	public static void callVoidMethod(String methodName, Object obj, Object... params) {
		callObjectMethod(methodName, obj, getClassParams(params), params);
	}
	
	/**
	 * Call static void method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param params the params
	 */
	public static void callStaticVoidMethod(String methodName, Class clazz, Object... params) {
		callStaticVoidMethod(methodName, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call static void method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 */
	public static void callStaticVoidMethod(String methodName, Class clazz, Class[] classParams, Object[] params) {
		callStaticObjectMethod(methodName, clazz, classParams, params);
	}
	
	/**
	 * Call int method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the int
	 */
	public static int callIntMethod(String methodName, Object obj, Class clazz, Class[] classParams, Object[] params) {
		return (Integer) callObjectMethod(methodName, obj, clazz, classParams, params);
	}
	
	/**
	 * Call int method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param params the params
	 * @return the int
	 */
	public static int callIntMethod(String methodName, Object obj, Class clazz, Object... params) {
		return callIntMethod(methodName, obj, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call int method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param classParams the class params
	 * @param params the params
	 * @return the int
	 */
	public static int callIntMethod(String methodName, Object obj, Class[] classParams, Object[] params) {
		return callIntMethod(methodName, obj, obj.getClass(), classParams, params);
	}
	
	/**
	 * Call int method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param params the params
	 * @return the int
	 */
	public static int callIntMethod(String methodName, Object obj, Object... params) {
		return callIntMethod(methodName, obj, getClassParams(params), params);
	}
	
	/**
	 * Call static int method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the int
	 */
	public static int callStaticIntMethod(String methodName, Class clazz, Class[] classParams, Object[] params) {
		return (Integer) callStaticObjectMethod(methodName, clazz, classParams, params);
	}
	
	/**
	 * Call static int method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param params the params
	 * @return the int
	 */
	public static int callStaticIntMethod(String methodName, Class clazz, Object... params) {
		return callStaticIntMethod(methodName, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call byte method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the byte
	 */
	public static byte callByteMethod(String methodName, Object obj, Class clazz, Class[] classParams, Object[] params) {
		return (Byte) callObjectMethod(methodName, obj, clazz, classParams, params);
	}
	
	/**
	 * Call byte method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param params the params
	 * @return the byte
	 */
	public static byte callByteMethod(String methodName, Object obj, Class clazz, Object... params) {
		return callByteMethod(methodName, obj, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call byte method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param classParams the class params
	 * @param params the params
	 * @return the byte
	 */
	public static byte callByteMethod(String methodName, Object obj, Class[] classParams, Object[] params) {
		return callByteMethod(methodName, obj, obj.getClass(), classParams, params);
	}
	
	/**
	 * Call byte method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param params the params
	 * @return the byte
	 */
	public static byte callByteMethod(String methodName, Object obj, Object... params) {
		return callByteMethod(methodName, obj, getClassParams(params), params);
	}
	
	/**
	 * Call static byte method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the byte
	 */
	public static byte callStaticByteMethod(String methodName, Class clazz, Class[] classParams, Object[] params) {
		return (Byte) callStaticObjectMethod(methodName, clazz, classParams, params);
	}
	
	/**
	 * Call static byte method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param params the params
	 * @return the byte
	 */
	public static byte callStaticByteMethod(String methodName, Class clazz, Object... params) {
		return callStaticByteMethod(methodName, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call boolean method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the boolean
	 */
	public static boolean callBooleanMethod(String methodName, Object obj, Class clazz, Class[] classParams, Object[] params) {
		return (Boolean) callObjectMethod(methodName, obj, clazz, classParams, params);
	}
	
	/**
	 * Call boolean method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param params the params
	 * @return the boolean
	 */
	public static boolean callBooleanMethod(String methodName, Object obj, Class clazz, Object... params) {
		return callBooleanMethod(methodName, obj, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call boolean method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param classParams the class params
	 * @param params the params
	 * @return the boolean
	 */
	public static boolean callBooleanMethod(String methodName, Object obj, Class[] classParams, Object[] params) {
		return callBooleanMethod(methodName, obj, obj.getClass(), classParams, params);
	}
	
	/**
	 * Call boolean method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param params the params
	 * @return the boolean
	 */
	public static boolean callBooleanMethod(String methodName, Object obj, Object... params) {
		return callBooleanMethod(methodName, obj, getClassParams(params), params);
	}
	
	/**
	 * Call static boolean method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the boolean
	 */
	public static boolean callStaticBooleanMethod(String methodName, Class clazz, Class[] classParams, Object[] params) {
		return (Boolean) callStaticObjectMethod(methodName, clazz, classParams, params);
	}
	
	/**
	 * Call static boolean method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param params the params
	 * @return the boolean
	 */
	public static boolean callStaticBooleanMethod(String methodName, Class clazz, Object... params) {
		return callStaticBooleanMethod(methodName, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call char method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the char
	 */
	public static char callCharMethod(String methodName, Object obj, Class clazz, Class[] classParams, Object[] params) {
		return (Character) callObjectMethod(methodName, obj, clazz, classParams, params);
	}
	
	/**
	 * Call char method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param params the params
	 * @return the char
	 */
	public static char callCharMethod(String methodName, Object obj, Class clazz, Object... params) {
		return callCharMethod(methodName, obj, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call char method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param classParams the class params
	 * @param params the params
	 * @return the char
	 */
	public static char callCharMethod(String methodName, Object obj, Class[] classParams, Object[] params) {
		return callCharMethod(methodName, obj, obj.getClass(), classParams, params);
	}
	
	/**
	 * Call char method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param params the params
	 * @return the char
	 */
	public static char callCharMethod(String methodName, Object obj, Object... params) {
		return callCharMethod(methodName, obj, getClassParams(params), params);
	}
	
	/**
	 * Call static char method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the char
	 */
	public static char callStaticCharMethod(String methodName, Class clazz, Class[] classParams, Object[] params) {
		return (Character) callStaticObjectMethod(methodName, clazz, classParams, params);
	}
	
	/**
	 * Call static char method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param params the params
	 * @return the char
	 */
	public static char callStaticCharMethod(String methodName, Class clazz, Object... params) {
		return callStaticCharMethod(methodName, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call float method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the float
	 */
	public static float callFloatMethod(String methodName, Object obj, Class clazz, Class[] classParams, Object[] params) {
		return (Float) callObjectMethod(methodName, obj, clazz, classParams, params);
	}
	
	/**
	 * Call float method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param params the params
	 * @return the float
	 */
	public static float callFloatMethod(String methodName, Object obj, Class clazz, Object... params) {
		return callFloatMethod(methodName, obj, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call float method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param classParams the class params
	 * @param params the params
	 * @return the float
	 */
	public static float callFloatMethod(String methodName, Object obj, Class[] classParams, Object[] params) {
		return callFloatMethod(methodName, obj, obj.getClass(), classParams, params);
	}
	
	/**
	 * Call float method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param params the params
	 * @return the float
	 */
	public static float callFloatMethod(String methodName, Object obj, Object... params) {
		return callFloatMethod(methodName, obj, getClassParams(params), params);
	}
	
	/**
	 * Call static float method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the float
	 */
	public static float callStaticFloatMethod(String methodName, Class clazz, Class[] classParams, Object[] params) {
		return (Float) callStaticObjectMethod(methodName, clazz, classParams, params);
	}
	
	/**
	 * Call static float method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param params the params
	 * @return the float
	 */
	public static float callStaticFloatMethod(String methodName, Class clazz, Object... params) {
		return callStaticFloatMethod(methodName, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call double method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the double
	 */
	public static double callDoubleMethod(String methodName, Object obj, Class clazz, Class[] classParams, Object[] params) {
		return (Double) callObjectMethod(methodName, obj, clazz, classParams, params);
	}
	
	/**
	 * Call double method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param params the params
	 * @return the double
	 */
	public static double callDoubleMethod(String methodName, Object obj, Class clazz, Object... params) {
		return callDoubleMethod(methodName, obj, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call double method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param classParams the class params
	 * @param params the params
	 * @return the double
	 */
	public static double callDoubleMethod(String methodName, Object obj, Class[] classParams, Object[] params) {
		return callDoubleMethod(methodName, obj, obj.getClass(), classParams, params);
	}
	
	/**
	 * Call double method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param params the params
	 * @return the double
	 */
	public static double callDoubleMethod(String methodName, Object obj, Object... params) {
		return callDoubleMethod(methodName, obj, getClassParams(params), params);
	}
	
	/**
	 * Call static double method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the double
	 */
	public static double callStaticDoubleMethod(String methodName, Class clazz, Class[] classParams, Object[] params) {
		return (Double) callStaticObjectMethod(methodName, clazz, classParams, params);
	}
	
	/**
	 * Call static double method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param params the params
	 * @return the double
	 */
	public static double callStaticDoubleMethod(String methodName, Class clazz, Object... params) {
		return callStaticDoubleMethod(methodName, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call long method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the long
	 */
	public static long callLongMethod(String methodName, Object obj, Class clazz, Class[] classParams, Object[] params) {
		return (Long) callObjectMethod(methodName, obj, clazz, classParams, params);
	}
	
	/**
	 * Call long method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param clazz the class
	 * @param params the params
	 * @return the long
	 */
	public static long callLongMethod(String methodName, Object obj, Class clazz, Object... params) {
		return callLongMethod(methodName, obj, clazz, getClassParams(params), params);
	}
	
	/**
	 * Call long method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param classParams the class params
	 * @param params the params
	 * @return the long
	 */
	public static long callLongMethod(String methodName, Object obj, Class[] classParams, Object[] params) {
		return callLongMethod(methodName, obj, obj.getClass(), classParams, params);
	}
	
	/**
	 * Call long method.
	 *
	 * @param methodName the method name
	 * @param obj the obj
	 * @param params the params
	 * @return the long
	 */
	public static long callLongMethod(String methodName, Object obj, Object... params) {
		return callLongMethod(methodName, obj, getClassParams(params), params);
	}
	
	/**
	 * Call static long method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param classParams the class params
	 * @param params the params
	 * @return the long
	 */
	public static long callStaticLongMethod(String methodName, Class clazz, Class[] classParams, Object[] params) {
		return (Long) callStaticObjectMethod(methodName, clazz, classParams, params);
	}
	
	/**
	 * Call static long method.
	 *
	 * @param methodName the method name
	 * @param clazz the class
	 * @param params the params
	 * @return the long
	 */
	public static long callStaticLongMethod(String methodName, Class clazz, Object... params) {
		return callStaticLongMethod(methodName, clazz, getClassParams(params), params);
	}
	
//	start stuff not written by me
//	BrainStorm @ https://stackoverflow.com/questions/520328/can-you-find-all-classes-in-a-package-using-reflection
	
	/**
	 * Attempts to list all the classes in the specified package as determined
	 * by the context class loader
	 *
	 * @param pckgname the package name to search
	 * @return a list of classes that exist within that package
	 * @throws ClassNotFoundException if something went wrong
	 */
	public static ArrayList<Class<?>> getClassesForPackage(String pckgname) throws ClassNotFoundException {
		final ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
		
		try {
			final ClassLoader cld = Thread.currentThread().getContextClassLoader();
			
			if (cld == null) throw new ClassNotFoundException("Can't get class loader.");
			
			Enumeration<URL> resources = cld.getResources(pckgname.replace('.', '/'));
			URLConnection connection;
			
			for (URL url = null; resources.hasMoreElements() && ((url = resources.nextElement()) != null); ) {
				try {
					connection = url.openConnection();
					
					if (connection instanceof JarURLConnection) {
						
						checkJarFile((JarURLConnection) connection, pckgname, classes);
						
					}else if (connection instanceof FileURLConnection) {
						
						try {
							checkDirectory(new File(URLDecoder.decode(url.getPath(), "UTF-8")), pckgname, classes);
						}catch (UnsupportedEncodingException ex) {
							throw new ClassNotFoundException(pckgname + " does not appear to be a valid package (Unsupported encoding)", ex);
						}
						
					}else
						throw new ClassNotFoundException(pckgname + " (" + url.getPath() + ") does not appear to be a valid package");
				}catch (final IOException ioex) {
					throw new ClassNotFoundException("IOException was thrown when trying to get all resources for " + pckgname, ioex);
				}
			}
		}catch (final NullPointerException ex) {
			throw new ClassNotFoundException(pckgname + " does not appear to be a valid package (Null pointer exception)", ex);
		}catch (final IOException ioex) {
			throw new ClassNotFoundException("IOException was thrown when trying to get all resources for " + pckgname, ioex);
		}
		
		return classes;
	}
	
	/**
	 * Private helper method.
	 *
	 * @param connection the connection to the jar
	 * @param pckgname   the package name to search for
	 * @param classes    the current ArrayList of all classes. This method will simply
	 *                   add new classes.
	 * @throws ClassNotFoundException if a file isn't loaded but still is in the jar file
	 * @throws IOException            if it can't correctly read from the jar file.
	 */
	private static void checkJarFile(JarURLConnection connection, String pckgname, ArrayList<Class<?>> classes) throws ClassNotFoundException, IOException {
		final JarFile jarFile = connection.getJarFile();
		final Enumeration<JarEntry> entries = jarFile.entries();
		String name;
		
		for (JarEntry jarEntry = null; entries.hasMoreElements() && ((jarEntry = entries.nextElement()) != null); ) {
			name = jarEntry.getName();
			
			if (name.contains(".class")) {
				name = name.substring(0, name.length() - 6).replace('/', '.');
				
				if (name.contains(pckgname)) {
					classes.add(Class.forName(name));
				}
			}
		}
	}
	
	/**
	 * Private helper method
	 *
	 * @param directory The directory to start with
	 * @param pckgname  The package name to search for. Will be needed for getting the
	 *                  Class object.
	 * @param classes   if a file isn't loaded but still is in the directory
	 * @throws ClassNotFoundException
	 */
	private static void checkDirectory(File directory, String pckgname, ArrayList<Class<?>> classes) throws ClassNotFoundException {
		File tmpDirectory;
		
		if (directory.exists() && directory.isDirectory()) {
			final String[] files = directory.list();
			
			for (final String file : files) {
				if (file.endsWith(".class")) {
					try {
						classes.add(Class.forName(pckgname + '.'
								+ file.substring(0, file.length() - 6)));
					}catch (NoClassDefFoundError e) {
//						Do nothing
					}
				}else if ((tmpDirectory = new File(directory, file))
						.isDirectory()) {
					checkDirectory(tmpDirectory, pckgname + "." + file, classes);
				}
			}
		}
	}
	
	/**
	 * Produce a List<String> which contains every combination which can be
	 * made by taking one String from each inner String array within the
	 * provided two-dimensional String array.
	 * @param twoDimArray a two-dimensional String array which contains
	 * String arrays of variable length.
	 * @return a List which contains every String which can be formed by taking
	 * one String from each String array within the specified two-dimensional
	 * array.<br>
	 * Slightly modified code from
	 * Bobulous @ https://stackoverflow.com/questions/15868914/how-to-get-2d-array-possible-combinations/15869610
	 */
	private static List<List<Class>> combinations(ArrayList<ArrayList<Class>> twoDimArray) {
//		TODO: find a better algorithm
		// keep track of the size of each inner String array
		int sizeArray[] = new int[twoDimArray.size()];
		
		// keep track of the index of each inner String array which will be used
		// to make the next combination
		int counterArray[] = new int[twoDimArray.size()];
		
		// Discover the size of each inner array and populate sizeArray.
		// Also calculate the total number of combinations possible using the
		// inner String array sizes.
		int totalCombinationCount = 1;
		for(int i = 0; i < twoDimArray.size(); ++i) {
			sizeArray[i] = twoDimArray.get(i).size();
			totalCombinationCount *= twoDimArray.get(i).size();
		}
		
		// Store the combinations in a List of String objects
		List<List<Class>> combinationList = new ArrayList<List<Class>>(totalCombinationCount);
		
		for (int countdown = totalCombinationCount; countdown > 0; --countdown) {
			// Run through the inner arrays, grabbing the member from the index
			// specified by the counterArray for each inner array, and build a
			// combination string.
			ArrayList<Class> obs = new ArrayList<Class>();
			for(int i = 0; i < twoDimArray.size(); ++i) {
				obs.add(twoDimArray.get(i).get(counterArray[i]));
			}
			combinationList.add(obs);  // add new combination to list
			
			// Now we need to increment the counterArray so that the next
			// combination is taken on the next iteration of this loop.
			for(int incIndex = twoDimArray.size() - 1; incIndex >= 0; --incIndex) {
				if(counterArray[incIndex] + 1 < sizeArray[incIndex]) {
					++counterArray[incIndex];
					// None of the indices of higher significance need to be
					// incremented, so jump out of this for loop at this point.
					break;
				}
				// The index at this position is at its max value, so zero it
				// and continue this loop to increment the index which is more
				// significant than this one.
				counterArray[incIndex] = 0;
			}
		}
		return combinationList;
	}
	
//	end stuff not written by me
	
	/**
	 * Find package names starting with.
	 *
	 * @param prefix the prefix
	 * @return the list
	 */
	public static List<String> findPackageNamesStartingWith(String prefix) {
		List<String> result = new ArrayList<String>();
		for (Package p : Package.getPackages()) {
			if (p.getName().startsWith(prefix)) {
				result.add(p.getName());
			}
		}
		return result;
	}
	
	/**
	 * Gets a class by simple name.
	 *
	 * @param simpleName the simple name
	 * @return the class by simple name
	 */
	public static Class getClassBySimpleName(String simpleName) {
		Package[] packages = Package.getPackages();
		for (Package p : packages) {
			
			try {
				
				ArrayList<Class<?>> classes = getClassesForPackage(p.getName());
				for (Class c : classes) {
					
					if (c.getSimpleName().equals(simpleName)) {
						
						return c;
						
					}
					
				}
				
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	
	/**
	 * Gets a class by full name.
	 *
	 * @param className the class name
	 * @return the class by full name
	 */
	public static Class getClassByFullName(String className) {
		try {
			return Class.forName(className);
		}catch (ClassNotFoundException e) {
			return null;
		}
	}
	
	/**
	 * Tries to get a class by its full name. If that fails, then
	 * it will try to get the class by its simple name.
	 * 
	 * @param name The name of the Class.
	 * @return The class, or null if no class is found
	 * */
	public static Class getClass(String name) {
		Class c = getClassByFullName(name);
		if (c != null) return c;
		return getClassBySimpleName(name);
	}
	
	/**
	 * This fixes the issue in java of getDeclaredFields not searching
	 * the class's inherited methods.
	 * */
	public static Field[] getAllDeclaredFields(Class clazz) {
		
		ArrayList<Field> fields = new ArrayList<Field>();
		
//		loop through all super classes until getSuperClass == null
		Class currentClass = clazz;
		while (currentClass != null) {
			fields.addAll(Arrays.asList(currentClass.getDeclaredFields()));
			currentClass = clazz.getSuperclass();
		}
		
		Field[] fields1 = new Field[fields.size()];
		System.arraycopy(fields.toArray(), 0, fields1, 0, fields.size());
		return fields1;
		
	}
	
	/**
	 * Get a field by name. Also searches inherited fields.
	 * */
	public static Field getAllDeclaredField(String name, Class clazz) throws NoSuchFieldException {
		Class currentClass = clazz;
		while (currentClass != null) {
			try {
				
				Field f = currentClass.getDeclaredField(name);
				return f;
				
			}catch (NoSuchFieldException e) {
			}
			currentClass = currentClass.getSuperclass();
		}
		
		throw new NoSuchFieldException(name);
	}
	
	public static Method[] getAllDeclaredMethods(Class clazz) {
		ArrayList<Method> methods = new ArrayList<Method>();
		
//		loop through all super classes until getSuperClass == null
		Class currentClass = clazz;
		while (currentClass != null) {
			methods.addAll(Arrays.asList(currentClass.getDeclaredMethods()));
			currentClass = currentClass.getSuperclass();
		}
		
		Method[] methods1 = new Method[methods.size()];
		System.arraycopy(methods.toArray(), 0, methods1, 0, methods.size());
		return methods1;
	}
	
	public static Method getAllDeclaredMethod(String name, Class[] params, Class clazz) throws NoSuchMethodException {
		try {
			Method m = findAllDeclaredMethodByParams(name, params, clazz);
			return m;
		}catch (NoSuchMethodException e) {}
		
		Class currentClass = clazz;
		while (currentClass != null) {
			
			Method[] methods = getAllDeclaredMethods(currentClass);
			ArrayList<Method> possibleMethods = new ArrayList<Method>();
			for (Method method : methods) {
				if (method.getName().equals(name)) possibleMethods.add(method);
			}
			
//			if there is only one possible method
			if (possibleMethods.size() == 1 && possibleMethods.get(0).getParameterCount() == params.length) {
				return possibleMethods.get(0);
			}
			
//			if there are more than one, try to isolate by number of params
			ArrayList<Method> nPossibleMethods = new ArrayList<Method>();
			for (Method method : possibleMethods) {
				if (method.getParameterCount() == params.length) nPossibleMethods.add(method);
			}
			possibleMethods = nPossibleMethods;
			if (possibleMethods.size() == 1) return possibleMethods.get(0);
			
//			if there are still more than one, try to narrow it down by superclasses
//			get all the superclasses for the list of params
//			this following code is TERRIBLE, but it (sometimes) works
			ArrayList<ArrayList<Class>> superClasses = new ArrayList<ArrayList<Class>>();
			ArrayList<Class> classes = new ArrayList<Class>();
			for (Class c : params) {
				Class currentClass1 = c;
				while (currentClass1 != null) {
					classes.add(currentClass1);
					currentClass1 = currentClass1.getSuperclass();
				}
				superClasses.add(classes);
			}
			
			List<List<Class>> combinations = combinations(superClasses);
			for (List<Class> combination : combinations) {
				Class[] c = combination.toArray(new Class[combination.size()]);
				try {
					Method m = findAllDeclaredMethodByParams(name, c, clazz);
					return m;
				}catch (NoSuchMethodException e) {}
			}
			
			currentClass = currentClass.getSuperclass();
		}
		
		throw new NoSuchMethodException(name);
		
	}
	
	public static Method findAllDeclaredMethodByParams(String name, Class[] params, Class clazz) throws NoSuchMethodException {
		Class currentClass = clazz;
		while (currentClass != null) {
			try {
				Method m = currentClass.getDeclaredMethod(name, params);
				return m;
			}catch (NoSuchMethodException e) {}
			currentClass = currentClass.getSuperclass();
		}
		throw new NoSuchMethodException(name);
	}
	
	/**
	 * Get class params.
	 *
	 * @param params the params
	 * @return the class [ ]
	 */
	public static Class[] getClassParams(Object[] params) {
		Class[] classParams = new Class[params.length];
		for (int i = 0; i < classParams.length; i++) {
			Class clazz = params[i].getClass();
			if (canBePrimitive(clazz)) {
				classParams[i] = getPrimitiveClass(clazz);
			}else {
				classParams[i] = clazz;
			}
		}
		return classParams;
	}
	
	/**
	 * Checks if the class has a primitive version.
	 * 
	 * @param clazz The class to check
	 * @return If the class given has a primitive version
	 * @see ReflectionHelper#isPrimitive(Class)
	 * */
	public static boolean canBePrimitive(Class clazz) {
		return getPrimitiveClass(clazz) != null;
	}
	
	/**
	 * Checks if the given class is primitive.
	 * 
	 * @param clazz The class to check
	 * @return If the class is primitive
	 * @see ReflectionHelper#canBePrimitive(Class)
	 * */
	public static boolean isPrimitive(Class clazz) {
		return getObjectClass(clazz) != null;
	}
	
	/**
	 * Primitive types have two classes in java.
	 * The primitive one (ie. int.class) and the 
	 * Object one (ie. Integer.class).
	 * This takes the Object one (ie. Integer.class)
	 * and returns a primitive one (ie. int.class)
	 *
	 * @param clazz The Object class to get the primitive version
	 * @return The Primitive version, or null if there isn't one
	 * @see ReflectionHelper#getObjectClass(Class)
	 * */
	public static Class getPrimitiveClass(Class clazz) {
		if (clazz == Boolean.class) return boolean.class;
		if (clazz == Byte.class) return byte.class;
		if (clazz == Character.class) return char.class;
		if (clazz == Double.class) return double.class;
		if (clazz == Float.class) return float.class;
		if (clazz == Long.class) return long.class;
		if (clazz == Short.class) return short.class;
		if (clazz == Integer.class) return int.class;
		return null;
	}
	
	/**
	 * Primitive types have two classes in java.
	 * The primitive one (ie. int.class) and the 
	 * Object one (ie. Integer.class).
	 * This takes the Object one (ie. int.class)
	 * and returns the primitive one (ie. Integer.class)
	 *
	 * @param clazz The primitive class to get the Object version
	 * @return The Object version, or null if there isn't one
	 * @see ReflectionHelper#getPrimitiveClass(Class)
	 * */
	public static Class getObjectClass(Class clazz) {
		if (clazz == boolean.class) return Boolean.class;
		if (clazz == byte.class) return Byte.class;
		if (clazz == char.class) return Character.class;
		if (clazz == double.class) return Double.class;
		if (clazz == float.class) return Float.class;
		if (clazz == long.class) return Long.class;
		if (clazz == short.class) return Short.class;
		if (clazz == int.class) return Integer.class;
		return null;
	} 
	
}

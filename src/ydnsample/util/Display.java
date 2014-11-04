package ydnsample.util;

import java.lang.reflect.Method;

public class Display {

	public static void print(Object obj) {
		print(obj, false);
	}

	/**
	 * オブジェクトの内容を表示する
	 * 
	 * @param obj
	 */
	public static void print(Object obj, boolean force) {
		if (!Constraint.DEBUG && !force)
			return;
		try {
			if (obj == null) {
				System.out.println("null");
			}
			System.out.println("[" + obj.getClass().getName() + "]");
			printObject(obj, "");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * オブジェクト単体の中身を表示する
	 * 
	 * @param obj
	 * @param header
	 * @throws Exception
	 */
	private static void printObject(Object obj, String header) throws Exception {
		Method[] methods = obj.getClass().getMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			
			/* @formatter:off */
			if (methodName.startsWith("get") && 
				method.getParameterTypes().length == 0 && 
				method.getDeclaringClass().getPackage().getName().startsWith("jp.yahooapis.im")) {
				/* @formatter:on */
				
				System.out.print(header + methodName.substring(3) + ": ");
				Object value = method.invoke(obj);
				if (value == null) {
					System.out.println("(null)");
					continue;
				}
				Class<?> clazz = value.getClass();
				if (IsViewable(clazz)) {
					System.out.println(value);
				} else if (clazz.isArray() && (clazz.getComponentType().equals(boolean.class) || clazz.getComponentType().equals(Boolean.class))) {
					System.out.println("(binary data)");
				} else {
					System.out.println();
					printObject(value, header + " ");
				}
			}
		}
	}

	/**
	 * 掘るかどうかの判定
	 * 
	 * @param clazz
	 * @return
	 */
	private static boolean IsViewable(Class<?> clazz) {
		/* @formatter:off */
		return 
			clazz.equals(Boolean.class) || 
			clazz.equals(Integer.class) || 
			clazz.equals(Long.class) || 
			clazz.equals(Short.class) || 
			clazz.equals(Character.class) || 
			clazz.equals(String.class) || 
			clazz.equals(Float.class) || 
			clazz.equals(Double.class) ||
			clazz.isEnum() || 
			clazz.isPrimitive();
		/* @formatter:on */
	}
}

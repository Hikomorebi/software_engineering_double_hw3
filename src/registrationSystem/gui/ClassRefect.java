package registrationSystem.gui;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Kunbin He,Haoze Zhu
 * @version 创建时间：2021年4月20日
 */
public class ClassRefect<T> {
	private static final Comparator MYSORT = null;

	/**
	 * 获取所有公有的字段
	 * @param obj
	 * @return
	 */
	public static Field[] getAllPublicAttribute(Object obj) {
		Class refClass = obj.getClass();
		// System.out.println(refClass);
		return refClass.getFields();
	}

	/**
	 * 获取所有定义的字段(包括私有、受保护、默认的)
	 * @param obj
	 * @return
	 */
	public static Field[] getAllAttribute(Object obj) {
		Class refClass = obj.getClass();
		// System.out.println(refClass);
		return refClass.getDeclaredFields();
	}

	/**
	 * 	获取所有公有的方法
	 * @param obj
	 * @return
	 */
	public static Method[] getAllPublicMethod(Object obj) {
		Class refClass = obj.getClass();
		// System.out.println(refClass);
		return refClass.getMethods();
	}

	/**
	 * 获取所有的Get方法
	 * @param obj
	 * @return
	 */
	public static List<Method> getAllGetMethod(Object obj) {
		List<Method> getMethods = new ArrayList<>();
		Class refClass = obj.getClass();
		// System.out.println(refClass);
		String[] row = { "getSid", "getSname", "getSage", "getSaddress", "getSnumber", "getSphone","getStime","getState" };
		Method[] methodArray = refClass.getMethods();
		for (String r : row) {
			for (Method m : methodArray) {
				if (m.getName() == r) {
					getMethods.add(m);
					//System.out.println(m.getName());
				}
			}
		}
		return getMethods;
	}

	/**
	 * 调用所有的Get方法
	 * @param obj
	 */
	public static void invokeAllGetMethod(Object obj) {
		Class refClass = obj.getClass();
		// System.out.println(refClass);
		Method[] methodArray = refClass.getMethods();
		for (Method m : methodArray) {
			// System.out.println(m);
			if (m.getName().contains("get")) {
				try {
					System.out.println(m.getName());
					System.out.println(m.invoke(obj, null));
				} catch (IllegalAccessException ex) {
					Logger.getLogger(ClassRefect.class.getName()).log(Level.SEVERE, null, ex);
				} catch (IllegalArgumentException ex) {
					Logger.getLogger(ClassRefect.class.getName()).log(Level.SEVERE, null, ex);
				} catch (InvocationTargetException ex) {
					Logger.getLogger(ClassRefect.class.getName()).log(Level.SEVERE, null, ex);
				}
			}

		}
	}

}

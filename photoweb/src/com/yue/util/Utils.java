package com.yue.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class Utils {
	//将页面的信息封装到bean中
	
	public static Object copyParameter2Properties (Map<String,String[]> values,Object object) {
		try {
			BeanUtils.populate(object, values);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return object;
	}
	public static int parseInt(String str,int defalut) {
		int result = 0;
		try {
			result = Integer.parseInt(str);
		} catch (Exception e) {
			result = defalut;
		}
		return result;
	}
//	public static long parseLong(String str,int defalut) {
	//	int result = 0;
	//}
	
	
}

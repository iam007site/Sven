package com.hsq.sven.utils;

import org.junit.Test;

/*author:huangshanqi
 *time  :2014年10月16日 下午6:25:19
 *email :hsqmobile@gmail.com
 */
public class ParamUtils {
	/*
	 * web请求参数检查类 
	 */
	
	/**
	 * 参数非空且不等于""返回true
	 * @param param
	 * @return
	 */
	public static boolean isNotEmpty(Object ...params){
		for(Object param:params){
			if (param == null || param.toString().equals("")) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test(){
		System.out.println(isNotEmpty(new Integer(0),66616546161616L,"1"));
	}
}

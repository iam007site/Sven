package com.hsq.sven.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*author:huangshanqi
 *time  :2014年10月7日 上午11:53:49
 *email :hsqmobile@gmail.com
 */
public class RegexUtils {
	/*
	 * 公共正则表达式验证
	 */
	
	/*用户名为以字母开头，由数字、字母和下划线组成的6-20个字符的字符串*/
	public static final String USERNAME_REGEX = "^[a-zA-Z][a-zA-Z0-9_]{5,19}$";
	
	
	public static final String PHONE_REGEX = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
	
	public static final String EMAIL_REGEX = "^([a-z0-9A-Z_]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	/*密码由数字、字母和下划线组成的6-20个字符的字符串*/
	public static final String PASSWORD_REGEX = "^[a-zA-Z0-9_]{6,20}$";
	
	public static final String SPECIAL_CHAR_REGEX = "[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
	/**
	 * 邮箱正则验证,符合返回true
	 */
	public static boolean checkEmail(String email){
		
		Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
		Matcher emailMatcher = emailPattern.matcher(email);
		
		return emailMatcher.matches();
	}
	
	/**
	 * 手机号正则验证,符合返回true
	 */
	public static boolean checkPhone(String phone){
		Pattern phonePattern = Pattern.compile(PHONE_REGEX);
		Matcher phoneMatcher = phonePattern.matcher(phone);
		return phoneMatcher.matches();
	}
	
	/**
	 * 密码正则验证,符合返回true
	 * 字母数字下划线,6-20个
	 */
	public  static boolean checkPassword(String password){
		Pattern passwordPattern = Pattern.compile(PASSWORD_REGEX);
		Matcher passwordMatcher = passwordPattern.matcher(password);
		return passwordMatcher.matches();
		
	}
	
	/**
	 * 是否有特许字符,有则ture
	 */
	public static boolean hasSpecialChar(String input){
		Pattern specialCharPattern = Pattern.compile(SPECIAL_CHAR_REGEX);
		Matcher specialCharMatcher = specialCharPattern.matcher(input);
		return specialCharMatcher.matches();
	}
	/**
	 * 用户名正则验证，符合返回true
	 * 不含特许字符，长度6-20
	 */
	public static boolean checkName(String name){
		return (!hasSpecialChar(name))&&(name.length()>=6)&&(name.length()<=20);
	}
	
	/**
	 * 正则检验所有参数，都正确返回true，否则返回
	 * @param username
	 * @param password
	 * @param email
	 * @param mobile
	 * @return
	 */
	public static boolean checkAll(String username,String password,String email,String mobile){
		return checkPassword(password)&&checkName(username)&&((email != null)?checkEmail(email):checkPhone(mobile));
	}
	
	/*
	@Test
	public void test(){
		System.out.println(checkName("kangda"));
	}
*/
}

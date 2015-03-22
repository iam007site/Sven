package com.caipiao.model;

import java.io.Serializable;

/*author:huangshanqi
 *time  :2015年2月1日 下午6:31:13
 *email :hsqmobile@gmail.com
 */
public class ResultModel implements Serializable {
	
	private String code;
	private String message;
	private Serializable data;

	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Serializable getData() {
		return data;
	}
	public void setData(Serializable data) {
		this.data = data;
	} 
	
	

}

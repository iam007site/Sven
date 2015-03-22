package com.caipiao.model;

import java.io.Serializable;
import java.util.Date;

/*author:huangshanqi
 *time  :2015年2月2日 下午9:05:52
 *email :hsqmobile@gmail.com
 */
public class SessionModel implements Serializable {
	private String email;
	private int userId;
	private String username;
	private Long expireshIn;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getExpireshIn() {
		return expireshIn;
	}

	public void setExpireshIn(Long expireshIn) {
		this.expireshIn = expireshIn;
	}

	public boolean isExpired(){
		Long now = new Date().getTime();
		return now > expireshIn;
	}
}

package com.caipiao.domain;

import java.io.Serializable;
import java.util.Date;

/*author:huangshanqi
 *time  :2015年1月31日 下午7:38:33
 *email :hsqmobile@gmail.com
 */
public class User implements Serializable {

	private int id;
	private Date createTime;
	private String username;
	private String email;
	private String password;
	private int emailAuth;
	private String salt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmailAuth() {
		return emailAuth;
	}

	public void setEmailAuth(int emailAuth) {
		this.emailAuth = emailAuth;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}

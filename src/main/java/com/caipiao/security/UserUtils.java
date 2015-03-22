package com.caipiao.security;

import org.apache.shiro.SecurityUtils;

import com.caipiao.model.SessionModel;
public abstract class UserUtils { 

	public static SessionModel getLoginUser() {

		SessionModel user =null;
		 user = (SessionModel) SecurityUtils.getSubject().getPrincipal();

		return user;
	}
	
}

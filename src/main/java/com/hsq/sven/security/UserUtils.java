package com.hsq.sven.security;

import org.apache.shiro.SecurityUtils;

import com.hsq.sven.model.SessionModel;
public abstract class UserUtils { 

	public static SessionModel getLoginUser() {

		SessionModel user =null;
		 user = (SessionModel) SecurityUtils.getSubject().getPrincipal();

		return user;
	}
	
}

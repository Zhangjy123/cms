package com.yofang.cms.cache;

import com.yofang.cms.model.User;


public class ManagerLoginInfo {

	/** 登录请求Session Id*/
	private String sessionId;
	/** 用户对象*/
	private User user;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

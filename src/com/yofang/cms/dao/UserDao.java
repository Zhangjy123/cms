package com.yofang.cms.dao;


import com.yofang.cms.model.User;

public interface UserDao extends BaseDao<User>{
	
	/**
	 * 根据用户名密码获取用户
	 * @param username
	 * @param password
	 * @return
	 */
	User getUser(String username, String password);

}

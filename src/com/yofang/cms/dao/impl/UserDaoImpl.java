package com.yofang.cms.dao.impl;



import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.UserDao;
import com.yofang.cms.model.User;

@IocBean(name="userDao",fields={"dao"})
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User getUser(String username, String password) {
		List<User> users = dao.query(User.class, Cnd.where("password", "=", password).and("mobile", "=", username));
		if (users.isEmpty() || users == null) {
			return null;
		}
		return users.get(0);
	}
}

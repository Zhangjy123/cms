package com.yofang.cms.service.impl;


import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.QueryResult;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.impl.UserDaoImpl;
import com.yofang.cms.model.Channel;
import com.yofang.cms.model.Role;
import com.yofang.cms.model.User;
import com.yofang.cms.service.ChannelService;
import com.yofang.cms.service.RoleService;
import com.yofang.cms.service.UserService;

@IocBean(name="userService", args={"refer:userDao"})
public class UserServiceImpl extends BaseServiceImpl<User, UserDaoImpl> implements UserService {
	
	@Inject
	private RoleService roleService;
	@Inject
	private ChannelService channelService;
	
	public UserServiceImpl(UserDaoImpl userDao) {
		super(userDao);
	}

	@Override
	public User getUser(String mobile, String password, boolean cascadeRole) {
		User user = baseDao.getUser(mobile, password);
		if (cascadeRole) {
			if (user != null && user.getRoleId() > 0) {
				Role role = roleService.getById(user.getRoleId());
				user.setRole(role);
			}
		}
		return user;
	}

	@Override
	public QueryResult getUserPageCascade(int pageNum, int pageSize) {
		QueryResult qr = baseDao.getPageList(pageNum, pageSize,Cnd.wrap("order by createTime desc"));
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) qr.getList();
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			Channel channel = channelService.getById(user.getChannelId());
			user.setChannel(channel);
			
			Role role = roleService.getById(user.getRoleId());
			user.setRole(role);
		}
		
		return qr;
	}

	@Override
	public User getUserByMobile(String mobile) {
		List<User> mobList = baseDao.getByConditon(Cnd.wrap("mobile="+mobile));
		if (mobList != null && !mobList.isEmpty()) {
			return mobList.get(0);
		}
		return null;
	}

	@Override
	public QueryResult getPageByTimeOrder(int pageNum, int pagesize) {
		baseDao.getPageList(pageNum, pagesize, Cnd.wrap("order by createTime desc"));
		return null;
	}
}

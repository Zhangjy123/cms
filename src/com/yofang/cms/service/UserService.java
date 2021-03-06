package com.yofang.cms.service;


import org.nutz.dao.QueryResult;

import com.yofang.cms.model.User;

public interface UserService extends BaseService<User>{
	
	/**
	 * 用户登录验证
	 * @param mobile
	 * @param password
	 * @param cascadeRole true 级联查询该用户具有的角色
	 * @return  true 通过验证   false 验证失败（账号或则密码错误）
	 */
	User getUser(String mobile, String password,boolean cascadeRole);
	
	/**
	 * 分页查询所有的用户,级联查询所有关联表信息,并且按时间排序
	 * @return
	 */
	QueryResult getUserPageCascade(int pageNum, int pageSize);
	
	/**
	 * 根据手机号码获取该用户信息
	 * @return
	 */
	User getUserByMobile(String mobile);
	
	/**
	 * 分页查询，按创建时间排序，最近的排在前面
	 * @param pageNum
	 * @param pagesize
	 * @return
	 */
	QueryResult getPageByTimeOrder(int pageNum, int pagesize);
	
}

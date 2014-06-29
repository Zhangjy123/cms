package com.yofang.cms.dao;


import java.util.List;

import com.yofang.cms.model.Privilege;
import com.yofang.cms.model.Role;

public interface RoleDao extends BaseDao<Role>{
	
	/**
	 * 查询Role中的所有数据，级联查询权限表
	 * @return
	 */
	List<Role> getAllRolePriveleges();
	
	/**
	 * 获取某个角色的所有权限
	 * @return
	 */
	List<Privilege> getPrivilgeOfRole(Role role);
	
}

package com.yofang.cms.service;


import java.util.List;

import com.yofang.cms.model.Role;
import com.yofang.cms.web.formbean.RoleBean;

public interface RoleService extends BaseService<Role>{
	
	/**
	 * 获取该系统所有角色的所有权限
	 * @return
	 */
	List<RoleBean> getAllRolePriveleges();
	
}

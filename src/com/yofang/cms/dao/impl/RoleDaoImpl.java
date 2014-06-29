package com.yofang.cms.dao.impl;



import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.PrivilegeDao;
import com.yofang.cms.dao.RoleDao;
import com.yofang.cms.model.Privilege;
import com.yofang.cms.model.Role;

@IocBean(name="roleDao",fields={"dao"})
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {
	
	@Inject
	private PrivilegeDao privilegeDao;
	
	@Override
	public List<Role> getAllRolePriveleges() {
		List<Role> roles = dao.query(Role.class, Cnd.wrap("1=1"));
		for (int i = 0; i < roles.size();i++) {
			Role role = roles.get(i);
			Role r = dao.fetchLinks(role, "privileges");
			role = r;
		}
		return roles;
	}
	
	@Override
	public List<Privilege> getPrivilgeOfRole(Role role) {
		Role r = dao.fetchLinks(role, "privileges");
		return r.getPrivileges();
	}

}

package com.yofang.cms.service.impl;


import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.impl.PrivilegeDaoImpl;
import com.yofang.cms.model.Privilege;
import com.yofang.cms.service.PrivilegeService;

@IocBean(name="privilegeService", args={"refer:privilegeDao"})
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege, PrivilegeDaoImpl> implements PrivilegeService {
	
	
	public PrivilegeServiceImpl(PrivilegeDaoImpl baseDao) {
		super(baseDao);
	}
}

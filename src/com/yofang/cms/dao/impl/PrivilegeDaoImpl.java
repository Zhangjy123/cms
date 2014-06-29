package com.yofang.cms.dao.impl;



import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.PrivilegeDao;
import com.yofang.cms.model.Privilege;

@IocBean(name="privilegeDao",fields={"dao"})
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao {

}

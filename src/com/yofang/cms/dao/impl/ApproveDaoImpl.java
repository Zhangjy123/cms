package com.yofang.cms.dao.impl;



import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.ApproveDao;
import com.yofang.cms.model.Approve;

@IocBean(name="approveDao",fields={"dao"})
public class ApproveDaoImpl extends BaseDaoImpl<Approve> implements ApproveDao {
	
}


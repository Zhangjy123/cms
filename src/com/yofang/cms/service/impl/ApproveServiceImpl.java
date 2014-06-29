package com.yofang.cms.service.impl;

import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.impl.ApproveDaoImpl;
import com.yofang.cms.model.Approve;
import com.yofang.cms.service.ApproveService;

@IocBean(name="approveService", args={"refer:approveDao"})
public class ApproveServiceImpl extends BaseServiceImpl<Approve, ApproveDaoImpl> implements ApproveService {
	
	public ApproveServiceImpl(ApproveDaoImpl baseDao) {
		super(baseDao);
	}
}

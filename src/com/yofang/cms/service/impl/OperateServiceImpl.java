package com.yofang.cms.service.impl;

import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.impl.OperateDaoImpl;
import com.yofang.cms.model.Operate;
import com.yofang.cms.service.OperateService;

@IocBean(name="operateService", args={"refer:operateDao"})
public class OperateServiceImpl extends BaseServiceImpl<Operate, OperateDaoImpl> implements OperateService {
	
	public OperateServiceImpl(OperateDaoImpl baseDao) {
		super(baseDao);
	}
}

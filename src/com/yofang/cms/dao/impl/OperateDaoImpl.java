package com.yofang.cms.dao.impl;



import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.OperateDao;
import com.yofang.cms.model.Operate;

@IocBean(name="operateDao",fields={"dao"})
public class OperateDaoImpl extends BaseDaoImpl<Operate> implements OperateDao {
	
}


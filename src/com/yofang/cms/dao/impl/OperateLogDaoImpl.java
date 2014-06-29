package com.yofang.cms.dao.impl;


import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.OperateLogDao;
import com.yofang.cms.model.OperateLog;

@IocBean(name="operateLogDao",fields={"dao"})
public class OperateLogDaoImpl extends BaseDaoImpl<OperateLog> implements OperateLogDao{
}

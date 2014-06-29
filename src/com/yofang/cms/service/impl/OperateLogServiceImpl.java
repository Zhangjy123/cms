package com.yofang.cms.service.impl;

import org.nutz.dao.Cnd;
import org.nutz.dao.QueryResult;
import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.impl.OperateLogDaoImpl;
import com.yofang.cms.model.OperateLog;
import com.yofang.cms.service.OperateLogService;




/**
 * 保存用户的操作日志
 * @author hsh
 */
@IocBean(name="operateLogService", args={"refer:operateLogDao"})
public class OperateLogServiceImpl extends BaseServiceImpl<OperateLog, OperateLogDaoImpl> implements OperateLogService{
	public OperateLogServiceImpl(OperateLogDaoImpl operateLogDao) {
		super(operateLogDao);
	}
	
	@Override
	public void saveEntity(OperateLog operateLog) {
		this.baseDao.save(operateLog);
	}

	@Override
	public QueryResult getPageInfoOrderByTime(int pageNum, int pagesize) {
		return baseDao.getPageList(pageNum, pagesize, Cnd.wrap("order by time desc"));
	}
}

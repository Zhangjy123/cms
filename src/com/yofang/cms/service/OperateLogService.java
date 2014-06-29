package com.yofang.cms.service;


import org.nutz.dao.QueryResult;

import com.yofang.cms.model.OperateLog;


/**
 * 保存用户的操作日志
 * @author hsh
 */
public interface OperateLogService extends BaseService<OperateLog>{
	/**
	 * 保存某个用户的一条操作日志记录
	 * @param operateLog
	 */
	void saveEntity(OperateLog operateLog);
	
	/**
	 * 按时间排序
	 * @param pageNum
	 * @param pagesize
	 * @return
	 */
	QueryResult getPageInfoOrderByTime(int pageNum, int pagesize);
	
}

package com.yofang.cms.service.impl;


import java.util.Date;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.QueryResult;
import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.BaseDao;
import com.yofang.cms.service.BaseService;

@IocBean(name="baseServie")
public class BaseServiceImpl<T,E extends BaseDao<T>> implements BaseService<T>{
	/**
	 * 由继承的子类通过调用BaseServiceImpl的构造器自动注入
	 */
	protected E baseDao;
	public BaseServiceImpl(E baseDao) {
		this.baseDao = baseDao;
	}
	
	
	@Override
	public void saveEntity(T t) {
		this.baseDao.save(t);
	}
	@Override
	public void deleteById(long id) {
		baseDao.deleteById(id);
	}
	@Override
	public void deleteByIdCascade(long id) {
		baseDao.deleteByIdCascade(id);
	}
	@Override
	public void updateEntity(T t) {
		baseDao.update(t);
	}
	@Override
	public T getById(long id) {
		return baseDao.getOneById(id);
	}
	@Override
	public T getByIdCascade(long id) {
		return baseDao.getOneByIdCascade(id);
	}

	@Override
	public T getOneByCondition(Condition condition, Boolean isCascade) {
		return baseDao.getOneByCondition(condition,isCascade);
	}
	@Override
	public List<T> findAll() {
		return baseDao.findAll();
	}
	@Override
	public QueryResult getPageInfo(int pageNum,int pageSize) {
		return baseDao.getPageList(pageNum, pageSize);
	}
	@Override
	public QueryResult getPageListByCondition(int pageNum,int pageSize,Condition condition) {
		return baseDao.getPageList(pageNum, pageSize,condition);
	}
	
	@Override
	public QueryResult getPageInfoByTime(int pageNum, int pagesize, Date startTime,
			Date endTime) {
		Cnd cnd = Cnd.where("1", "=", 1);
		//如果
		if (startTime == null && endTime == null) {
			return new QueryResult();
		}
		
		if (startTime != null && endTime != null) {
			startTime = startTime.getTime() <= endTime.getTime() ? startTime : endTime;
			cnd.and("time", "<", endTime).and("time", ">", startTime);
		} else if (endTime == null){
			cnd.and("time", ">", startTime);
		} else {
			cnd.and("time", "<", endTime);
		}
		return this.baseDao.getPageList(pageNum, pagesize,cnd);
	}


	@Override
	public QueryResult getPageInfoCascade(int pageNum, int pageSize) {
		return this.baseDao.getPageListCascade(pageNum, pageSize, null);
	}


	@Override
	public QueryResult getPageListByConditionCascade(int pageNum, int pageSize,
			Condition condition) {
		return this.baseDao.getPageListCascade(pageNum, pageSize, condition);
	}
}

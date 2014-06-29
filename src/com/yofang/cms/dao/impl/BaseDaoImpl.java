package com.yofang.cms.dao.impl;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;

import com.yofang.cms.dao.BaseDao;

@SuppressWarnings("all")
public class BaseDaoImpl<T> implements BaseDao<T>{
	
	/**
	 *  由子类从ioc容器中注入dao对象（配置文件nutzDao.js）
	 */
	protected static Dao dao;
	//泛型T的字节码
	private Class clazz;
	public BaseDaoImpl() {
		//获取父类的的字节码  this代表继承BaseDaoImpl子类的字节码
		Type parentType = this.getClass().getGenericSuperclass();
		//获取该类上的所有泛型
		Type[] types=((ParameterizedType)parentType).getActualTypeArguments();
		clazz = (Class)types[0];
		System.out.println(clazz);
	}
	public Dao getNutDao() {
		return dao;
	}
	
	@Override
	public void save(T t){
		dao.create(clazz, false);
		//单表保存
		dao.insert(t);
	}
	
	@Override
	public void update(T t) {
		dao.update(t);
	}
	
	@Override
	public void deleteById(long id) {
		dao.delete(clazz, id);
	}
	
	@Override
	public T getOneById(long id) {
		return (T) dao.fetch(clazz,id);
	}
	@Override
	public T getOneByIdCascade(long id) {
		Object obj = dao.fetch(clazz, id);
		return (T)dao.fetchLinks(obj, null);
	}
	@Override
	public T getOneByCondition(Condition condition, boolean isCascade) {
		return (T)dao.fetchLinks(dao.query(clazz, condition), null);
	}
	@Override
	public List<T> findAll() {
		return dao.query(clazz,null);
	}
	@Override
	public QueryResult getPageList(int pageNum, int pageSize) {
		
		if (pageNum <= 0) {
			pageNum = 1; 	//如果没有传参数，默认是第一页
		}
		Pager pager = new Pager();
		pager.setPageNumber(pageNum);
		pager.setPageSize(pageSize);
		
		//设置总页数
		int recordCount = dao.count(clazz);
		pager.setRecordCount(recordCount);
		
		//封装了一个分页查询的结果集合，包括本页数据列表以及分页信息
		QueryResult qr = new QueryResult();       
		qr.setList(dao.query(clazz, null, pager));
		qr.setPager(pager);
		return qr;
	}
	
	@Override
	public QueryResult getPageList(int pageNum, int pageSize, Condition condition) {
		if (pageNum <= 0) {
			pageNum = 1; 	//如果没有传参数，默认是第一页
		}
		Pager pager = new Pager();
		pager.setPageNumber(pageNum);
		pager.setPageSize(pageSize);
		
		//设置总页数
		int recordCount = dao.count(clazz,condition);
		pager.setRecordCount(recordCount);
		
		//封装了一个分页查询的结果集合，包括本页数据列表以及分页信息
		QueryResult qr = new QueryResult();       
		qr.setList(dao.query(clazz, condition, pager));
		qr.setPager(pager);
		return qr;
	}
	
	@Override
	public QueryResult getPageListCascade(int pageNum, int pageSize,
			Condition condition) {
		if (pageNum <= 0) {
			pageNum = 1; 	//如果没有传参数，默认是第一页
		}
		Pager pager = new Pager();
		pager.setPageNumber(pageNum);
		pager.setPageSize(pageSize);
		
		//设置总页数
		int recordCount = dao.count(clazz,condition);
		pager.setRecordCount(recordCount);
		
		//封装了一个分页查询的结果集合，包括本页数据列表以及分页信息
		QueryResult qr = new QueryResult();   
		List data = dao.query(clazz, condition, pager);
		//查询级联信息
		for (int i = 0; i < data.size(); i++) {
			Object obj = data.get(i);
			obj = dao.fetchLinks(obj, null);
		}
		qr.setList(data);
		qr.setPager(pager);
		return qr;
	}
	
	@Override
	public List<T> getByConditon(Condition condition) {
		List<T> data = dao.query(clazz, condition);
		return data;
	}
	@Override
	public void deleteByIdCascade(long id) {
		dao.deleteLinks(dao.fetch(clazz,id), null);
	}
}

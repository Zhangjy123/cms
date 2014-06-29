package com.yofang.cms.dao;


import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.QueryResult;

/**
 * 所有dao共有基类，抽取共有的方法
 * @author hsh
 */
public interface BaseDao<T> {
	
	/**
	 * 保存一条记录(没有级联关系)
	 * @param t
	 */
	void save(T t);
	/**
	 * 更新数据库中的一条记录(没有级联关系)
	 * @param t
	 */
	void update(T t);
	/**
	 * 根据id删除指定的记录(没有级联关系)
	 * @param id
	 */
	void deleteById(long id);
	/**
	 * 根据id删除指定的记录(删除级联记录以及关系)
	 * @param id
	 */
	void deleteByIdCascade(long id);
	/**
	 * 根据指定的id从数据库获取一条记录（无级联）
	 * @param id
	 * @return
	 */
	T getOneById(long id);
	/**
	 * 根据指定的id从数据库获取一条记录(级联)
	 * @param id
	 * @return
	 */
	T getOneByIdCascade(long id);
	/**
	 * 查询所有的数据（无分页）
	 * @return
	 */
	List<T> findAll();
	/**
	 * 分页查询
	 * @param pageNum	当前页
	 * @param pageSize  每页显示的数量
	 * @return QueryResult 分页数据结果集和当前的分页信息
	 */
	QueryResult getPageList(int pageNum, int pageSize);
	
	/**
	 * 分页查询(过滤条件) 不级联查询所有信息
	 * @param pageNum	当前页
	 * @param pageSize  每页显示的数量
	 * @return QueryResult 分页数据结果集和当前的分页信息
	 */
	QueryResult getPageList(int pageNum, int pageSize,Condition condition);
	
	/**
	 * 分页查询(过滤条件) 级联查询所有信息
	 * @param pageNum	当前页
	 * @param pageSize  每页显示的数量
	 * @return QueryResult 分页数据结果集和当前的分页信息
	 */
	QueryResult getPageListCascade(int pageNum, int pageSize,Condition condition);
	
	/**
	 * 根据条件查询某个表的数据
	 * @param condition	查询条件
	 * @return List<T> 
	 */
	List<T> getByConditon(Condition condition);
	
	/**
	 * 根据条件查询某个表的数据
	 * @param condition	查询条件
	 * @return List<T> 
	 */
	T getOneByCondition(Condition condition,boolean isCascade);
}

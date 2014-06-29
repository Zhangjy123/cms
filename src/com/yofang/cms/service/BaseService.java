package com.yofang.cms.service;


import java.util.Date;
import java.util.List;

import org.nutz.dao.Condition;
import org.nutz.dao.QueryResult;

/**
 * 业务层所有共有基类
 * 
 * @author hsh
 */
public interface BaseService<T> {
	/**
	 * 保存一条信息（无级联保存）
	 * 
	 * @param t
	 */
	void saveEntity(T t);

	/**
	 * 根据指定的的id删除一个信息（无级联）
	 * 
	 * @param id
	 */
	void deleteById(long id);
	/**
	 * 根据指定的的id删除一个信息（级联）
	 * 
	 * @param id
	 */
	void deleteByIdCascade(long id);
	
	/**
	 * 更新一条记录（无级联）
	 * @param t
	 */
	void updateEntity(T t);
	
	/**
	 * 根据指定的id查询一条记录（无级联）
	 * @param t
	 */
	T getById(long id);
	
	/**
	 * 根据指定的id查询一条记录（级联查询）
	 * @param t
	 */
	T getByIdCascade(long id);
	
	/**
	 * 根据条件查询某一条信息
	 * @param condition 查询条件
	 * @param isCascade 是否级联查询
	 * @return
	 */
	T getOneByCondition(Condition condition,Boolean isCascade);
	
	/**
	 * 查询所有的记录信息（无分页）
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 分页查询(无级联查询)
	 * @return
	 */
	QueryResult getPageInfo(int pageNum, int pageSize);
	
	/**
	 * 分页查询(级联查询所有信息)
	 * @return
	 */
	QueryResult getPageInfoCascade(int pageNum, int pageSize);
	
	/**
	 * 根据时间范围查询分页信息
	 * @param pageNum
	 * @param pagesize
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @return   如果都为空，返回 new QueryResult();
	 * 			  如果 startTime ＞　endTime　　　只查endTime一天的内容
	 *  		  如果 startTime endTime　只有一个为空，按单边条件查
	 */
	public QueryResult getPageInfoByTime(int pageNum, int pagesize, Date startTime,	Date endTime);
	
	/**
	 * 查询条件分页查询（无级联）
	 * @param pageNum
	 * @param pageSize
	 * @param condition
	 * @return
	 */
	public QueryResult getPageListByCondition(int pageNum, int pageSize,Condition condition);
	
	/**
	 * 查询条件分页查询(级联信息)
	 * @param pageNum
	 * @param pageSize
	 * @param condition
	 * @return
	 */
	public QueryResult getPageListByConditionCascade(int pageNum, int pageSize,Condition condition);
}

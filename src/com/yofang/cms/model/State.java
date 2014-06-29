package com.yofang.cms.model;


import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("STATE")
public class State implements Serializable{
	private static final long serialVersionUID = 8846883469355157419L;
	/** 主键*/
	@Id
	private Integer id;
	/** 状态名称*/
	@Column
	private String stateName;
	/**状态排序*/
	@Column
	private Integer sort;
	
	/**getter&setter*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
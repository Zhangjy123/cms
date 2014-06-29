package com.yofang.cms.model;

import java.io.Serializable;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * @author gaozp
 *
 */
@Table("OPERATE") 
public class Operate implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 主键*/
	@Id
	private Integer id;
	/**角色Id*/
	@Column
	private Integer roleId;
	/**状态Id*/
	@Column
	private Integer stateId;
	/**操作名称*/
	@Column
	private String operateName;
	/**操作URL*/
	@Column
	private String operateURL;
	/**操作权重排序*/
	private Integer sort;
	
	/**getter&setter*/
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public String getOperateName() {
		return operateName;
	}
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	public String getOperateURL() {
		return operateURL;
	}
	public void setOperateURL(String operateURL) {
		this.operateURL = operateURL;
	}

}

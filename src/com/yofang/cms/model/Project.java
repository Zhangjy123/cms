package com.yofang.cms.model;


import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 管理渠道对象  存储渠道管理基本信息
 * @author gaozp
 *
 */
@Table("PROJECT") 
public class Project implements Serializable{
	
	public static final int CATAGORY_OFFICE = 1;

	private static final long serialVersionUID = 8846883469355157419L;
	/** 主键*/
	@Id
	private Integer id;
	/** 项目名称*/
	private String name;
	/** 项目类别 */
	private Integer catagory;
	public Integer getCatagory() {
		return catagory;
	}

	public void setCatagory(Integer catagory) {
		this.catagory = catagory;
	}
	/** 项目地址*/
	private String address;	
	/** 创建时间*/
	private Date createDate;
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}

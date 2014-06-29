package com.yofang.cms.model;


import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * @author hsh
 *
 */
@Table("MANAGE_CUSTOMERFOLLOW")
public class CustomerFollow implements Serializable{
	private static final long serialVersionUID = 8846883469355157419L;
	/** 主键*/
	@Id
	private Integer id;
	/** 客户Id	*/
	private Integer customerId;
	@One(target=Customer.class, field="customerId")
	private Customer customer;
	/** 跟进记录*/
	private String content;
	/**跟进人姓名*/
	private String recorderName;
	/**身份*/
	private String roleName;
	/** 创建时间*/
	private Date createTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRecorderName() {
		return recorderName;
	}
	public void setRecorderName(String recorderName) {
		this.recorderName = recorderName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
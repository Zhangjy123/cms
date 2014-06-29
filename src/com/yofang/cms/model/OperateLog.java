package com.yofang.cms.model;



import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("SYS_OPERATE_LOG")
public class OperateLog implements Serializable{
	
	private static final long serialVersionUID = 249260631978360496L;
	@Id
	private Integer id;
	/** 用户账号*/
	private String useraccount;
	/** 操作日期*/
	private Date time;
	/** 操作内容*/
	private String description;
	/** IP*/
	private String ip;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUseraccount() {
		return useraccount;
	}
	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}

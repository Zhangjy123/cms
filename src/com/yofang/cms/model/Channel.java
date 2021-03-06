package com.yofang.cms.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Table;

/**
 * 管理渠道对象  存储渠道管理基本信息
 * @author gaozp
 *
 */
@Table("CHANNEL") 
public class Channel implements Serializable{

	private static final long serialVersionUID = 8846883469355157419L;
	/** 主键*/
	@Id
	private Integer id;
	/** 渠道名称*/
	private String channelName;
	/** 联系人 */
	private String contacts;
	/** 电话*/
	private String phone;	
	/** 创建时间*/
	private Date createDate;
	
	@Many(target=User.class, field="channelId")
	private List<User> users;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}

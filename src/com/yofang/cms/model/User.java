package com.yofang.cms.model;


import java.io.Serializable;
import java.util.Date;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.One;
import org.nutz.dao.entity.annotation.Table;

/**
 * 后台管理用户对象
 * 存储登录用户的基本信息
 * @author hsh
 *
 */
/**
 * @author hsh
 *
 */
/**
 * @author hsh
 *
 */
@Table("SYS_USER")
public class User implements Serializable{
	private static final long serialVersionUID = 8846883469355157419L;
	/** 主键*/
	@Id
	private Integer id;
	/** 手机号*/
	private String mobile;
	/** 姓名*/
	private String realName;
	/** 密码*/
	private String password;
	/** 创建日期*/
	private Date createTime;
	/** 所属公司	*/
	private Integer channelId;
	/** 所属公司	*/
	@One(target=Channel.class, field="channelId")
	private Channel channel ;
	/** 角色id--关联关系	*/
	private Integer roleId;
	/** 角色	*/
	@One(target=Role.class, field="roleId")
	private Role role;
	
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
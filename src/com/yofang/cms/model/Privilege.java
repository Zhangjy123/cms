package com.yofang.cms.model;

/**
 * 权限表
 * @author hsh
 */
import java.io.Serializable;
import java.util.List;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.ManyMany;
import org.nutz.dao.entity.annotation.Table;

/**
 * 1、包括菜单
 * 2、包括功能
 *
 */
@Table("SYS_PRIVELEGE")
public class Privilege implements Serializable{
	
	private static final long serialVersionUID = -8595283544990252695L;
	@Id
	private int id;//菜单树的节点ID
	private int pid;//父节点
	private String name;//  用户增加   用户删除  岗位增加
	private String flag;//该项是功能还是菜单   1表示菜单   2表示功能权限
	private Boolean isParent;
	private String icon;
	
	private String url;
	private String target;
	//private Boolean checked;
	
	/** 角色--关联关系多对多*/
	@ManyMany(target=Role.class, relation="SYS_ROLE_PRIVILEGE", from="roleId", to="privilegeId")
	private List<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}

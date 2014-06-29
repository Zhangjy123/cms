package com.yofang.cms.web.formbean;

import java.util.ArrayList;
import java.util.List;

import com.yofang.cms.model.Privilege;


/**
 * 该系统某个的角色具有的权限
 * 在构造函数中，map结构已经初始化完成
 * @author hsh
 */
public class RoleBean {
	private int roleId;
	private String roleName; //角色名字
	private List<Menu> Menu = new ArrayList<Menu>();
	private List<Privilege> funPrivileges = new ArrayList<Privilege>();
	
	public List<Menu> getMenu() {
		return Menu;
	}
	public void setMenu(List<Menu> menu) {
		Menu = menu;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		new Menu();
		this.roleName = roleName;
	}
	public List<Privilege> getFunPrivileges() {
		return funPrivileges;
	}
	public void setFunPrivileges(List<Privilege> funPrivileges) {
		this.funPrivileges = funPrivileges;
	}
}

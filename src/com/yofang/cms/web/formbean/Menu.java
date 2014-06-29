package com.yofang.cms.web.formbean;

import java.util.ArrayList;
import java.util.List;

import com.yofang.cms.model.Privilege;

/**
 * 导航栏菜单web临时封装bean
 * @author hsh
 *
 */
public class Menu {
	private Privilege oneMenu;
	private List<Privilege> towMenuList = new ArrayList<Privilege>();
	public Privilege getOneMenu() {
		return oneMenu;
	}
	public void setOneMenu(Privilege oneMenu) {
		this.oneMenu = oneMenu;
	}
	public List<Privilege> getTowMenuList() {
		return towMenuList;
	}
	public void setTowMenuList(List<Privilege> towMenuList) {
		this.towMenuList = towMenuList;
	}
}

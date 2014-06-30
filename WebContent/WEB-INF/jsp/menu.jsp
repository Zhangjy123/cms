<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.yofang.cms.web.formbean.Menu"%>
<%@page import="com.yofang.cms.model.Privilege"%>
<%@page import="java.util.List"%>
<%@page import="com.yofang.cms.web.formbean.RoleBean"%>
<%@page import="com.yofang.cms.cache.CachedItem"%>
<%@page import="com.yofang.cms.cache.CacheManager"%>
<%@page import="com.yofang.cms.model.User"%>
<%@page import="com.yofang.cms.manage.ManagerService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	User user =  ManagerService.getUser(request);							//获取登录的用户对象
	CachedItem item = CacheManager.getContent(user.getRole().getName());	//从缓存中获取该用户的权限
	RoleBean roleBean = (RoleBean)item.getValue();							
	List<Menu> menuPrivilegeList =  roleBean.getMenu();	//获取菜单
	System.out.println("menuPrivilegeList:"+menuPrivilegeList.size());
// 	List<Privilege> funPrivilegeList =  roleBean.getFunPrivileges();//获取功能权限
	
	request.setAttribute("loginUser", user);
%>
	<!--menu Start-->
	<div class="sidebar" id="sidebar">
		<h2>Browse categories</h2>
		<ul id="example2">
			<c:forEach var="menu" items="<%=menuPrivilegeList%>">
				<li name="oneMenuDisplay">
					<a href="${base}${menu.oneMenu.url}">${menu.oneMenu.name}</a>
					<ul id="twoMenuDisplay" >
						<c:forEach var="towMenu" items="${menu.towMenuList}">
						<li>
							<a href="${base}${towMenu.url}" class="menu_ae">${towMenu.name}</a>
						</li>
						</c:forEach>
					</ul>
				</li>
			</c:forEach>
		</ul>
		<h2>管理系统说明</h2>
		<div class="sidebar_section_text">123有房网后台管理系统有房网后台管理系统有房网后台管理系统有房网后台管理系统</div>
		<div class="clear"></div>

	</div>


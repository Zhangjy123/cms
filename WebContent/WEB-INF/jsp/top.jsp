<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.yofang.cms.web.formbean.Menu"%>
<%@page import="com.yofang.cms.model.Privilege"%>
<%@page import="java.util.List"%>
<%@page import="com.yofang.cms.web.formbean.RoleBean"%>
<%@page import="com.yofang.cms.cache.CachedItem"%>
<%@page import="com.yofang.cms.cache.CacheManager"%>
<%@page import="com.yofang.cms.model.User"%>
<%@page import="com.yofang.cms.manage.ManagerService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
	User user =  ManagerService.getUser(request);
%>
<div class="header">
	<div class="title">
		<a href="javascript:void(0);">有房网后台管理系统456</a>
	</div>
	<div class="header_right">
		<span style="float:left;">欢迎,</span><a style="float:left;" href="#"><%=user.getRealName()%></a><a href="#" class="button red" style="margin-top:-8px">注销</a>
	</div>
</div>
<div class="submenu">
	<ul></ul>
	<ul></ul>
	<ul></ul>
<!-- 
	<ul>
		<li><a href="#" class="selected">settings</a></li>
		<li><a href="#">users</a></li>
		<li><a href="#">categories</a></li>
		<li><a href="#">edit section</a></li>
		<li><a href="#">templates</a></li>
	</ul>
	 -->
</div>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="com.yofang.cms.web.formbean.Menu"%>
<%@page import="com.yofang.cms.model.sysmanage.Privilege"%>
<%@page import="java.util.List"%>
<%@page import="com.yofang.cms.web.formbean.RoleBean"%>
<%@page import="com.yofang.cms.cache.CachedItem"%>
<%@page import="com.yofang.cms.cache.CacheManager"%>
<%@page import="com.yofang.cms.model.sysmanage.User"%>
<%@page import="com.yofang.cms.manage.ManagerService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
	User user =  ManagerService.getUser(request);							//获取登录的用户对象
	CachedItem item = CacheManager.getContent(user.getRole().getName());	//从缓存中获取该用户的权限
	RoleBean roleBean = (RoleBean)item.getValue();							
	List<Menu> menuPrivilegeList =  roleBean.getMenu();				//获取菜单
	List<Privilege> funPrivilegeList =  roleBean.getFunPrivileges();//获取功能权限
	
	request.setAttribute("loginUser", user);
%>
<script src="${base}/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<div class="top">
  <div class="logo">
    <ul>
      <li><img src="${base}/images/khimg_r1_c1.jpg"></li>
      <li>有房网客户管理</li>
    </ul>
  </div>
  <!--退出-->
  <div class="out">
    <ul>
   	  <li><div>欢迎您:<%=user.getRealName() %>！</div></li>
      <li><a href="javascript:;">修改密码</a></li>
      <li>|</li>
      <li><a href="${base}/back/logout">注销</a></li>
    </ul>
  </div>
  <!--菜单-->
  <div class="menu">
    <ul>
      <c:forEach var="menu" items="<%=menuPrivilegeList %>">
		<li name="oneMenuDisplay">
			<a href="${base}${menu.oneMenu.url}" ${fn:split(menu.oneMenu.url,"/")[0]==param.oneMenu?"class='menu_aon'":"class='menu_a'" }>${menu.oneMenu.name}</a>
				<ul id="twoMenuDisplay" style="display: none;">
					<c:forEach var="towMenu" items="${menu.towMenuList}">
						<li>
							<a href="${base}${towMenu.url}" class="menu_ae">${towMenu.name}</a>
						</li>
					</c:forEach>
				</ul>
		</li>
      </c:forEach>
    </ul>
  </div>
</div>
<script type="text/javascript">
	$().ready(function(){
		$("li[name=oneMenuDisplay]").hover(
			  function () {
				  $(this).find("ul").show();
			  },
			  function () {
				  $(this).find("ul").hide();
			  }
		);
		
		$("li[name=oneMenuDisplay] a.menu_a").click(function(){
			$(this).attr("class","menu_aon");
		});
	});
</script>
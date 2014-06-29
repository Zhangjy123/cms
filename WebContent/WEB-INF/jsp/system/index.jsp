<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link href="../css/easydialog.css" rel="stylesheet" type="text/css">
<script src="../js/easydialog.min.js" type="text/javascript"></script>
</head>
<body>
	<jsp:include page="../menu.jsp">
		<jsp:param value="user" name="oneMenu"/>
	</jsp:include>
	<%-- 弹出层 --%>
	<jsp:include page="../public/yofangDialog.jsp" flush="true"></jsp:include>
		<div class="list cle">
			<table width="100%" border="1" cellpadding="0" cellspacing="0"  bordercolor="#000000">
				<tr style="font-size:14;">
				  <td>序号</td>
				  <td>姓名</td>
				  <td>手机号</td>
				  <td>角色</td>
				  <td>所属公司</td>
				  <td>创建时间</td>
				  <td width="100">操作</td>
				</tr>
				<c:forEach var="user" items="${obj.list}" varStatus="status">
					<tr style="color:#666;">
					  <td>${status.index+1}</td>
					  <td>${user.realName}</td>
					  <td>${user.mobile}</td>
					  <td>${user.role.name}</td>
					  <td>${user.channel.channelName}</td>
					  <td><fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
					  <td>
					  	  <a href="${base}/user/toupdate?id=${user.id}" class="table_a">修改</a>
					  	  <a href="${base}/user/delete?id=${user.id}" class="table_a">删除</a>
					  </td>
					</tr>
				</c:forEach>
			</table>
			<!-- 分页开始 -->
			<jsp:include page="../public/page.jsp" flush="true">
				<jsp:param name="url_page" value="${base}/user/index?pageNum="/>							
				<jsp:param name="pagenum_page" value="${obj.pager.pageNumber}"/>							
				<jsp:param name="pagecount_page" value="${obj.pager.pageCount}"/>							
				<jsp:param name="startBeforeNums" value="5"/>							
				<jsp:param name="endAfterNums" value="4"/>							
			</jsp:include>
			<!-- 分页结束-->	
		</div>
</body>
</html>

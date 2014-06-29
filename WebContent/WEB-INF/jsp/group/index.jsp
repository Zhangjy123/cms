<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="${base }/css/style.css" rel="stylesheet" type="text/css">
<script src="${base }/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<title>团购管理</title>
</head>
<body>
	<jsp:include page="../menu.jsp">
		<jsp:param value="group" name="oneMenu"/>
	</jsp:include>
	<!--内容-->
	<div class="cont">
		<div class="select cle">
			<form action="/group/index">
				<div class="name_ss">
					用户称呼： <input type="text" name="userRealName" value="${obj.userRealName}">
				</div>
				<div class="name_ss">
					项目名称： <input type="text" name="projectName" value="${obj.projectName}">
				</div>
				<div class="name_ss">
					电话： <input type="text" name="mobile" value="${obj.mobile}">
				</div>
				<div class="name_ss">
					<a href="javascript:;" onclick="submit();" class="cun">查询</a>
				</div>
			</form>
		</div>

		<div class="list cle">
			<table width="100%" border="1" cellpadding="0" cellspacing="0">
				<tr style="font-size: 14;">
					<td>序号</td>
					<td>用户称呼</td>
					<td>项目名称</td>
					<td>电话</td>
					<td>描述</td>
					<td>创建日期</td>
<!-- 					<td width="100">操作</td> -->
				</tr>
				<c:forEach items="${obj.list.list}" var="groupPurchase" varStatus="status">
					<tr ${status.index%2==1 ? "style='color: #666'" : "style='background-color: #F1F1F1;color: #666'" } >
						<td>${status.index+1}</td>
						<td>${groupPurchase.userRealName }</td>
						<td>${groupPurchase.projectName }</td>
						<td>${groupPurchase.mobile}</td>
						<td>${groupPurchase.desc}</td>
						<td><fmt:formatDate value="${groupPurchase.createDate}" pattern="yyyy-MM-dd"/></td>
						<!--
						<td>
							<a href="/project/update?id=${project.id }" class="table_a">修改</a>
							<a href="/project/delete?id=${project.id }" class="table_a">删除</a>
						</td>
						 -->
					</tr>
				</c:forEach>
			</table>
			
			<!-- 分页开始 -->
			<c:url var="urlStr" value="${base}/group/index">
			 	<c:if test="${!(empty obj.userRealName)}"><c:param name="userRealName" value="${obj.userRealName}"></c:param></c:if>
			 	<c:if test="${!(empty obj.projectName)}"><c:param name="projectName" value="${obj.projectName}"></c:param></c:if>
			 	<c:if test="${!(empty obj.mobile)}"><c:param name="mobile" value="${obj.mobile}"></c:param></c:if>
			 	<c:param name="pageNum" value=""></c:param>
			</c:url>
			<jsp:include page="../public/page.jsp" flush="true">
				<jsp:param name="url_page" value="${urlStr}"/>							
				<jsp:param name="pagenum_page" value="${obj.list.currentPage}"/>							
				<jsp:param name="pagecount_page" value="${obj.list.totalPage}"/>
				<jsp:param name="startBeforeNums" value="5" />
				<jsp:param name="endAfterNums" value="4" />				
			</jsp:include>
			<!-- 分页结束-->
		</div>
	</div>
</body>
<script>
	function submit() {
		$("form").submit();
	}
</script>
</html>

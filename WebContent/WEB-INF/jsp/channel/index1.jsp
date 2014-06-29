<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="${base}/css/style.css" rel="stylesheet" type="text/css">
<script src="${base}/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<title>渠道管理</title>
</head>

<body>
	<jsp:include page="../menu.jsp">
		<jsp:param value="channel" name="oneMenu"/>
	</jsp:include>
	<!--内容-->
	<div class="cont">
		<form action="${base}/channel/index" method="post">
			<div class="select cle">
				<div class="name_ss">
					渠道名称： <input name="channelName" type="text" style="width: 300px" value="${obj.channelName}">
				</div> 
				<div class="name_ss">
					联系人： <input name="contacts" type="text" value="${obj.contacts}">
				</div>
				<div class="name_ss">
					电话： <input name="phone" type="text" value="${obj.phone}" >
				</div>
				<div class="name_ss">
					<a href="javascript:void(0);" onclick="javascript:submit();"
						class="cun">查询</a>
				</div>
			</div>
		</form>
		<div class="list cle">
			<table width="100%" cellpadding="0" cellspacing="0">
				<tr style="font-size: 14;">
					<td>序号</td>
					<td>渠道名称</td>
					<td>联系人</td>
					<td>电话</td>
					<td width="100">操作</td>
				</tr>
				<c:forEach var="channel" items="${obj.qr.list}" varStatus="status">
					<tr
						${status.index%2==1 ? "style='color: #666'" : "style='background-color: #F1F1F1;color: #666'" }>
						<td>${status.index+1}</td>
						<td>${channel.channelName }</td>
						<td>${channel.contacts }</td>
						<td>${channel.phone }</td>
						<td>
							<a href="${base}/channel/update?id=${channel.id }" class="table_a">修改</a>
							<a href="${base}/channel/delete?id=${channel.id }" class="table_a">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<!-- 分页开始 -->
			<c:url var="urlStr" value="${base}/channel/index">
			 	<c:if test="${!(empty obj.channelName)}"><c:param name="channelName" value="${obj.channelName}"></c:param></c:if>
			 	<c:if test="${!(empty obj.contacts)}"><c:param name="contacts" value="${obj.contacts}"></c:param></c:if>
			 	<c:if test="${!(empty obj.phone)}"><c:param name="phone" value="${obj.phone}"></c:param></c:if>
			 	<c:param name="pageNum" value=""></c:param>
			</c:url>
			<jsp:include page="../public/page.jsp" flush="true">
				<jsp:param name="url_page" value="${urlStr}"/>							
				<jsp:param name="pagenum_page" value="${obj.qr.pager.pageNumber}"/>							
				<jsp:param name="pagecount_page" value="${obj.qr.pager.pageCount}"/>
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

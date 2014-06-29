<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>操作日志</title>
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
				  <td>操作人</td>
				  <td>操作内容</td>
				  <td>操作日期</td>
				  <td>IP</td>
				</tr>
				<c:forEach var="log" items="${obj.list}" varStatus="status">
					<tr style="color:#666;">
					  <td>${status.index+1}</td>
					  <td>${log.useraccount}</td>
					  <td style="display: right;">${log.description}</td>
					  <td><fmt:formatDate value="${log.time}" pattern="yyyy-MM-dd hh:mm:ss"/></td>
					  <td>${log.ip}</td>
					</tr>
				</c:forEach>
			</table>
			<!-- 分页开始 -->
			<jsp:include page="../public/page.jsp" flush="true">
				<jsp:param name="url_page" value="${base}/operatelog/index?pageNum="/>							
				<jsp:param name="pagenum_page" value="${obj.pager.pageNumber}"/>							
				<jsp:param name="pagecount_page" value="${obj.pager.pageCount}"/>							
				<jsp:param name="startBeforeNums" value="5"/>							
				<jsp:param name="endAfterNums" value="4"/>							
			</jsp:include>
			<!-- 分页结束-->	
		</div>
</body>
</html>

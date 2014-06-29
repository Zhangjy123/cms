<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="${base }/css/style.css" rel="stylesheet" type="text/css">
<script src="${base }/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<title>项目管理</title>
</head>
<body>
	<jsp:include page="../menu.jsp">
		<jsp:param value="project" name="oneMenu"/>
	</jsp:include>
	<!--内容-->
	<div class="cont">
		<div class="select cle">
			<form action="/project/index">
				<div class="name_ss">
					项目名称： <input type="text" name="name" value="${obj.name}">
				</div>
				<div class="name_ss">
					项目类别： <select name="catagory">
						<option value="" ${obj.catagory==0?'selected':''}>-请选择-</option>
						<option value="1" ${obj.catagory==1?'selected':''}>二手房</option>
						<option value="2" ${obj.catagory==2?'selected':''}>出租房</option>
						<option value="3" ${obj.catagory==3?'selected':''}>求购</option>
						<option value="4" ${obj.catagory==4?'selected':''}>求租</option>
						<option value="5" ${obj.catagory==5?'selected':''}>商铺</option>
						<option value="6" ${obj.catagory==6?'selected':''}>写字楼</option>
					</select>
				</div>
				<div class="name_ss">
					项目地址： <input type="text" style="width: 400px" name="address" value="${obj.address}">
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
					<td>项目名称</td>
					<td>项目类别</td>
					<td>项目地址</td>
					<td width="100">操作</td>
				</tr>
				<c:forEach items="${obj.qr.list}" var="project" varStatus="status">
					<tr ${status.index%2==1 ? "style='color: #666'" : "style='background-color: #F1F1F1;color: #666'" } >
						<td>${status.index+1}</td>
						<td>${project.name }</td>
						<td>
							<c:choose>
								<c:when test="${project.catagory==1}">二手房</c:when>
								<c:when test="${project.catagory==2}">出租房</c:when>
								<c:when test="${project.catagory==3}">求购</c:when>
								<c:when test="${project.catagory==4}">求租</c:when>
								<c:when test="${project.catagory==5}">商铺</c:when>
								<c:when test="${project.catagory==6}">写字楼</c:when>
								<c:otherwise>未知</c:otherwise>
							</c:choose>
						</td>
						<td>${project.address }</td>
						<td>
							<a href="/project/update?id=${project.id }" class="table_a">修改</a>
							<a href="/project/delete?id=${project.id }" class="table_a">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<!-- 分页开始 -->
			<c:url var="urlStr" value="${base}/project/index">
			 	<c:if test="${!(empty obj.name)}"><c:param name="name" value="${obj.name}"></c:param></c:if>
			 	<c:if test="${!(empty obj.catagory)}"><c:param name="catagory" value="${obj.catagory}"></c:param></c:if>
			 	<c:if test="${!(empty obj.address)}"><c:param name="name" value="${obj.address}"></c:param></c:if>
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

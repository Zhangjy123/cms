<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="${base }/css/style.css" rel="stylesheet" type="text/css">
<script src="${base }/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<link href="${base}/css/jquery.ui.theme.css" type="text/css" rel="stylesheet" />
<link href="${base}/css/jquery.ui.core.css" type="text/css" rel="stylesheet" />
<link href="${base}/css/jquery.ui.datepicker.css" type="text/css" rel="stylesheet" />
<title>客户管理</title>
</head>
<body>
	<jsp:include page="../menu.jsp">
		<jsp:param value="customer" name="oneMenu"/>
	</jsp:include>
	<!--内容-->
	<div class="cont">
		<div class="select cle">
			<form action="/customer/search" method="post">
				<div class="name_ss">
					客户姓名： <input type="text" name="realName" value="${obj.realName}">
				</div>
			<%-- 	<div class="name_ss">
					模糊查询
					客户电话： <input type="text" name="mobile" value="${obj.mobile}">
				</div> --%>
				<div class="name_ss">
					客户类别:<select name="customerType">
		                		<option value="" >请选择</option>
		                		<option value="1" ${obj.customerType==1?'selected':''}>个人</option>
		                		<option value="2" ${obj.customerType==2?'selected':''}>公司</option>
		                	</select>
				</div>
				<div class="name_ss">
					客户来源: <select name="fromWhere">
		                		<option value="">请选择</option>
		                		<option value="1" ${obj.fromWhere==1?'selected':''}>直客</option>
		                		<option value="2" ${obj.fromWhere==2?'selected':''}>渠道客户</option>
		                		<option value="3" ${obj.fromWhere==3?'selected':''}>公司内部</option>
		                		<option value="4" ${obj.fromWhere==4?'selected':''}>客户推荐</option>
		                	</select>
				</div>
				<div class="name_ss">
					起始登记时间:  <input id="queryStartTime" type="text" name="startTime" value="<fmt:formatDate value="${obj.startTime}" pattern="yyyy-MM-dd" />" readonly="readonly">
				</div>
				<div class="name_ss">
					截止登记时间:  <input id="queryEndTime" type="text" name="endTime" value="<fmt:formatDate value="${obj.endTime}" pattern="yyyy-MM-dd" />" readonly="readonly">
				</div>
				
				<div class="name_ss">
					项目名称: <select name="projectId">
		                		<option value="">请选择</option>
								<c:forEach var="project" items="${obj.projects}">
			                		<option value="${project.id}" ${project.id==obj.projectId?'selected':''}>${project.name}</option>
								</c:forEach>
				             </select>
						 
					
				</div>
				<div class="name_ss">
					渠道公司: 
							<select name="channelId">
	                		<option value="">请选择</option>
							<c:forEach var="channel" items="${obj.channels}">
		                		<option value="${channel.id}" ${channel.id==obj.channelId?'selected':''}>${channel.channelName}</option>
							</c:forEach>
				            </select>
				</div>
				
				<div class="name_ss">
					<a href="javascript:;" onclick="submit();" class="cun">查询</a>
				</div>
			</form>
		</div>

		<div class="list cle">
			<table border="1" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<th>序号</th>
					<th>看房客户</th>
					<th>手机</th>
					<th>客户类型</th>
					<th>项目类型</th>
					<th>项目名称</th>
					<th>来源</th>
					<th>推荐人</th>
					<th>需求</th>
					<th>信息录入人</th>
					
					<th>经纪人</th>
					<th>电话</th>
					<th>公司名</th>
					<th>登记时间</th>
					<th>预约时间</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${obj.qr.list}" var="customer" varStatus="status">
					<tr>
						<td>${status.index+1}</td>
						<td>${customer.realName}</td>
						<td>${customer.mobile}</td>
						<td>${customer.customerType==1?'个人':'公司'}</td>
						<td>${customer.project.catagory==1?'二手房':''}
							${customer.project.catagory==2?'出租房':''}
							${customer.project.catagory==3?'求购':''}
							${customer.project.catagory==4?'求租':''}
							${customer.project.catagory==5?'商铺':''}
							${customer.project.catagory==6?'写字楼':''}
						</td>
						<td>${customer.project.name}</td>
						<td>${customer.fromWhere==1?'直客':''}
							${customer.fromWhere==2?'渠道客户':''}
							${customer.fromWhere==3?'公司内部':''}
							${customer.fromWhere==4?'客户推荐':''}
						</td>
						<td>${customer.referee}</td>
						<td>${customer.requirement}</td>
						<td>${customer.user.realName}</td>
						
						<td>${customer.agentName}</td>
						<td>${customer.agentMobile}</td>
						<td>${customer.channel.channelName}</td>
						<td><fmt:formatDate value="${customer.createTime}" pattern="yyyy-MM-dd"/></td>
						<td><fmt:formatDate value="${customer.appointmentTime}" pattern="yyyy-MM-dd"/></td>
						<td>
							<%-- 预约信息录入只能是销售和渠道销售 --%>
							<c:if test="${loginUser.role.name=='销售' or loginUser.role.name=='渠道销售' or loginUser.role.name=='系统管理员'}">
								<c:if test="${customer.state==1 or customer.state==11 or loginUser.role.name=='系统管理员'}">
									<a href="/customer/appointment?id=${customer.id }" class="table_a">预约</a>
								</c:if>
							</c:if>
							
							<c:if test="${customer.state==1 or loginUser.role.name=='系统管理员'}">
								<a href="/customer/toubase?id=${customer.id}" class="table_a">修改</a>
							</c:if>
							
							<c:if test="${customer.state!=1 or loginUser.role.name=='系统管理员'}">
								<a href="/customer/tofollow?customerId=${customer.id}" class="table_a">跟进</a>
							</c:if>
							
							<c:if test="${(customer.state==1) or loginUser.role.name=='系统管理员'}">
								<a href="/customer/deletebase?id=${customer.id }" class="table_a">删除</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<!-- 分页开始 -->
			<c:url var="urlStr" value="${base}/customer/search">
			 	<c:if test="${!(empty obj.realName)}"><c:param name="realName" value="${obj.realName}"></c:param></c:if>
			 	<c:if test="${!(empty obj.customerType)}"><c:param name="customerType" value="${obj.customerType}"></c:param></c:if>
			 	<c:if test="${!(empty obj.fromWhere)}"><c:param name="fromWhere" value="${obj.fromWhere}"></c:param></c:if>
			 	<fmt:formatDate value="${obj.queryStartTime}" pattern="yyyy-MM-dd" var="startTime"/>
				<fmt:formatDate value="${obj.queryEndTime}" pattern="yyyy-MM-dd" var="endTime"/>
				<c:if test="${!(empty startTime)}"><c:param name="startTime" value="${startTime}" /></c:if>
			 	<c:if test="${!(empty endTime)}"><c:param name="endTime" value="${endTime}" /></c:if>
			 	<c:if test="${!(empty obj.projectId)}"><c:param name="projectId" value="${obj.projectId}" /></c:if>
			 	<c:if test="${!(empty obj.channelId)}"><c:param name="channelId" value="${obj.channelId}" /></c:if>
				
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
  <!-- 时间input框插件 -->
<script type="text/javascript" src="${base}/script/jquery.ui.core.js" charset="utf-8"></script>
		<script type="text/javascript" src="${base}/script/jquery.ui.datepicker.js" charset="utf-8"></script>
		<script type="text/javascript" src="${base}/script/jquery.ui.datepicker-zh-CN.js" charset="utf-8"></script>
		<script type="text/javascript">
		$(function() {
			var timedate = $("#queryStartTime, #queryEndTime").datepicker({
				defaultDate: 1,
				changeMonth: true,
				changeYear: true,
				numberOfMonths: 1,
				onSelect: function(selectedDate) {
					var option = this.id == "queryStartTime" ? "minDate" : "maxDate",
						instance = $(this).data( "datepicker" ),
						date = $.datepicker.parseDate(
							instance.settings.dateFormat ||
							$.datepicker._defaults.dateFormat,
							selectedDate, instance.settings );
							timedate.not(this).datepicker( "option", option, date );
				},
				onClose: function(){
					if(this.id=="timeFrom" && $("#timeTo").val()=="" && $(this).val()!==""){
						$("#timeTo").focus();
					}
				}
			});
		});
</script>
<script>
	function submit() {
		$("form").submit();
	}
</script>
</html>

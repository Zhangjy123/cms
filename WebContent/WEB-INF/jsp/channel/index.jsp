<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>渠道管理</title>
<link rel="stylesheet" type="text/css" href="${base}/css/style.css" />
<!-- <link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'> -->
<!-- jQuery file -->
<script src="${base}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${base}/js/jquery.hoveraccordion.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example2').hoverAccordion({
			activateitem : '1',
			speed : 'fast'
		});

		$("#123").toggle(function() {
			if($("#tab2").is(':visible')){
				$("#tab2").slideUp();
			}
			$("#tab1").slideDown();
		}, function() {
			if($("#tab2").is(':visible')){
				$("#tab2").slideUp();
				$("#tab1").slideDown();
			}else{
				$("#tab1").slideUp();
			}
		});
		
		$("#add").toggle(function() {
			if($("#tab1").is(':visible')){
				$("#tab1").slideUp();
			}
			$("#tab2").slideDown();
		}, function() {
			if($("#tab1").is(':visible')){
				$("#tab1").slideUp();
				$("#tab2").slideDown();
			}else{
				$("#tab2").slideUp();
			}
			
		});
		
	});
	
</script>
</head>
<body>
	<div id="panelwrap">
		<div class="header">
			<div class="title">
				<a href="#">Panelo Admin</a>
			</div>
			<div class="header_right">
				Welcome Admin, <a href="#" class="settings">Settings</a> <a href="#"
					class="logout">Logout</a>
			</div>
		</div>
		<div class="submenu">
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
		<div class="center_content">
			<div id="right_wrap">

				<div id="right_content">
					<h2>
						渠道管理列表 
						<span><a id="123" href="javascript:;">搜索</a>|<a id="add" href="javascript:void(0);">添加</a></span>
					</h2>
					
					<!-- 搜索 -->
					<div id="tab1" class="tabcontent" style="display: none;">
						<h3>Tab one title</h3>
						<form action="${base}/channel/index" method="post">
						<div class="form">

							<div class="form_row">
								<label>渠道名称：</label> <input type="text" class="form_input" value="${obj.channelName}"
									name="channelName" />
							</div>

							<div class="form_row">
								<label>联&nbsp;&nbsp;系&nbsp;&nbsp;人：</label> <input type="text" class="form_input"
									name="contacts" value="${obj.contacts}"/>
							</div>

							<div class="form_row">
								<label>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</label> 
									<input type="text" class="form_input"  name="phone" value="${obj.phone}" />
							</div>

							<!-- <div class="form_row">
								<label>Message:</label>
								<textarea class="form_textarea" name=""></textarea>
							</div> -->
							<div class="form_row">
								<input type="submit" class="form_submit" value="搜索" onclick="javascript:submit();" />
							</div>
							<div class="clear"></div>
						</div>
						</form>
					</div>
					<!-- 结束 -->
					
					<!-- 添加渠道  -->
					<div id="tab2" class="tabcontent" style="display: none;">
						<h3>Tab one title</h3>
						<form action="${base}/channel/save" method="post">
						<div class="form">

							<div class="form_row">
								<label>渠道名称：</label> <input type="text" class="form_input" value="${obj.channelName}"
									name="channelName" />
							</div>

							<div class="form_row">
								<label>联&nbsp;&nbsp;系&nbsp;&nbsp;人：</label> <input type="text" class="form_input"
									name="contacts" value="${obj.contacts}"/>
							</div>

							<div class="form_row">
								<label>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</label> 
									<input type="text" class="form_input"  name="phone" value="${obj.phone}" />
							</div>

							<!-- <div class="form_row">
								<label>Message:</label>
								<textarea class="form_textarea" name=""></textarea>
							</div> -->
							<div class="form_row">
								<input type="submit" class="form_submit" value="添加" onclick="javascript:submit();" />
							</div>
							<div class="clear"></div>
						</div>
						</form>
					</div>
					<!--添加渠道结束 -->
					
					<table id="rounded-corner">
						<thead>
							<tr>
								<th></th>
								<th>渠道名称</th>
								<th>联系人</th>
								<th>电话</th>
								<th>操作</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="channel" items="${obj.qr.list}"
								varStatus="status">
								<tr class="odd"
									${status.index%2==1 ? "style='color: #666'" : "style='background-color: #F1F1F1;color: #666'" }>
									<td>${status.index+1}</td>
									<td>${channel.channelName }</td>
									<td>${channel.contacts }</td>
									<td>${channel.phone }</td>
									<td>
										<a href="${base}/channel/update?id=${channel.id }" class="button green">修改</a>
									<!-- </td>
									<td> -->
										<a href="${base}/channel/delete?id=${channel.id }" class="button red">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>

						<tfoot>
							<tr>
								<td colspan="12">
									<!-- 分页开始 --> 
									<c:url var="urlStr" value="${base}/channel/index">
										<c:if test="${!(empty obj.channelName)}">
											<c:param name="channelName" value="${obj.channelName}"></c:param>
										</c:if>
										<c:if test="${!(empty obj.contacts)}">
											<c:param name="contacts" value="${obj.contacts}"></c:param>
										</c:if>
										<c:if test="${!(empty obj.phone)}">
											<c:param name="phone" value="${obj.phone}"></c:param>
										</c:if>
										<c:param name="pageNum" value=""></c:param>
									</c:url> 
									<jsp:include page="../public/page.jsp" flush="true">
										<jsp:param name="url_page" value="${urlStr}" />
										<jsp:param name="pagenum_page"
											value="${obj.qr.pager.pageNumber}" />
										<jsp:param name="pagecount_page"
											value="${obj.qr.pager.pageCount}" />
										<jsp:param name="startBeforeNums" value="5" />
										<jsp:param name="endAfterNums" value="4" />
									</jsp:include> 
									<!-- 分页结束-->
								</td>
							</tr>
						</tfoot>

					</table>

					


				</div>
			</div>
			<!-- end of right content-->
			<!-- 左边框 -->
			<div class="sidebar" id="sidebar">
				<h2>Browse categories</h2>

				<ul id="example2">
					<li><a href="#" class="selected">Main page</a>
						<ul>
							<li><a href="#">Template settings</a></li>
							<li><a href="#">Template settings</a></li>
							<li><a href="#">Template settings</a></li>
						</ul></li>
					<li><a href="#">Template settings</a>
						<ul>
							<li><a href="#">Template settings</a></li>
							<li><a href="#">Template settings</a></li>
							<li><a href="#">Template settings</a></li>
							<li><a href="#">Template settings</a></li>
							<li><a href="#">Template settings</a></li>
						</ul></li>
					<li><a href="#">Add page</a>
						<ul>
							<li><a href="#">Template settings</a></li>
							<li><a href="#">Template settings</a></li>
						</ul></li>
					<li><a href="#">Edit section</a>
						<ul>
							<li><a href="#">Template settings</a></li>
							<li><a href="#">Template settings</a></li>
							<li><a href="#">Template settings</a></li>
							<li><a href="#">Template settings</a></li>
							<li><a href="#">Template settings</a></li>
						</ul></li>
				</ul>
				<h2>Text Section</h2>
				<div class="sidebar_section_text">Lorem ipsum dolor sit amet,
					consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
					labore et dolore magna aliqua.</div>

			</div>
			<div class="clear"></div>
		</div>
		<!--end of center_content-->

		<div class="footer">
			Panelo - Free Admin Collect from <a href="http://www.mycodes.net/"
				title="ç½ç«æ¨¡æ¿" target="_blank">ç½ç«æ¨¡æ¿</a>
		</div>

	</div>


</body>
<script>
	function submit() {
		$("form").submit();
	}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Panelo - Free Admin Template</title>
<link rel="stylesheet" type="text/css" href="../css/style.css" />

	<!-- jQuery file -->
	<script src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/jquery.hoveraccordion.min.js"></script>
	
	
	<script src="${base}/js/public/validator-plugin.js" type="text/javascript"></script>
	
	
	
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example2').hoverAccordion({
				activateitem : '1',
				speed : 'fast'
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
			<ul>
				<li><a href="#" class="selected">settings</a></li>
				<li><a href="#">users</a></li>
				<li><a href="#">categories</a></li>
				<li><a href="#">edit section</a></li>
				<li><a href="#">templates</a></li>
			</ul>
		</div>
		<div class="center_content">

			<div id="right_wrap">

				<div id="right_content">
					<div id="tab1" class="tabcontent">
						<h3>渠道添加</h3>
						<!-- <div class="form"> -->
						
						<form action="${base}/channel/save" method="post">

							<div class="form_row">
								<label>渠道名称：</label> 
								<input type="text" class="form_input" name="channelName" validate-method="requiredString" validate-errorTips="请输入渠道名称" />
							</div>
							<div><span id="channelNameError" class="userdata_prompt"></span></div>

							<div class="form_row">
								<label>联&nbsp;&nbsp;系&nbsp;&nbsp;人：</label> 
								<input type="text" class="form_input" name="channelName" validate-method="requiredString" validate-errorTips="请输入渠道名称" />
							</div>
							<div><span id="contactsError" class="userdata_prompt"></span></div>

							<div class="form_row">
								<label>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话：</label> 
								<input type="text" class="form_input"  name="phone" validate-method="requiredMobile" validate-errorTips="请输入正确的手机号"   />
							</div>
							<div><span id="phoneError" class="userdata_prompt"></span></div>

							<!-- <div class="form_row">
								<label>Message:</label>
								<textarea class="form_textarea" name=""></textarea>
							</div> -->
							<div class="form_row">
								<input type="submit" class="form_submit" value="保存" id="submitButton" />
							</div>
							<div class="clear"></div>
							</form>
						<!-- </div> -->
					</div>
				</div>

			</div>
			<!-- end of right content-->
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
				title="网站模板" target="_blank">网站模板</a>
		</div>
	</div>
	
	<script type="text/javascript">
	function submit(){
		$("form").submit();
	}
	
	$().ready(function(){
		com.buge.validate({
			setting:{
				isAjaxSubmit : true,			//是否是ajax提交表单	
				okClass : 'ok',		//正确提示框样式
				errorClass : 'error', //错误提示框样式
				errorDisplayNode: function(element){//查找错误提示框（span节点）并返回	 注意：这边要以$(element)这个节点开始匹配
					return $(element).parent("div").next().find("span");
				},
				validateNode: 'form input',	//要验证的输入框
				submitButton: {											
					'selector' : '#submitButton',					//点击提交的按钮
					success : function() {							//点击提交的按钮,重新验证所有的输入框，成功后执行的回调函数
						//$("form").submit();
					}
				},		//那些要提交表单的进行验证在提交
																	//ajax提交表单配置参数
				ajax : {
					url:"${base}/channel/save?timestamp=<%=System.currentTimeMillis()%>",
					type:"post",
					data: function(config){
						return $("form").serialize();
					},//回调函数取表单数据
					success : function(msgType) {
						if(msgType==0) {
							yofangTip.openFirst("渠道保存成功", function(element){
								element.bind("click",function(){
									window.location.href="${base}/channel/index";	
								});
							});
						} else if(msgType==1) {
							$("#channelNameError").removeClass("ok").addClass("error").html("渠道名称不能为空");
						}else if(msgType==2) {
							$("#contactsError").removeClass("ok").addClass("error").html("联系人不能为空");
						}else if(msgType==3) {
							$("#phoneError").removeClass("ok").addClass("error").html("电话号码不能为空");
						}
					}
				}
			},
			//自定义验证规则
			validators : {
			}
		});
	}); 
		
	</script>
</body>
</html>
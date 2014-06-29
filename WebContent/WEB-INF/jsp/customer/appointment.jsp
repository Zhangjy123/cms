<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>添加客户</title>
<link href="${base}/css/style.css" rel="stylesheet" type="text/css">
<link href="${base}/css/easydialog.css" rel="stylesheet" type="text/css">
<link href="${base}/css/addpage.css" rel="stylesheet" type="text/css">
<link href="${base}/css/jquery.ui.theme.css" type="text/css" rel="stylesheet" />
<link href="${base}/css/jquery.ui.core.css" type="text/css" rel="stylesheet" />
<link href="${base}/css/jquery.ui.datepicker.css" type="text/css" rel="stylesheet" />
<script src="${base}/js/easydialog.min.js" type="text/javascript"></script>
<script src="${base}/js/public/validator-plugin.js" type="text/javascript"></script>
</head>
<body>
	<%-- 菜单栏 --%>
	<jsp:include page="../menu.jsp">
		<jsp:param value="customer" name="oneMenu"/>
	</jsp:include>
	<%-- 弹出层 --%>
	<jsp:include page="../public/yofangDialog.jsp" flush="true"></jsp:include>
  <!--主体-->
  <div class="subject">
    <!--我的客户-->
    <div class="subject_down">
      <div class="modpassdiv">
        <form>
        	   <input name="id" type="hidden" value="${obj.id}" />
	          <div class="userdata">
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>预约经纪人：</div>
		                <div class="userdata_cont">
		                  <input name="agentName" value="${obj.customer.agentName}" type="text" class="userdataname" validate-method="requiredString" validate-errorTips="请输入正确的姓名">
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>手机号：</div>
		                <div class="userdata_cont">
		                  <input name="agentMobile" value="${obj.customer.agentMobile}" type="text" class="userdataname" validate-method="requiredMobile" validate-errorTips="请输入正确的手机号">
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	          	<ul>
		          	 <li>
		                <div class="userdata_title">公司名称：</div>
		                <div class="userdata_cont">
		                	 <select name="channelId">
		                	 	<c:forEach var="channel" items="${obj.channels}">
									<option value="${channel.id}" ${obj.customer.channel.id==channel.id?'selected':''} >${channel.channelName}</option>		                	 	
		                	 	</c:forEach>
							</select>
		                </div>
		                <div class="userdata_prompt"><span></span></div>
			          </li>
		          </ul>
		          
		          
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>预约时间：</div>
		                <div class="userdata_cont">
		                  <input id="appointmentTime" name="appointmentTime" value="<fmt:formatDate value="${obj.customer.appointmentTime}" pattern="yyyy-MM-dd"/>" type="text" class="userdataname" readonly="readonly" >
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
				<div class="userdatasub"><a id="submitButton" href="javascript:void(0)">保存</a></div>	          	
	          </div>
	       </form>
      </div>
     </div>
    </div>
    <!-- 时间input框插件 -->
<script type="text/javascript" src="${base}/script/jquery.ui.core.js" charset="utf-8"></script>
		<script type="text/javascript" src="${base}/script/jquery.ui.datepicker.js" charset="utf-8"></script>
		<script type="text/javascript" src="${base}/script/jquery.ui.datepicker-zh-CN.js" charset="utf-8"></script>
		<script type="text/javascript">
		$(function() {
			var timedate = $("#appointmentTime").datepicker({
				defaultDate: 1,
				changeMonth: true,
				changeYear: true,
				numberOfMonths: 1,
			});
		});
	</script>
    <script type="text/javascript">
    	$().ready(function(){
    		com.buge.validate({
    			setting:{
    				isAjaxSubmit : true,			//是否是ajax提交表单	
    				okClass : 'ok',		//正确提示框样式
    				errorClass : 'error', //错误提示框样式
    				errorDisplayNode: function(element){//查找错误提示框（span节点）并返回	 注意：这边要以$(element)这个节点开始匹配
    					return $(element).parent("div").next().find("span");
    				},
    				validateNode: 'form input,form select',	//要验证的输入框
    				submitButton: {											
    					'selector' : '#submitButton',					//点击提交的按钮
    					success : function() {							//点击提交的按钮,重新验证所有的输入框，成功后执行的回调函数
    						//$("form").submit();
    					}
    				},		//那些要提交表单的进行验证在提交
    																	//ajax提交表单配置参数
    				ajax : {
    					url:"${base}/customer/saveappoint?timestamp=<%=System.currentTimeMillis()%>",
    					type:"post",
    					data: function(config){
    						return $("form").serialize();
    					},//回调函数取表单数据
    					success : function(msgType) {
    						if(msgType==0) {
    							yofangTip.openFirst("预约客户成功", function(element){
    							/* 	element.bind("click",function(){
    									window.location.href="${base}/user/index";	
    								}); */
    							});
    						} else if(msgType==1) {
    							$("#mobileError").removeClass("ok");
    							$("#mobileError").addClass("error");
    							$("#mobileError").html("预约失败");
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

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>修改客户</title>
<link href="${base}/css/style.css" rel="stylesheet" type="text/css">
<link href="${base}/css/easydialog.css" rel="stylesheet" type="text/css">
<link href="${base}/css/addpage.css" rel="stylesheet" type="text/css">
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
	          <div class="userdata">
	            <ul>
		             <li>
		             	<input name="customer.id" type="hidden" value="${obj.customer.id}"/>
		                <div class="userdata_title"><span class="coopformx">*</span>姓名：</div>
		                <div class="userdata_cont">
		                  <input name="customer.realName" value="${obj.customer.realName}" type="text" class="userdataname" validate-method="requiredString" validate-errorTips="请输入正确的姓名">
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>手机号：</div>
		                <div class="userdata_cont">
		                  <input name="customer.mobile" value="${obj.customer.mobile}" type="text" class="userdataname" validate-method="requiredMobile" validate-errorTips="请输入正确的手机号">
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>城市 ：</div>
		                <div class="userdata_cont">
		                	<select name="customer.city">
								<option>城市</option>
							</select>
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>城区 ：</div>
		                <div class="userdata_cont">
		                	<select name="customer.district">
								<option value="1">城区</option>
							</select>
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>商圈 ：</div>
		                <div class="userdata_cont">
		                	<select name="customer.hotArea">
								<option>商圈</option>
							</select>
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>客户类别：</div>
		                <div class="userdata_cont">
		                	<select name="customer.customerType">
		                		<option value="1" ${obj.customer.customerType==1?'selected':''}>个人</option>
		                		<option value="2" ${obj.customer.customerType==2?'selected':''}>公司</option>
		                	</select>
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>客户来源：</div>
		                <div class="userdata_cont" style="width: 500px">
		                	<select name="customer.fromWhere">
		                		<option value="1" ${obj.customer.fromWhere==1?'selected':''}>直客</option>
		                		<option value="2" ${obj.customer.fromWhere==2?'selected':''}>渠道客户</option>
		                		<option value="3" ${obj.customer.fromWhere==3?'selected':''}>公司内部</option>
		                		<option value="4" ${obj.customer.fromWhere==4?'selected':''}>客户推荐</option>
		                	</select>
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title">推荐人：</div>
		                <div class="userdata_cont" style="width: 500px">
		                	<input name="customer.referee" value="${obj.customer.referee}" type="text" value="" class="userdataname" />
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>项目：</div>
		                <div class="userdata_cont">
		                	 <select name="customer.projectId">
		                	 	<c:forEach var="project" items="${obj.projects}">
									<option value="${project.id}" ${obj.customer.project.id==project.id?'selected':''} >${project.name}</option>		                	 	
		                	 	</c:forEach>
							</select>
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>需求：</div>
		                <div class="userdata_cont">
		                	<input name="customer.requirement" value="${obj.customer.requirement}" type="text" class="userdataname" validate-method="requiredString" validate-errorTips="请输入用户需求">
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	       <%--    	
	            <ul>
		             <li>
		                <div class="userdata_title">预约人：</div>
		                <div class="userdata_cont">
		                	<input name="customer.agentName" type="text" class="userdataname">
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
		              <li>
		                <div class="userdata_title">公司名称：</div>
		                <div class="userdata_cont">
		                	 <select name="customer.projectId">
		                	 	<c:forEach var="channel" items="${obj.channels}">
									<option value="${channel.id}">${channel.channelName}</option>		                	 	
		                	 	</c:forEach>
							</select>
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	          	<ul>
		             <li>
		                <div class="userdata_title">预约时间：</div>
		                <div class="userdata_cont">
		                	<input name="customer.appointmentTime" type="text" class="userdataname">
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	</div> --%>
				<div class="userdatasub"><a id="submitButton" href="javascript:void(0)">保存</a></div>	          	
	          </div>
	       </form>
      </div>
     </div>
    </div>
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
    					url:"${base}/customer/ubase?timestamp=<%=System.currentTimeMillis()%>",
    					type:"post",
    					data: function(config){
    						return $("form").serialize();
    					},//回调函数取表单数据
    					success : function(msgType) {
    						if(msgType==0) {
    							yofangTip.openFirst("修改客户成功", function(element){
    							/* 	element.bind("click",function(){
    									window.location.href="${base}/user/index";	
    								}); */
    							});
    						} else if(msgType==1) {
    							$("#mobileError").removeClass("ok");
    							$("#mobileError").addClass("error");
    							$("#mobileError").html("修改失败");
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

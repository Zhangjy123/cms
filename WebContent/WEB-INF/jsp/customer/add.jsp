<%@page import="cn.yofang.dao.util.CommonUtil"%>
<%@page import="cn.yofang.dao.model.mongoimpl.CityImpl"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>添加客户</title>
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
		                <div class="userdata_title"><span class="coopformx">*</span>姓名：</div>
		                <div class="userdata_cont">
		                  <input name="customer.realName" type="text" class="userdataname" validate-method="requiredString" validate-errorTips="请输入正确的姓名">
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li style="width: 1000px">
		                <div class="userdata_title"><span class="coopformx">*</span>手机号：</div>
		                <div class="userdata_cont">
		                  <input name="customer.mobile" type="text" class="userdataname" validate-method="requiredRegex" validate-regex="(^\d{11}$)|(^\d{7}\*{4}$)" validate-errorTips="格式：1361111****或13611112222" >
		                </div>
		                <div class="userdata_prompt"><span  class="" style="width: 500px"></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>城市 ：</div>
		                <div class="userdata_cont">
		                	<%
			                	Map data = (Map)request.getAttribute("obj");
			                	List<CityImpl> citys =  (List<CityImpl> )data.get("citys");
			                %>
			                	<select id="city" name="customer.city">
			                		<option value="" disabled="disabled" selected="selected">请选择城市</option>
			                		<%
						                for(int i=0; i< citys.size(); i++) {
					                		if(!CommonUtil.isChar(citys.get(i).getName())) {
					                			%><option value="<%=citys.get(i).getName()%>"><%=citys.get(i).getName()%></option><%
					                		}
					                	}
				                	%>
			                		
			                	</select>
			              
		                	
		                <%-- 	
		                		
							 --%>
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>城区 ：</div>
		                <div class="userdata_cont">
		                	<select id="district" name="customer.district">
							</select>
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title"><span class="coopformx">*</span>商圈 ：</div>
		                <div class="userdata_cont">
		                	<select id="hotArea" name="customer.hotArea">
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
		                		<option value="1">个人</option>
		                		<option value="2">公司</option>
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
		                		<option value="1">直客</option>
		                		<option value="2">渠道客户</option>
		                		<option value="3">公司内部</option>
		                		<option value="4">客户推荐</option>
		                	</select>
		                </div>
		                <div class="userdata_prompt"><span></span></div>
		              </li>
	          	</ul>
	          	
	            <ul>
		             <li>
		                <div class="userdata_title">推荐人：</div>
		                <div class="userdata_cont" style="width: 500px">
		                	<input name="customer.referee" type="text" value="" class="userdataname" />
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
									<option value="${project.id}">${project.name}</option>		                	 	
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
		                	<input name="customer.requirement" type="text" class="userdataname" validate-method="requiredString" validate-errorTips="请输入用户需求">
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
    					url:"${base}/customer/save?timestamp=<%=System.currentTimeMillis()%>",
    					type:"post",
    					data: function(config){
    						return $("form").serialize();
    					},//回调函数取表单数据
    					success : function(msgType) {
    						if(msgType==0) {
    							yofangTip.openFirst("保存客户成功", function(element){
    							/* 	element.bind("click",function(){
    									window.location.href="${base}/user/index";	
    								}); */
    							});
    						} else if(msgType==1) {
    							$("#mobileError").removeClass("ok");
    							$("#mobileError").addClass("error");
    							$("#mobileError").html("保存失败");
    						}
    					}
    				}
    			},
    			//自定义验证规则
    			validators : {
    			}
    		});
    		
    		
	    	$("#city").change(function(){
	    		$.post(
	    			"/customer/changecity",
	    			{"city":$("#city").val()},
	    			function(data){
	    				$("#district option").remove();
	    				$("#hotArea option").remove();
	    				$.each(data.districtLists,function(k,v){
	    					var option = $("<option></option>");
	    					option.val(v);
	    					option.text(v);
	    					$("#district").append(option);
	    				});
	    				$.each(data.hotAreaLists,function(k,v){
	    					var option = $("<option></option>");
	    					option.val(v);
	    					option.text(v);
	    					$("#hotArea").append(option);
	    				});
	    			}
	    		);
	    	});
	    	$("#district").change(function(){
	    		$.post(
	    			"/customer/changedistrict",
	    			{"city":$("#city").val(),"district":$("#district").val()},
	    			function(data){
	    				$("#hotArea option").remove();//.not($("#hotArea option:selected")).remove();
	    				eval("var hotAreaList ="+ data);
	    				$.each(hotAreaList,function(k,v){
	    						var option = $("<option></option>");
	    						option.val(v);
	    						option.text(v);
	    						$("#hotArea").append(option);
	    				});
	    			}
	    		);
	    	});	
    		
    		
    		
    	});
    </script>
</body>
</html>

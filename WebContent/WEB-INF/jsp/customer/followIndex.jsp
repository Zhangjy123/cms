<%@page import="com.yofang.cms.manage.ManagerService"%>
<%@page import="com.yofang.cms.model.sysmanage.User"%>
<%@page import="java.util.Map"%>
<%@page import="com.yofang.cms.model.customermanage.Customer"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="${base}/css/style.css" rel="stylesheet" type="text/css">
<link href="${base}/css/easydialog.css" rel="stylesheet" type="text/css">
<script src="${base}/js/easydialog.min.js" type="text/javascript"></script>
<script src="${base}/js/public/validator-plugin.js" type="text/javascript"></script>
<title>客户跟进</title>
</head>

<body>
<%-- 菜单栏 --%>
	<jsp:include page="../menu.jsp">
		<jsp:param value="customer" name="oneMenu"/>
	</jsp:include>
<!--内容-->
<div class="cont">
  <c:if test="${(obj.customer.state!=2 and obj.customer.state!=3) or loginUser.role.name=='系统管理员'}">
	  <div class="adduser add"><a href="javascript:;">+添加跟进记录</a></div>
  </c:if>
  <c:if test="${obj.customer.state==12}">
	  <div class="adduser" style="width: 0px"><a id="depositConfirm" href="javascript:;">已付定金</a></div>
  </c:if>
  <div class="list cle">
  	<h3 style="padding-left:none;color: red;">跟进记录：</h3>
  	<input type="hidden" id="customerId" value="${obj.customer.id}">
    <table width="100%" border="2" cellpadding="0" cellspacing="0">
		<tr style="font-size: 14;">
			<td>序号</td>
			<td>看房客户</td>
			<%--<td>客户手机</td>--%>
			<td>跟进人</td>
			<td>身份</td>
			<td>跟进记录</td>
		</tr>
		<c:forEach items="${obj.customer.customerFollows}" var="customerFollow" varStatus="status">
			<tr ${status.index%2==1 ? "style='color: #666'" : "style='background-color: #F1F1F1;color: #666'" } >
				<td>${status.index+1}</td>
				<td>${obj.customer.realName}</td>
				<%-- <td>${obj.customer.mobile}</td> --%>
				<td>${customerFollow.recorderName}</td>
				<td>${customerFollow.roleName}</td>
				<td>${customerFollow.content}</td>
			</tr>
		</c:forEach>
	</table>
  </div>
</div>

<!--审批内容-->
<div class="cont">
  <div class="list cle">
  	<h3 style="padding-left:none;color: red;">审批记录：</h3>
  	<input type="hidden" id="customerId" value="${obj.customer.id}">
    <table width="100%" border="2" cellpadding="0" cellspacing="0">
		<tr style="font-size: 14;">
			<td>序号</td>
			<td>操作人</td>
			<td>职位</td>
			<td>审批状态</td>
			<td>备注</td>
			<td>操作时间</td>
		</tr>
		<c:forEach var="approve" items="${obj.customer.approves}">
			<tr style="font-size: 14;">
				<td>${status.index+1}</td>
				<td>${approve.approveName}</td>
				<td>${approve.roleName}</td>
				<td>${approve.isPass==1?'通过':''}
					${approve.isPass==2?'不通过':''}
					${approve.isPass==3?'撞单':''}
				</td>
				<td>${approve.approveRemark}</td>
				<td><fmt:formatDate value="${approve.approveTime}" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>
		
	</table>
  </div>
   <% 	
   		Map map = (Map)request.getAttribute("obj");	
   		//获取审批状态
   		Customer customer = (Customer)map.get("customer");
   		//根据审批状态获取审批按钮提示语
   		String ast = Customer.getApproveName(customer.getApproveState());
   		User user =  ManagerService.getUser(request);
   		//如果该节点不是该角色审批的，隐藏
   		if(!user.getRole().getName().equals(Customer.getApproveRole(customer.getApproveState()))){
   			ast = null;
   		}
		//判断该角色是否可以审批该节点
		
   %>
   <%--只有经理级别以上的人才能审批 --%>
   <c:if test="${loginUser.role.name!='销售' and loginUser.role.name!='渠道销售'}">
	  <div class="adduser add">
	  	<%
	  		if(ast!=null) {
	  	%>
			  	<a id="approveA" href="javascript:;"><%=ast%></a>
	  		<%}%>	
	  		
	  </div>
	</c:if>
</div>
<!--添加跟进弹出层-->
<div id="imgBox" style="display:none;" class="imgBox cle">
  <div class="imgBox_b">
    <div class="imgBox_b_l">跟进</div>
    <div class="imgBox_b_r">
      <button id="colsebutton"></button>
    </div>
  </div>
  <div class="imgBox_cont cle">
    <form  id="submitButtonForm" action="${base}/customer/savefollow" method="post">
      <input type="hidden" name="customerId" value="${obj.customer.id}">
      <div class="select_cont cle">
        <div class="name_ss">跟进内容：
          <input id="addContent" name="content" type="text" validate-method="requiredString" validate-errorTips="请输入内容">
        </div>
      </div>
      <div class="name_ss"> <a id="submitButton" href="javascript:;" class="cun">保存</a></div>
    </form>
  </div>
</div>


<!--审批弹出层-->
<div id="imgBox1" style="display:none;" class="imgBox cle">
  <div class="imgBox_b">
    <div class="imgBox_b_l">审批</div>
    <div class="imgBox_b_r">
      <button id="colsebutton"></button>
    </div>
  </div>
  <div class="imgBox_cont cle">
     <form id="approveForm" action="${base}/approve/save" method="post">
	     <input type="hidden" name="customerId" value="${obj.customer.id}">
	      <div class="select_cont cle">
	        <div class="name_ss">是否通过：
	         	通过：<input name="isPass" type="radio" value="1" style="width: 20px;height: 10px;" checked >
	         	不通过：<input name="isPass" type="radio" value="2" style="width: 20px;height: 10px;" >
	         	撞单：<input name="isPass" type="radio" value="3" style="width: 20px;height: 10px;" >&nbsp;&nbsp;&nbsp;&nbsp;
	        </div>
	        <div class="name_ss">备注：
	          <input id="addApproveRemark" name="approveRemark" type="text" validate-method="requiredString" validate-errorTips="请输入内容">
	        </div>
	        <div class="userdata_prompt"><span></span></div>
	      </div>
	      <div class="name_ss"> <a id="approveSubmit" href="javascript:;" class="cun">保存</a></div>
    </form>
  </div>
</div>
<%-- 弹出层 --%>
<jsp:include page="../public/yofangDialog.jsp" flush="true"></jsp:include>
<script type="text/javascript">
$(document).ready(function() {
	$(".add a").click(function(){
		var id = $(this).attr("lang");
		dialogSomeThing(id,"#imgBox");
	})
	
	$("#approveA").click(function(){
		var id = $(this).attr("lang");
		dialogSomeThing1(id,"#imgBox1");
	})
	
	$("#depositConfirm").unbind();
	$("#depositConfirm").bind("click",function(){
		yofangTip.openSecond("客户已付定金，提交给经理审批",function(element){
			$(element).click(function(){
				window.location.href="${base}/approve/sdeposit?customerId="+$("#customerId").val();
			});
		});
	});
})
function dialogSomeThing(id,div){
	var div = $(div);
	$(div).text(id);
	var e= $(div).attr("id");
	easyDialog.open({
		container :e,
		fixed : false
	});
	var button = $(div).find("#colsebutton");
	$(button).unbind();
	$(button).bind('click',function(){
		easyDialog.close();
	});
	
	$().ready(function(){
		com.buge.validate({
			setting:{
				isAjaxSubmit : false,			//是否是ajax提交表单	
				okClass : 'ok',		//正确提示框样式
				errorClass : 'error', //错误提示框样式
				errorDisplayNode: function(element){//查找错误提示框（span节点）并返回	 注意：这边要以$(element)这个节点开始匹配
					return $(element).parent("div").next().find("span");
				},
				validateNode: '#addContent',	//要验证的输入框
				submitButton: {											
					'selector' : '#submitButtonForm',					//点击提交的按钮
					success : function() {						//点击提交的按钮,重新验证所有的输入框，成功后执行的回调函数
						$("#submitButtonForm").submit();
					}
				} 												
			},
		});
	});
}


function dialogSomeThing1(id,div){
	var div = $(div);
	$(div).text(id);
	var e= $(div).attr("id");
	easyDialog.open({
		container :e,
		fixed : false
	});
	var button = $(div).find("#colsebutton");
	$(button).unbind();
	$(button).bind('click',function(){
		easyDialog.close();
	});
	
	$().ready(function(){
		com.buge.validate({
			setting:{
				isAjaxSubmit : false,			//是否是ajax提交表单	
				okClass : 'ok',		//正确提示框样式
				errorClass : 'error', //错误提示框样式
				errorDisplayNode: function(element){//查找错误提示框（span节点）并返回	 注意：这边要以$(element)这个节点开始匹配
					return $(element).parent("div").next().find("span");
				},
				validateNode: '#addApproveRemark',	//要验证的输入框
				submitButton: {											
					'selector' : '#approveSubmit',					//点击提交的按钮
					success : function() {						//点击提交的按钮,重新验证所有的输入框，成功后执行的回调函数
						$("#approveForm").submit();
					}
				} 												
			},
		});
	});
}
</script>
</body>
</html>
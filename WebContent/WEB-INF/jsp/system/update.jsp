<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>修改用户信息</title>
<link href="${base}/css/style.css" rel="stylesheet" type="text/css">
<link href="${base}/css/easydialog.css" rel="stylesheet" type="text/css">
<link href="${base}/css/addpage.css" rel="stylesheet" type="text/css">
<script src="${base}/js/easydialog.min.js" type="text/javascript"></script>
<script src="${base}/js/public/validator-plugin.js" type="text/javascript"></script>
</head>
<body>
	<%-- 菜单栏 --%>
	<jsp:include page="../menu.jsp">
		<jsp:param value="user" name="oneMenu"/>
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
             	<input type="hidden" name="user.id" value="${obj.user.id}">
             	<input type="hidden" name="user.createTime" value="<fmt:formatDate value='${obj.user.createTime}' pattern='yyyy-MM-dd hh:mm:ss'/>">
                <div class="userdata_title"><span class="coopformx">*</span>姓名：</div>
                <div class="userdata_cont">
                  <input name="user.realName" value="${obj.user.realName}" type="text" class="userdataname" validate-method="requiredString" validate-errorTips="请输入正确的姓名">
                </div>
                <div class="userdata_prompt"><span></span></div>
              </li>
             <li>
                <div class="userdata_title"><span class="coopformx">*</span>手机号：</div>
                <div class="userdata_cont">
                  <input name="user.mobile" value="${obj.user.mobile}" type="text" class="userdataname" validate-method="requiredMobile" validate-errorTips="请输入正确的手机号" >
                </div>
                <div class="userdata_prompt"><span id="mobileError" ></span></div>
              </li>
             <li>
                <div class="userdata_title"><span class="coopformx">*</span>密码：</div>
                <div class="userdata_cont">
                  <input name="user.password"  value="${obj.user.password}" type="text" class="userdataname" />
                </div>
                <div class="userdata_prompt"><span></span></div>
              </li>
              <li>
                <div class="userdata_title"><span class="coopformx">*</span>角色：</div>
                <div class="userdata_cont">
                  <select name="user.roleId" validate-method="requiredSelect" validate-errorTips="至少选择一个角色">
                    	<option disabled="disabled" ${(empty obj.user.roleId)?'selected':''} value="" >请选择一个角色</option>
                    	<c:forEach var="role" items="${obj.allRoleList}">
		                    <option value="${role.id}"  ${obj.user.roleId==role.id?'selected':''}>${role.name}</option>
                    	</c:forEach>
                  </select>
                </div>
                <div class="userdata_prompt"><span></span></div>
              </li>
              <li>
                <div class="userdata_title"><span class="coopformx">*</span>所属公司：</div>
                <div class="userdata_cont">
                  <select name="user.channelId" validate-method="requiredSelect" validate-errorTips="至少选择一个公司">
                    <option disabled="disabled" ${(empty obj.user.channelId)?'selected':''} value="" >请选择一个公司</option>
                    <c:forEach var="channel" items="${obj.allChannelList}">
		                    <option value="${channel.id}" ${obj.user.channelId==channel.id ? 'selected':''} >${channel.channelName}</option>
                    </c:forEach>
                  </select>
                </div>
                <div class="userdata_prompt"><span></span></div>
              </li>
            </ul>
            <div class="userdatasub"><a id="submitButton" href="javascript:void(0)">修改</a></div>
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
    					url:"${base}/user/update?timestamp=<%=System.currentTimeMillis()%>",
    					type:"post",
    					data: function(config){
    						return $("form").serialize();
    					},//回调函数取表单数据
    					success : function(msgType) {
    						if(msgType==0) {
    							yofangTip.openFirst("修改用户成功", function(element){
    								element.bind("click",function(){
    									window.location.href="${base}/user/index";	
    								});
    							});
    						} else if(msgType==1) {
    							$("#mobileError").removeClass("ok");
    							$("#mobileError").addClass("error");
    							$("#mobileError").html("该手机号码已经存在");
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

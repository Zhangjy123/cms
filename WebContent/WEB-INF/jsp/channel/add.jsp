<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>添加渠道</title>
<link href="${base}/css/style.css" rel="stylesheet" type="text/css">
<link href="${base}/css/easydialog.css" rel="stylesheet" type="text/css">
<link href="${base}/css/addpage.css" rel="stylesheet" type="text/css">
<script src="${base}/js/easydialog.min.js" type="text/javascript"></script>
<script src="${base}/js/public/validator-plugin.js" type="text/javascript"></script>
</head>
<body>
	<%-- 菜单栏 --%>
	<jsp:include page="../menu.jsp">
		<jsp:param value="channel" name="oneMenu"/>
	</jsp:include>
	<%-- 弹出层 --%>
	<jsp:include page="../public/yofangDialog.jsp" flush="true"></jsp:include>
  <!--主体-->
  <div class="subject">
    <!--我的客户-->
    <div class="subject_down">
      <div class="modpassdiv">
        <form action="${base}/channel/save" method="post">
          <div class="userdata">
            <ul>
             <li>
                <div class="name_ss"><span class="coopformx">*</span>渠道名称： <input name="channelName" type="text" class="userdatatext" validate-method="requiredString" validate-errorTips="请输入渠道名称"  /></div>
                <div><span id="channelNameError" class="userdata_prompt"></span></div>
             </li>
             <li>
                <div class="name_ss"><span class="coopformx">*</span>联&nbsp;系&nbsp;人： <input name="contacts" type="text" validate-method="requiredString" validate-errorTips="请输入联系人" /></div>
	             <div><span id="contactsError" class="userdata_prompt"></span></div>
             </li>
             <li>
               <div class="name_ss"><span class="coopformx">*</span>电&nbsp;&nbsp;&nbsp;&nbsp;话： <input name="phone" type="text" validate-method="requiredMobile" validate-errorTips="请输入正确的手机号"  >
			   </div>
			   <div><span id="phoneError" class="userdata_prompt"></span></div>
             </li>
            </ul>
            <div class="userdatasub"><a href="javascript:void(0)" id="submitButton">保存</a></div>
          </div>
        </form>
      </div>
     </div>
    </div>
</body>
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
</html>

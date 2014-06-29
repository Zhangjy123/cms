<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>添加项目</title>
<link href="${base}/css/style.css" rel="stylesheet" type="text/css">
<link href="${base}/css/easydialog.css" rel="stylesheet" type="text/css">
<link href="${base}/css/addpage.css" rel="stylesheet" type="text/css">
<script src="${base}/js/easydialog.min.js" type="text/javascript"></script>
<script src="${base}/js/public/validator-plugin.js" type="text/javascript"></script>
</head>
<body>
	<%-- 菜单栏 --%>
	<jsp:include page="../menu.jsp">
		<jsp:param value="project" name="oneMenu"/>
	</jsp:include>
	<%-- 弹出层 --%>
	<jsp:include page="../public/yofangDialog.jsp" flush="true"></jsp:include>
  <!--主体-->
  <div class="subject">
    <!--我的客户-->
    <div class="subject_down">
      <div class="modpassdiv">
        <form action="${base}/project/save" method="post">
          <div class="userdata">
            <ul>
             <li>
                <div class="name_ss"><span class="coopformx">*</span>项目名称： <input name="name" type="text" class="userdatatext"  validate-method="requiredString" validate-errorTips="请输入项目名称" /></div>
                <div class="userdata_prompt"><span id="nameError"></span></div>
              </li>
             <li>
                <div class="name_ss"><span class="coopformx">*</span>项目类别： <select name="catagory" validate-method="requiredSelect" validate-errorTips="请选择项目类别">
						<option value="">-请选择-</option>
						<option value="1">二手房</option>
						<option value="2">出租房</option>
						<option value="3">求购</option>
						<option value="4">求租</option>
						<option value="5">商铺</option>
						<option value="6">写字楼</option>
					</select></div>
					<div><span id="catagoryError" class="userdata_prompt"></span></div>
              </li>
             <li>
               <div class="name_ss"><span class="coopformx">*</span>项目地址： <input type="text" style="width: 400px" name="address"  validate-method="requiredString" validate-errorTips="请输入项目地址" />
			   </div>
			   <div><span id="addressError" class="userdata_prompt"></span></div>
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
				validateNode: 'form input,form select', //要验证的输入框
				submitButton: {											
					'selector' : '#submitButton',					//点击提交的按钮
					success : function() {							//点击提交的按钮,重新验证所有的输入框，成功后执行的回调函数
						//$("form").submit();
					}
				},		//那些要提交表单的进行验证在提交
																	//ajax提交表单配置参数
				ajax : {
					url:"${base}/project/save?timestamp=<%=System.currentTimeMillis()%>",
					type:"post",
					data: function(config){
						return $("form").serialize();
					},//回调函数取表单数据
					success : function(msgType) {
						if(msgType==0) {
							yofangTip.openFirst("项目保存成功", function(element){
								element.bind("click",function(){
									window.location.href="${base}/project/index";	
								});
							});
						} else if(msgType==1) {
							$("#nameError").removeClass("ok").addClass("error").html("项目名称不能为空");
						}else if(msgType==2) {
							$("#catagoryError").removeClass("ok").addClass("error").html("请选择项目类型");
						}else if(msgType==3) {
							$("#addressError").removeClass("ok").addClass("error").html("地址不能为空");
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
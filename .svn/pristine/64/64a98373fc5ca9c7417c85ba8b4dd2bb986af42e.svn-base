<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="${base}/css/style.css" rel="stylesheet" type="text/css">
<script src="${base}/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<title>渠道管理</title>
</head>

<body>
<jsp:include page="../menu.jsp">
	<jsp:param value="channel" name="oneMenu"/>
</jsp:include>
<!--内容-->
<div class="cont">
	<form action="${base}/channel/save" method="post">
		<input name="id" type="hidden" value="${obj.id }">
		<div class="select cle">
		  <div class="name_ss">渠道名称：
		    <input name="channelName" type="text" style="width:300px" value="${obj.channelName }">
		  </div>
		  <div class="name_ss">联系人：
		     <input name="contacts" type="text" value="${obj.contacts }">
		  </div>
		  <div class="name_ss">电话：
		    <input name="phone" type="text" value="${obj.phone }">
		  </div> <div class="name_ss">
		  <a href="javascript:void(0);" onclick="javascript:submit();" class="cun">保存</a></div>
		</div>
	</form>
</div>
</body>
<script>
	function submit(){
		$("form").submit();	
	}
</script>
</html>

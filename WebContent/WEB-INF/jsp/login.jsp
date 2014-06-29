<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Panelo - Free Admin Template</title>
	<link rel="stylesheet" type="text/css" href="${base}/css/style.css" />
<!-- 	<link href='http://fonts.googleapis.com/css?family=Belgrano' rel='stylesheet' type='text/css'> -->
</head>
<body>
	<div id="loginpanelwrap">
		<div class="loginheader">
	    	<div class="logintitle"><span><img src="${base}/images/yfhtsy_07.jpg"/></span><a href="#">有房网后台管理系统</a></div>
	    </div>
	    <div class="loginform">
	        <form action="${base}/back/doLogin" method="post">
	        	<input type="hidden" name="url" value="${obj.url}"/>
		        <div class="loginform_row">
		        <label>Username:</label>
		        <input type="text" class="loginform_input" name="mobile" value="${obj.cookieMobile}" />
		        </div>
		        <div class="loginform_row">
		        <label>Password:</label>
		        <input type="password" class="loginform_input" name="password" />
		        </div>
		        <div class="loginform_row">
		        <input type="submit" class="loginform_submit" value="Login" onclick="javascript:$('form').submit()" />
		        </div>
		        <span>${obj.errorMsg}</span><a href="javascript:;" class="wjpass">忘记密码?</a> 
		        <div class="clear"></div>
	        </form>
	    </div>
	</div>
</body>
</html>
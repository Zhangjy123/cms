<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>有房网客户登录</title>
<style type="text/css">
* { margin:0; padding:0; border:0px none #FFFFFF;}
img{border:0;}
li{list-style:none;}
a { text-decoration:none; cursor: pointer;cursor: hand;}
button{ cursor: pointer;cursor: hand;}
body{background-color:#c6c6c6;}
body a{outline:none;blr:expression(this.onFocus=this.blur());}
.main{ width:100%; height:auto;}
.login{ width:432px; height:338px; position:absolute; left:50%; top:50%; margin-top:-169px; margin-left:-216px;}
.loingtop{ width:431px; height:49px; margin-left:1px;}
.loingnei{ width:381px; height:272px; background-image:url(../images/khlogin_06.jpg); background-repeat:repeat-y; padding-left:50px;}
.loingdown{ width:431px; height:15px; margin-left:-1px;}
.loingnei ul{ padding-top:31px; float:left;}
.loingnei ul li{ padding-bottom:16px;line-height:50px;}
.loingnei ul li input{ font-size:16px; color:#999;}
.loingnei div{ width:334px; height:57px; background-image:url(../images/khlogin_14.jpg);background-repeat:no-repeat; float:left; margin-top:5px;}
.loingnei div a{ width:334px; height:57px; display:block; background-image:url(../images/login_15.jpg); background-repeat:no-repeat; background-position:center;}
.loingnei div a:hover{ background-image:url(../images/login_16.jpg);}
.loingnei div a:active{background-image:url(../images/login_17.jpg);}
.loingnei span{ color:#F00; font-size:12px; float:left; padding-top:11px; width:250px;}
.logintext{ width:274px; height:50px; background-image:url(../images/khlogin_09.jpg); background-repeat:no-repeat; padding-left:60px;}
.loginpass{width:274px; height:50px; background-image:url(../images/khlogin_12.jpg); background-repeat:no-repeat; padding-left:60px;}
.wjpass{ color:#a9a9a9; font-size:12px; width:100px; display:block; float:right; margin-top:10px;}
.wjpass:hover{ color:#F00; text-decoration:underline;}
</style>
	<script type="text/javascript" src="${base}/js/jquery-1.8.3.min.js">
		
	</script>
</head>
<body>
<div class="main">
<div class="login">
<div class="loingtop"><img src="../images/khlogin_03.jpg"></div>
<div class="loingnei">
<form action="${base}/back/doLogin" method="post">
<ul>
<li><input type="text" name="mobile" class="logintext"></li>
<li><input type="password" name="password" class="loginpass"></li>
</ul>
<div><a href="javascript:;" onclick="javascript:$('form').submit()" ></a></div>
</form>
<span>${obj.errorMsg}</span><a href="javascript:;" class="wjpass">忘记密码?</a>
</div>
<div class="loingdown"><img src="../images/khlogin_17.jpg" ></div>
</div>
</div>
</body>
</html>

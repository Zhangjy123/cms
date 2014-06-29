<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link href="${base }/css/style.css" rel="stylesheet" type="text/css">
<script src="${base }/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<title>项目管理</title>
</head>

<body>
<jsp:include page="../menu.jsp">
	<jsp:param value="project" name="oneMenu"/>
</jsp:include>
<!--åå®¹-->
<div class="cont">
<form action="/project/save" method="post">
	<input type="hidden" name="id" value="${obj.id }"/>
	<div class="select cle">
	  <div class="name_ss">项目名称
	    <input type="text" name ="name" value="${obj.name }">
	  </div>
	  <div class="name_ss">项目类型
	    <select name="catagory">
	      <option ${obj.catagory==1 ? 'selected=selected' : ''} value="1">二手房</option>
	      <option ${obj.catagory==2 ? 'selected=selected' : ''} value="2">出租房</option>
	      <option ${obj.catagory==3 ? 'selected=selected' : ''} value="3">求购</option>
	      <option ${obj.catagory==4 ? 'selected=selected' : ''} value="4">求租</option>
	      <option ${obj.catagory==5 ? 'selected=selected' : ''} value="5">商铺</option>
	      <option ${obj.catagory==6 ? 'selected=selected' : ''} value="6">写字楼</option>
	    </select>
	  </div>
	  <div class="name_ss">项目地址
	    <input type="text" name="address" value="${obj.address }" style="width:400px">
	  </div>
	  <div class="name_ss"> <a href="javascript:;" onclick="submit();" class="cun">保存</a></div>
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

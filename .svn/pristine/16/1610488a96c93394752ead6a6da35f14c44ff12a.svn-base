<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>角色管理</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<link href="../css/easydialog.css" rel="stylesheet" type="text/css">
<script src="../js/easydialog.min.js" type="text/javascript"></script>
	<%-- ztree --%>
	<link rel="stylesheet" href="${base}/css/ztree/css/demo.css" type="text/css">
	<link rel="stylesheet" href="${base}/css/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${base}/js/ztree/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="${base}/js/ztree/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript" src="${base}/js/ztree/jquery.ztree.excheck-3.5.js"></script>

</head>
<body>
	<jsp:include page="../menu.jsp">
		<jsp:param value="user" name="oneMenu"/>
	</jsp:include>
	<%-- 弹出层 --%>
	<jsp:include page="../public/yofangDialog.jsp" flush="true"></jsp:include>
		<div class="list cle">
			<table width="100%" border="1" cellpadding="0" cellspacing="0"  bordercolor="#000000">
				<tr style="font-size:14;">
				  <td>序号</td>
				  <td>角色名称</td>
				  <td>角色描述</td>
				  <td width="100">操作</td>
				</tr>
				<c:forEach var="role" items="${obj}" varStatus="status">
					<tr style="color:#666;">
					  <td>${status.index+1}</td>
					  <td>${role.name}</td>
					  <td>${role.description}</td>
					  <td>
					  	  <a href="javascript:void(0)" class="table_a">角色设置</a>
					  </td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<!--弹出层-->
	   <div id="imgBox" style="display: none;" class="imgBox cle">
		<div class="imgBox_b">
			<div class="imgBox_b_l">角色管理</div>
			<div class="imgBox_b_r">
				<button id="colsebutton"></button>
			</div>
		</div>
		<!--基本信息-->
		<div class="imgBox_cont cle">
			<form>
				<div class="select_cont cle">
					<div class="name_ss">
						<!-- <ul id="roleTree" class="ztree"></ul> -->
					</div>
				</div>
				<div class="name_ss">
					<a href="javascript:;" class="cun">保存</a>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".table_a").click(function(){
				var id = $(this).attr("lang");
				dialogSomeThing(id);
				//加载权限树
				var setting = {
						check: {
							enable: true,
							chkboxType : {
								 "Y":'ps',
								 "N":'ps'
							}
						},
						data: {
							simpleData: {
								enable: true
							}
						}
				};
				
				var zNodes =[
				 			{ id:1, pId:0, name:"随意勾选 1", open:true},
				 			{ id:11, pId:1, name:"随意勾选 1-1", open:true},
				 			{ id:111, pId:11, name:"随意勾选 1-1-1"},
				 			{ id:112, pId:11, name:"随意勾选 1-1-2"},
				 			{ id:12, pId:1, name:"随意勾选 1-2", open:true},
				 			{ id:121, pId:12, name:"随意勾选 1-2-1"},
				 			{ id:122, pId:12, name:"随意勾选 1-2-2"},
				 			{ id:2, pId:0, name:"随意勾选 2", checked:true, open:true},
				 			{ id:21, pId:2, name:"随意勾选 2-1"},
				 			{ id:22, pId:2, name:"随意勾选 2-2", open:true},
				 			{ id:221, pId:22, name:"随意勾选 2-2-1", checked:true},
				 			{ id:222, pId:22, name:"随意勾选 2-2-2"},
				 			{ id:23, pId:2, name:"随意勾选 2-3"}
				 ];
				
				var zTree = $.fn.zTree.init($("#roleTree"), setting, zNodes);
			})
		})
		function dialogSomeThing(id){
			var div = $("#imgBox");
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
		}
	</script>

</body>
</html>

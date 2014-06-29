<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${base }/js/public/callback.js"></script>
<link href="${base }/css/public/tanchuceng.css" rel="stylesheet" type="text/css">
<div id="popDiv" class="mydiv" style="display:none;">
<div class="mydivtitle">提示信息</div>
  <div class="mydivcont">我也不知道写什么好</div>
  <div class="mydivbutton">
  	<a id="popClose" href="javascript:closeDiv()">关闭</a>
  </div>
</div>
<div id="popDiv1" class="mydiv" style="display:none;">
<div class="mydivtitle">提示信息</div>
  <div class="mydivcont">我也不知道写什么好</div>
  <div class="mydivbutton1">
  	<a href="javascript:;" id="popButton1">确定</a>
  	<a href="javascript:closeDiv()">关闭</a>
  </div>
</div>
<div id="popBg" class="bg" style="display:none;"></div>
<iframe id='popIframe' class='popIframe' style="frameborder:0;"></iframe>
<script type="text/javascript">
	function showDiv(){
		document.getElementById('popDiv').style.display='block';
		document.getElementById('popIframe').style.display='block';
		document.getElementById('popBg').style.display='block';
	}
	
	function showDiv1(){
		document.getElementById('popDiv1').style.display='block';
		document.getElementById('popIframe').style.display='block';
		document.getElementById('popBg').style.display='block';
	}
	
	function closeDiv(){
		document.getElementById('popDiv').style.display='none';
		document.getElementById('popDiv1').style.display='none';
		document.getElementById('popBg').style.display='none';
		document.getElementById('popIframe').style.display='none';
	}
	
	(function(windows,undefied){
		//提示弹出层对象
		var yofangTip = {
			//执行打开弹出层,一个按钮
			openFirst : function(content,callback){
				var fn = new invoker(callback, arguments, 2);
				var tipContent = $("#popDiv").find(".mydivcont");
				$(tipContent).html(content);
				var popClose = $("#popDiv").find("#popClose");
				showDiv();
				fn.invoke(popClose);
			},
			//执行打开弹出层，两个按钮
			openSecond : function(content, callback){
				var fn = new invoker(callback, arguments, 2);
				var tipContent = $("#popDiv1").find(".mydivcont");
				$(tipContent).html(content);
				var sureButton = $("#popDiv1").find("#popButton1");
				fn.invoke(sureButton);
				showDiv1();
			},
			//弹出层提示,两个按钮,支持按钮名称修改
			openSecondWithButtonTip : function(content,buttonTip, callback){
				var fn = new invoker(callback, arguments, 2);
				var tipContent = $("#popDiv1").find(".mydivcont");
				$(tipContent).html(content);
				var sureButton = $("#popDiv1").find("#popButton1");
				$(sureButton).html(buttonTip);
				fn.invoke(sureButton);
				showDiv1();
			},
			//执行关闭弹出层
			close : function(){
				closeDiv();
			}
		};
		window['yofangTip'] = yofangTip;
	})(window);
</script>
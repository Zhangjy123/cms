<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="org.nutz.dao.pager.Pager"%>
<%@page import="org.nutz.dao.QueryResult"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link type="text/css" href="${pageContext.request.contextPath}/css/public/page.css" rel="stylesheet">
<script type="text/javascript">
	function pageSubmit(url) {
		window.location.href=url+$(".jumpto").val();
	}
	
	//对输入的页码进行校验	
	$().ready(function(){
		var data = ${param.pagecount_page};
		var pageNum = ${param.pagenum_page};
		$(".jumpto").blur(function(){
			if(!isNum($(this).val()) || $(this).val() > data){
				$(this).attr("value",pageNum);
			}
		});		
	});
	
	//检查是否数字
	function isNum(a)
	{
	    var reg = /^\+?[1-9][0-9]*$/;
	    return reg.test(a);
	};
</script>
<%--
	使用方法：
		<!-- 分页开始 -->
			<jsp:include page="../public/page.jsp" flush="true">
				<jsp:param name="url_page" value="${base}/pcategory/index?pageNum="/>							
				<jsp:param name="pagenum_page" value="${obj.pager.pageNumber}"/>							
				<jsp:param name="pagecount_page" value="${obj.pager.pageCount}"/>							
				<jsp:param name="startBeforeNums" value="5"/>							
				<jsp:param name="endAfterNums" value="4"/>							
			</jsp:include>
		<!-- 分页结束-->

 --%>
<% 
	/**
	 * 分页 ：实现效果，点击的页面一直在中间显示，左右显示的页码角标数量根据startBeforeNums，endAfterNums定制
	 * @param startBeforeNums	//当前页前面显示可点击的页码数量   
	 * @param endAfterNums		//当前页后面显示可点击的页码数量
	 * 例如：startBeforeNums=3;endAfterNums=2 	分页效果：  （4 5 6  当前页 8 9）
	 * @param pageNum	//请求页面，由后台获得 
	 * @param pageCount	//总页码，后台获得
	 */
	int startBeforeNums = Integer.parseInt((String)request.getParameter("startBeforeNums"));
	int endAfterNums = Integer.parseInt((String)request.getParameter("endAfterNums"));
	int pageNum = 1; //当前页
	int pageCount = 1;//总页数
	if((String)request.getParameter("pagenum_page") != null && !"".equals((String)request.getParameter("pagenum_page"))) {
		pageNum = Integer.parseInt((String)request.getParameter("pagenum_page")) <= 0 ? 1 :Integer.parseInt((String)request.getParameter("pagenum_page"));
	};
	if((String)request.getParameter("pagecount_page") != null && !"".equals((String)request.getParameter("pagecount_page"))) {
		pageCount = Integer.parseInt((String)request.getParameter("pagecount_page")) <= 0 ? 1 : Integer.parseInt((String)request.getParameter("pagecount_page"));
	};
	int start_num  = 1;     			//每页开始角标
	int end_num  = 1;					//每页结束角标
	int pageSize =  startBeforeNums + endAfterNums + 1;//每页可点击的角标个数
	//1.如果总页数 < pageSiz显示所有的页码
	if ( pageCount < pageSize) {
		end_num = pageCount;
	//2.如果当前是前1,2...startBeforeNums+1,那么第一页全部显示
		} else if (pageNum <= startBeforeNums + 1) {
			end_num = pageSize;
		} else {
			start_num = pageNum - startBeforeNums >=1 ? pageNum - startBeforeNums : 1;
			end_num = pageNum + endAfterNums <= pageCount ? pageNum + endAfterNums : pageCount;
		}
	
		//存入request域中，<c:foreach>标签可以根据el表达式取到值
		request.setAttribute("start_num", start_num);
		request.setAttribute("end_num", end_num);
%>

	
	<div id="pagin-btm" class="pagin fr">
		<a class="${param.pagenum_page <= 1 ?'prev-disabled':'prev'}" href="${param.url_page}${param.pagenum_page-1}">上一页<b></b></a>
		<c:forEach var="num" begin="${requestScope.start_num}" end="${requestScope.end_num}">
				<a href="${param.url_page}${num}" class="${param.pagenum_page==num ? 'current' : ''}">${num}</a>
		</c:forEach>
		<c:if test="${param.pagenum_page < param.pagecount_page-4}" ><span class="text">…</span></c:if>
		
		<a href="${param.url_page}${param.pagenum_page<param.pagecount_page?param.pagenum_page+1:param.pagecount_page}" class="${param.pagenum_page >= param.pagecount_page ? 'next-disabled':'next'}" title="使用方向键右键也可翻到下一页哦! 未实现">下一页<b></b></a>
		<span class="page-skip"><em>&nbsp;&nbsp;共${param.pagecount_page}页&nbsp;&nbsp;&nbsp;&nbsp;到第</em>
			<input class="jumpto" type="text" value="${param.pagenum_page}"/>
			<em>页</em><a class="btn-skipsearch" value="确定" onclick="pageSubmit('${param.url_page}')" href="javascript:void(0)">确定</a>
		</span>
	</div>

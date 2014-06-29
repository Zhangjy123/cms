package com.yofang.cms.web.module.group;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.JspView;
import org.nutz.mvc.view.ViewWrapper;

import cn.yofang.dao.model.inter.IPage;
import cn.yofang.dao.model.mongoimpl.project.GroupPurchase;

@At("/group")
public class GroupPurchaseAction {
	
	private static final int PAGESIZE = 2;
	
	@At("/index")
	public View index(HttpServletRequest request,@Param("userRealName") String userRealName,
			@Param ("projectName") String projectName,@Param("mobile") String mobile, @Param("pageNum") int pageNum){
		Map<String, Object> data = new HashMap<String, Object>();
		GroupPurchase gp = new GroupPurchase();
		IPage list = gp.queryAll(null, userRealName, null, projectName, mobile, null, null, null, null, pageNum, PAGESIZE);
		data.put("list", list);
		data.put("userRealName", userRealName);
		data.put("projectName",projectName);
		data.put("mobile", mobile);
		return new ViewWrapper(new JspView("jsp.back.grouppurchase.index"), data);
	}

}

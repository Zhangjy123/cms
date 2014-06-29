package com.yofang.cms.web.module.project;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.dao.Cnd;
import org.nutz.dao.QueryResult;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.JspView;
import org.nutz.mvc.view.RawView;
import org.nutz.mvc.view.ViewWrapper;



import com.yofang.cms.model.Project;
import com.yofang.cms.service.ProjectService;
import com.yofang.cms.utils.CommonUtil;

/**
 * 后台管理员渠道管理
 * @author gaozp
 */
@IocBean(scope = "request")
@At("/project")

public class ProjectAction {
	private static final int PAGESIZE = 3;
	
	
	@Inject
	private ProjectService projectService;
	
	/**
	 * 添加
	 * 
	 */
	@At("/add")
	public View add() {
		return new ViewWrapper(new JspView("jsp.back.projectmanage.add"), null);
	}
	/**
	 * 查看所有的渠道
	 * 修改：hsh
	 */
	@At("/index")
	public View index(HttpServletRequest request
			,@Param("pageNum") int pageNum
			, @Param("name") String name
			, @Param("catagory") Integer catagory
			, @Param("address") String address) {
		Map<String, Object> data = new HashMap<String, Object>();
		
		if (pageNum == 0) pageNum = 1;
		String str = "1=1";
		if(CommonUtil.notEmpty(name))str+=" and name= '"+name+"'";
		if(catagory!=null && catagory!=0)str+=" and catagory= '"+catagory+"'";
		if(CommonUtil.notEmpty(address))str+=" and address= '"+address+"'";
		QueryResult qr;
		qr = projectService.getPageListByCondition(pageNum, ProjectAction.PAGESIZE, Cnd.wrap(str));
		
		data.put("qr", qr);
		data.put("name", name);
		data.put("catagory", catagory);
		data.put("address", address);
		return new ViewWrapper(new JspView("jsp.back.projectmanage.index"), data);
	}
	/**
	 * 保存渠道
	 */
	@At("/save")
	public View saveOrUpdate(@Param("id") Long id
			, @Param("name") String name
			, @Param("catagory") Integer catagory
			, @Param("address") String address
			,HttpServletRequest request
			,HttpServletResponse response) {
		Integer msgType = 0;
		if(CommonUtil.isEmpty(name)){
			msgType = 1;
		}else if(catagory==null){
			msgType = 2;
		}else if(CommonUtil.isEmpty(address)){
			msgType = 3;
		}else{
			if(id!=null){
				Project t = projectService.getById(id);
				if(CommonUtil.notEmpty(name))t.setName(name);
				if(catagory!=null)t.setCatagory(catagory);
				if(CommonUtil.notEmpty(address))t.setAddress(address);
				projectService.updateEntity(t);
			}else{
				Project c = new Project();
				if(CommonUtil.notEmpty(name))c.setName(name);
				if(catagory!=null)c.setCatagory(catagory);
				if(CommonUtil.notEmpty(address))c.setAddress(address);
				c.setCreateDate(new Date());
				projectService.saveEntity(c);
			}
		}
		return new ViewWrapper(new RawView("application/json"), msgType);
//		try {
//			response.sendRedirect(request.getContextPath() + "/project/index");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
	}
	/**
	 * 删除渠道
	 */
	@At("/delete")
	public View delete(@Param("id") Long id, HttpServletRequest request,HttpServletResponse response){
		if(id!=null)projectService.deleteById(id);
		try {
			response.sendRedirect(request.getContextPath() + "/project/index");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 修改渠道
	 */
	@At("/update")
	public View update(@Param("id") Long id){
		Project c = projectService.getById(id);
		return new ViewWrapper(new JspView("jsp.back.projectmanage.update"), c);
	}

}

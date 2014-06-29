package com.yofang.cms.web.module.system;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.dao.QueryResult;
import org.nutz.ioc.aop.Aop;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.JspView;
import org.nutz.mvc.view.RawView;
import org.nutz.mvc.view.ViewWrapper;

import com.google.gson.Gson;
import com.yofang.cms.manage.ManagerService;
import com.yofang.cms.model.Channel;
import com.yofang.cms.model.OperateLog;
import com.yofang.cms.model.Role;
import com.yofang.cms.model.User;
import com.yofang.cms.service.ChannelService;
import com.yofang.cms.service.OperateLogService;
import com.yofang.cms.service.RoleService;
import com.yofang.cms.service.UserService;
import com.yofang.cms.utils.Formater;
import com.yofang.cms.web.module.sig.LoginAction;

/**
 * 后台管理员账户管理
 * @author hsh
 */
@IocBean(scope = "request")
@At("/user")
public class UserAction {
	private static final int PAGESIZE = 13;
	
	@Inject
	private LoginAction loginAction;
	@Inject
	private ChannelService channelService;
	@Inject
	private RoleService roleService; 
	@Inject
	private UserService userService;
	@Inject
	private OperateLogService operateLogService;
	
	/**
	 * 查看所有的账户
	 */
	@At("/index")
	public View index(@Param("pageNum") int pageNum) {
		QueryResult qr = userService.getUserPageCascade(pageNum, UserAction.PAGESIZE);
		return new ViewWrapper(new JspView("jsp.back.sysmanage.index"), qr);
	}
	
	/**
	 * 修改个人信息
	 */
	public View updateMyInfo(HttpServletRequest request) {
		User user = ManagerService.getUser(request);
		return  this.toUpdate(user.getId());
	}
	
	/**
	 * 添加一个管理员账户
	 * @param request
	 * @param username
	 */
	@At("/add")
	@Aop({"operateLogInterceptor"})
	public View add(HttpServletRequest request, @Param("::user.") User user) {
		/**
		 * 0:保存成功
		 * 1:该手机号已经存在
		 */
		int msgType = 0;
		//判断手机号是否存在
		User u = userService.getUserByMobile(user.getMobile());
		if (u != null) {
			msgType = 1;
		} else {
			user.setCreateTime(new Date());
			userService.saveEntity(user);
		}
		Channel channel = channelService.getById(user.getChannelId());
		request.setAttribute("logDesc", "增加账户-->"+ channel.getChannelName()+ "的" + user.getRealName());
		return new ViewWrapper(new RawView(Formater.JSON_FORMATER), new Gson().toJson(msgType));
	}
	
	/**
	 * 转发到添加管理员页面
	 * @param request
	 * @param username
	 */
	@At("/toadd")
	public View toAdd() {
		Map<String, Object> data = new HashMap<String, Object>();
		//查询所有的渠道（公司名称），以及所有角色回显
		List<Channel> allChannelList = channelService.findAll();
		List<Role> allRoleList = roleService.findAll();
		
		data.put("allChannelList", allChannelList);
		data.put("allRoleList", allRoleList);
		return new ViewWrapper(new JspView("jsp.back.sysmanage.add"), data);
	}
	
	/**
	 * 转发到账户更新页面
	 * @param request
	 * @param username
	 */
	@At("/toupdate")
	public View toUpdate(@Param("id") int id) {
		Map<String, Object> data = new HashMap<String, Object>();
		//查询所有的渠道（公司名称），以及所有角色回显
		List<Channel> allChannelList = channelService.findAll();
		List<Role> allRoleList = roleService.findAll();
		User user = userService.getById(id);
		
		data.put("allChannelList", allChannelList);
		data.put("allRoleList", allRoleList);
		data.put("user", user);
		return new ViewWrapper(new JspView("jsp.back.sysmanage.update"), data); 
	}
	
	/**
	 * 账户更新
	 * @param request
	 * @param username
	 */
	@At("/update")
	@Aop({"operateLogInterceptor"})
	public View update(HttpServletRequest request, HttpServletResponse response, @Param("::user.") User user) {
		/**
		 * 0:保存成功
		 * 1:该手机号已经存在
		 */
		int msgType = 0;
		//判断手机号是否存在
		User u = userService.getUserByMobile(user.getMobile());
		//如果根据该手机号查询到记录，并且该记录不是原来的手机号信息，那么该手机号已经存在
		if (u != null && u.getId().intValue()!=user.getId().intValue()) {
			msgType = 1;
		} else {
			userService.updateEntity(user);
		}
		request.setAttribute("logDesc", "更新账户-->" + user.getRealName());
		return new ViewWrapper(new RawView(Formater.JSON_FORMATER), new Gson().toJson(msgType));
	}
	
	@At("/delete")
	@Aop({"operateLogInterceptor"})
	public View delete(HttpServletRequest request,@Param("id") int id){
		User user = userService.getById(id);
		userService.deleteById(id);
		Channel channel = channelService.getById(user.getChannelId());
		request.setAttribute("logDesc", "删除账户-->" + channel.getChannelName() + "的" + user.getRealName());
		return this.index(1);
	}
	
	/**
	 * 跳转到修改密码页面
	 * @return
	 */
	@At("/toupdatepwd")
	public View toUpdatePwd(@Param("errorMsg") String errorMsg){
		return new ViewWrapper(new JspView("jsp.back.sysmanage.updatePwd"), errorMsg) ;
	}
	
	/**
	 * 修改用户密码
	 * @param request
	 * @param password
	 * @param newPassord
	 * @return
	 */
	@At("/updatepwd")
	public View updatePwd(HttpServletRequest request, HttpServletResponse response, @Param("oldpassword") String oldpassword, @Param("newPassword") String newPassword){
		String  errorMsg =  "";
		//从缓存中获取用户信息
		User user = ManagerService.getUser(request);
		//根据用户名和密码查询用户账号信息
		user = userService.getUser(user.getRealName(), oldpassword, false);
		if(user != null && user.getRealName() != null) {
			//保存新密码
			user.setPassword(newPassword);
			userService.updateEntity(user);
			request.setAttribute("logDesc", "更改账号密码");
			//清楚session让用户重新登录
			ManagerService.clearUser(request);
			
			//保存操作日志
			OperateLog log = new OperateLog();
			log.setUseraccount(user.getRealName());
			log.setTime(new Date());
			log.setIp(request.getRemoteAddr());
			log.setDescription("修改密码");
			operateLogService.saveEntity(log);
			
			//转发到登录界面
			return loginAction.login(request,"","修改密码成功，请重新登录");
		} else {
			errorMsg = "密码不正确,请重新输入";
			return toUpdatePwd(errorMsg);
		}
	}
	
}

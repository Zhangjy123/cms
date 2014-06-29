package com.yofang.cms.web.module.sig;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.view.JspView;
import org.nutz.mvc.view.ViewWrapper;

import com.yofang.cms.enums.RoleType;
import com.yofang.cms.manage.ManagerService;
import com.yofang.cms.model.User;
import com.yofang.cms.service.UserService;
import com.yofang.cms.utils.CommonUtil;

@At("/back")
@IocBean(scope="request")
public class LoginAction {
	
	@Inject
	private UserService userService;
	
	
	/**
	 * 访问后台管理登录页面接口
	 * @param url 历史访问地址
	 * @param errorMsg 错误提示信息
	 * @return
	 */
	@At("/login")
	public View login(HttpServletRequest request,@Param("url") String url, @Param("errorMsg") String errorMsg){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("url", url);
		data.put("errorMsg", errorMsg);
		data.put("cookieMobile", ManagerService.getCookieMobile(request));
		return new ViewWrapper(new JspView("jsp.login"), data);
	}
	
	/**
	 * 登录数据提交接口
	 * @param url 历史访问地址
	 * @param username 用户名
	 * @param password 密码
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return
	 */
	@At("/doLogin")
	public View doLogin(@Param("url") String url,
			@Param("mobile") String mobile,
			@Param("password") String password, HttpServletRequest request,
			HttpServletResponse response) {
		if (CommonUtil.notEmpty(mobile) && CommonUtil.notEmpty(password)) {
			User user = userService.getUser(mobile, password,true);
			boolean isExist = false;
			if (user != null && user.getId() != null) {
				isExist = true;
			}
			/**保存用户信息账号到cookie*/
			ManagerService.addCookie(response ,ManagerService.COOKIE_AUTO_LOGIN,user.getMobile());
			if (isExist) {
				ManagerService.setManager(user, request, response);
				if (CommonUtil.isEmpty(url)) {
					//根据用户的类型转发到不同的管理页面
					if (RoleType.ADMIN.getName().equals(user.getRole().getName())) {
						url = "/user/index";
					} else {
						url = "/customer/index";
					}
				}
				try {
					response.sendRedirect(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				String errorMsg = "账号或密码错误";
				return login(request, url,errorMsg);
			}
		} else {
			String errorMsg = "账号和密码不能为空";
			return login(request,url,errorMsg);
		}
		return null;
	}

	/**
	 * 退出登录接口
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return
	 */
	@At("/logout")
	public View logout(HttpServletRequest request, HttpServletResponse response){
		ManagerService.clearUser(request);
		String redirectUrl = request.getContextPath() + "/back/login";
		try {
			response.sendRedirect(redirectUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

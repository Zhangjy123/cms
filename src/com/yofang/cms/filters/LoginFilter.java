package com.yofang.cms.filters;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;

import com.yofang.cms.manage.ManagerService;
import com.yofang.cms.model.User;
import com.yofang.cms.web.module.sig.LoginAction;

/**
 * 登录检查过滤器
 * 登录界面不检查/back/login /back/dologin 以及/
 * @author Administrator
 *
 */
public class LoginFilter implements ActionFilter{

	@Override
	public View match(ActionContext context) {
		HttpServletRequest request = context.getRequest();
		String method = request.getMethod();
		String url = request.getRequestURI();
		StringBuffer sb = new StringBuffer(url);
		Map<String,String[]> map = request.getParameterMap();
		Set<String> keys = map.keySet();
		Iterator<String> its = keys.iterator();
		int i = 0;
		while(its.hasNext()){
			String key = its.next();
			String[] values = map.get(key);
			int j = 0;
			for(String value:values){
				if(j == 0 & i == 0){
					sb.append("?");
					sb.append(key);
					sb.append("=");
					sb.append(value);
				}else{
					sb.append("&");
					sb.append(key);
					sb.append("=");
					sb.append(value);
				}
				j++;
			}
			i++;
		}
		
		//对登录请求的方法不进行拦截
		if(sb.toString().startsWith("/back/doLogin") || sb.toString().startsWith("/back/Login") || sb.toString().equals("/")){
			return null;
		};
		
		//检查是否登录
		User user = ManagerService.getUser(request);
		if(user == null){
			String errorMsg = "请先登录系统";
			if("GET".equalsIgnoreCase(method)){
				return new LoginAction().login(request,sb.toString(),errorMsg);
			}else{
				return new LoginAction().login(request, null,errorMsg);
			}
		}
		return null;
	}

}

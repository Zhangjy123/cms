package com.yofang.cms.aop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.nutz.aop.InterceptorChain;
import org.nutz.aop.MethodInterceptor;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.manage.ManagerService;
import com.yofang.cms.model.OperateLog;
import com.yofang.cms.service.OperateLogService;

/**
 * 操作日志保存到数据库
 * 
 * 注意事项：
 * 在拦截的方法中，第一个参数必须是request，传到拦截器中以便获取操作者数据
 * 在拦截的方法中往request域中添加一个logDesc，表示操作的内容   例如：request.setAttribute("logDesc","xxx登录")
 * 操作保存在数据库后清除logDesc,	request.removeAttribute("logDesc");
 * @author hsh
 */
@IocBean
public class OperateLogInterceptor implements MethodInterceptor {
	
	@Inject
	private OperateLogService operateLogService;
	
	@Override
	public void filter(InterceptorChain chain) throws Throwable {
		
		//被拦截的方法放行
		chain.doChain();
		
		//获取被拦截的请求对象
		HttpServletRequest request  = (HttpServletRequest)(chain.getArgs()[0]);
		//封装当前用户的操作记录
		OperateLog operateLog = new OperateLog();
		operateLog.setTime(new Date());
		operateLog.setUseraccount(ManagerService.getUser(request).getRealName());
		operateLog.setDescription((String)request.getAttribute("logDesc"));
		operateLog.setIp(request.getRemoteAddr());
		
		//保存操作日志到数据库
		operateLogService.saveEntity(operateLog);
		
		//清楚request中的logDesc值
		request.removeAttribute("logDesc");
	}
	
}

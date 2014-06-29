package com.yofang.cms.listener;


import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.annotation.AnnotationIocLoader;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.ioc.loader.json.JsonLoader;

import com.yofang.cms.cache.CacheChecker;
import com.yofang.cms.cache.CacheManager;
import com.yofang.cms.enums.RoleType;
import com.yofang.cms.service.RoleService;
import com.yofang.cms.service.impl.RoleServiceImpl;
import com.yofang.cms.web.formbean.RoleBean;

public class SiteContextListener implements ServletContextListener {
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("结束了");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Timer timer = new Timer();
		timer.schedule(new CacheChecker(), 2000, 5*60*1000);
		RoleType[] values = RoleType.values();
		
		//加载ioc容器
		Ioc ioc = new NutIoc(new ComboIocLoader(
									 new AnnotationIocLoader("com.yofang.cms.dao.impl", "com.yofang.cms.service.impl", "com.yofang.cms.web.module")
									 ,new JsonLoader("aop/transaction.js","ioc/nutzdao.js")));
		//从容器中取出roleService
		RoleService	roleService= (RoleServiceImpl) ioc.get(null, "roleService");
		
		//加载系统权限	
		List<RoleBean> roles =  roleService.getAllRolePriveleges();
		for (RoleBean roleBean : roles) {
			//永久缓存
			CacheManager.putContent(roleBean.getRoleName(), roleBean, (-60 - new Date().getTime()));
		}
		
		//清空ioc容器
		ioc = null;
	}

}

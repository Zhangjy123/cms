package com.yofang.cms.web.module;


import org.nutz.mvc.View;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.ioc.provider.ComboIocProvider;
import org.nutz.mvc.view.JspView;

import com.yofang.cms.filters.LoginFilter;


@Modules(scanPackage=true)
//复合加载器： 加载事务管理配置文件transaction.js，ioc包扫描AnnotationIocLoader
@IocBy(type = ComboIocProvider.class,
	args = { "*org.nutz.ioc.loader.json.JsonLoader",
			 "aop/transaction.js",
			 "ioc/nutzdao.js",
			 "*org.nutz.ioc.loader.annotation.AnnotationIocLoader",		
			 "com.yofang.cms.aop",
			 "com.yofang.cms.dao.impl",
			 "com.yofang.cms.service.impl", 
			 "com.yofang.cms.web.module"})
@Encoding(input="UTF-8", output="UTF-8")
@Filters(@By(type = LoginFilter.class))
public class MainAction {
	
	/**
	 * 后台登录首页
	 * @return
	 */
	@At("/")
	public View index() {
		return new JspView("jsp.login");
	}
}


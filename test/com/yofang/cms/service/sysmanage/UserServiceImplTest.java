package com.yofang.cms.service.sysmanage;

import java.util.Date;

import org.junit.Test;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.annotation.AnnotationIocLoader;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.ioc.loader.json.JsonLoader;

import com.yofang.cms.model.User;
import com.yofang.cms.service.UserService;
import com.yofang.cms.service.impl.UserServiceImpl;


public class UserServiceImplTest {
	private static UserService uService;
	
	static {
		//加载ioc容器
		Ioc ioc = new NutIoc(new ComboIocLoader(
							 new AnnotationIocLoader("com.yofang.cms.dao.impl", "com.yofang.cms.service.impl", "com.yofang.cms.web.module")
							 ,new JsonLoader("aop/transaction.js","ioc/nutzdao.js")));
		//从容器中取出测试对象
		uService= (UserServiceImpl) ioc.get(null, "userService");
	}
	
	//单表保存测试
	@Test
	public void testSave(){
		User user = new User();
		user.setMobile("15652627241");
		user.setRealName("gzp");
		user.setPassword("123456");
		user.setCreateTime(new Date());
		user.setRoleId(7);
		uService.saveEntity(user);
	}
	
	//单表修改测试
	@Test
	public void testUpdate(){
		User user = uService.getById(1);
		user.setRoleId(7);
		uService.updateEntity(user);
	}
}

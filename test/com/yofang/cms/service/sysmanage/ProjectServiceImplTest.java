package com.yofang.cms.service.sysmanage;

import java.util.Date;

import org.junit.Test;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.annotation.AnnotationIocLoader;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.ioc.loader.json.JsonLoader;

import com.yofang.cms.model.Project;
import com.yofang.cms.service.ProjectService;
import com.yofang.cms.service.impl.ProjectServiceImpl;


public class ProjectServiceImplTest {
	private static ProjectService projectService;
	
	static {
		//加载ioc容器
		Ioc ioc = new NutIoc(new ComboIocLoader(
							 new AnnotationIocLoader("com.yofang.cms.dao.impl", "com.yofang.cms.service.impl", "com.yofang.cms.web.module")
							 ,new JsonLoader("aop/transaction.js","ioc/nutzdao.js")));
		//从容器中取出测试对象
		projectService= (ProjectServiceImpl) ioc.get(null, "projectService");
	}
	
	//单表保存测试
	@Test
	public void testSave(){
		Project c = new Project();
		for(int i=0;i<20;i++){
			c.setName("凤凰项目"+i);
			c.setCatagory(1);
			c.setAddress("东城区嘉怡路"+i+"路");
			c.setCreateDate(new Date());
			projectService.saveEntity(c);
		}
	}
}

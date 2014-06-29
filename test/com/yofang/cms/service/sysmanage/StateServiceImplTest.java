package com.yofang.cms.service.sysmanage;

import org.junit.Test;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.annotation.AnnotationIocLoader;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.ioc.loader.json.JsonLoader;

import com.yofang.cms.model.State;
import com.yofang.cms.service.StateService;
import com.yofang.cms.service.impl.StateServiceImpl;

public class StateServiceImplTest {
private static StateService stateService;
	
	static {
		//加载ioc容器
		Ioc ioc = new NutIoc(new ComboIocLoader(
							 new AnnotationIocLoader("com.yofang.cms.dao.impl", "com.yofang.cms.service.impl", "com.yofang.cms.web.module")
							 ,new JsonLoader("aop/transaction.js","ioc/nutzdao.js")));
		//从容器中取出测试对象
		stateService= (StateServiceImpl) ioc.get(null, "stateService");
	}
	
	@Test
	public void SaveTest(){
		State state = new State();
		state.setId(1);
		state.setSort(1);
		state.setStateName("新客户");
		stateService.saveEntity(state);
	}

}

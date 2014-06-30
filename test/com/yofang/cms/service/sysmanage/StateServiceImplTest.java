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
		for(int i=1;i<10;i++){
			state.setId(i);
			state.setSort(i);
			String str = "";
			switch(i){
			case 1 : str="新客户";
			case 2 : str = "已预约";
			case 3 : str = "已看房";
			case 4 : str = "客户已确认";
			case 5 : str = "已交订金";
			case 6 : str = "已购房";
			case 7 : str = "已申请佣金";
			case 8 : str = "已申请佣金";
			case 9 : str = "佣金已发放";
			}
			state.setStateName(str);
			stateService.saveEntity(state);
		}
	}

}

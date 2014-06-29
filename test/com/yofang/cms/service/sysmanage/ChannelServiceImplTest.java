package com.yofang.cms.service.sysmanage;

import java.util.Date;

import org.junit.Test;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.annotation.AnnotationIocLoader;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.ioc.loader.json.JsonLoader;

import com.yofang.cms.model.Channel;
import com.yofang.cms.service.ChannelService;
import com.yofang.cms.service.impl.ChannelServiceImpl;


public class ChannelServiceImplTest {
	private static ChannelService channelService;
	
	static {
		//加载ioc容器
		Ioc ioc = new NutIoc(new ComboIocLoader(
							 new AnnotationIocLoader("com.yofang.cms.dao.impl", "com.yofang.cms.service.impl", "com.yofang.cms.web.module")
							 ,new JsonLoader("aop/transaction.js","ioc/nutzdao.js")));
		//从容器中取出测试对象
		channelService= (ChannelServiceImpl) ioc.get(null, "channelService");
	}
	
	//单表保存测试
	@Test
	public void testSave(){
		Channel c = new Channel();
		for(int i=0;i<20;i++){
			c.setChannelName("中科电商古"+i);
			c.setContacts("小军"+i);
			c.setPhone("138888888"+i);
			c.setCreateDate(new Date());
			channelService.saveEntity(c);
		}
	}
}

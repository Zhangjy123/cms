package com.yofang.cms.service.impl;


import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.impl.ChannelDaoImpl;
import com.yofang.cms.model.Channel;
import com.yofang.cms.service.ChannelService;

@IocBean(name="channelService", args={"refer:channelDao"})
public class ChannelServiceImpl extends BaseServiceImpl<Channel, ChannelDaoImpl> implements ChannelService {
	
	
	public ChannelServiceImpl(ChannelDaoImpl baseDao) {
		super(baseDao);
	}
}

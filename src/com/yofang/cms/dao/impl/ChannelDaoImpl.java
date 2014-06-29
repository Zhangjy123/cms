package com.yofang.cms.dao.impl;



import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.ChannelDao;
import com.yofang.cms.model.Channel;

@IocBean(name="channelDao",fields={"dao"})
public class ChannelDaoImpl extends BaseDaoImpl<Channel> implements ChannelDao {

}

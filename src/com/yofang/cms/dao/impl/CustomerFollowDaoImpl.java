package com.yofang.cms.dao.impl;



import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.CustomerFollowDao;
import com.yofang.cms.model.CustomerFollow;

@IocBean(name="customerFollowDao",fields={"dao"})
public class CustomerFollowDaoImpl extends BaseDaoImpl<CustomerFollow> implements CustomerFollowDao {

}

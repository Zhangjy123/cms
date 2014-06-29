package com.yofang.cms.service.impl;


import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.impl.CustomerFollowDaoImpl;
import com.yofang.cms.model.CustomerFollow;
import com.yofang.cms.service.CustomerFollowService;

@IocBean(name="customerFollowService", args={"refer:customerFollowDao"})
public class CustomerFollowServiceImpl extends BaseServiceImpl<CustomerFollow, CustomerFollowDaoImpl> implements CustomerFollowService {
	
	
	public CustomerFollowServiceImpl(CustomerFollowDaoImpl customerFollowDao) {
		super(customerFollowDao);
	}

	@Override
	public List<CustomerFollow> getInfoByCustomerId(Integer customerId) {
		return baseDao.getByConditon(Cnd.wrap("customerId=" + customerId + "order by createTime desc"));
	}
}

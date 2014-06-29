package com.yofang.cms.service.impl;


import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.impl.CustomerDaoImpl;
import com.yofang.cms.model.Customer;
import com.yofang.cms.service.CustomerService;

@IocBean(name="customerService", args={"refer:customerDao"})
public class CustomerServiceImpl extends BaseServiceImpl<Customer, CustomerDaoImpl> implements CustomerService {
	
	public CustomerServiceImpl(CustomerDaoImpl baseDao) {
		super(baseDao);
	}

	@Override
	public void deleteCustomerCascade(Integer id) {
		baseDao.deleteCustomerCascade(id);
	}
}

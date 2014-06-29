package com.yofang.cms.service;


import com.yofang.cms.model.Customer;

public interface CustomerService extends BaseService<Customer>{
	
	/**
	 * 删除一条客户记录同时删除approve，customerfollow表中的记录
	 * @param id
	 */
	void deleteCustomerCascade(Integer id);

	
}

package com.yofang.cms.service;


import java.util.List;

import com.yofang.cms.model.CustomerFollow;
import com.yofang.cms.service.BaseService;

public interface CustomerFollowService extends BaseService<CustomerFollow>{
	
	/**
	 * 获取某个客户的跟进记录
	 * @param customerId
	 * @return 
	 */
	List<CustomerFollow> getInfoByCustomerId(Integer customerId);
	
}

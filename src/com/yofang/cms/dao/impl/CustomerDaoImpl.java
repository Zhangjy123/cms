package com.yofang.cms.dao.impl;



import org.nutz.dao.impl.sql.NutSql;
import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.CustomerDao;
import com.yofang.cms.model.Customer;

@IocBean(name="customerDao",fields={"dao"})
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	@Override
	public void deleteCustomerCascade(Integer id) {
		dao.execute(new NutSql("delete from MANAGE_CUSTOMER where id="+id)
				,new NutSql("delete from MANAGE_CUSTOMERFOLLOW where customerId="+id),
				new NutSql("delete from MANAGE_APPROVE where customerId="+id));
	}

}

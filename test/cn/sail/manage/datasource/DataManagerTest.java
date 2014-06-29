package cn.sail.manage.datasource;

import org.junit.Test;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;

import com.alibaba.druid.pool.DruidDataSource;
import com.yofang.cms.manage.datasource.DataManager;
import com.yofang.cms.model.Approve;
import com.yofang.cms.model.Channel;
import com.yofang.cms.model.Customer;
import com.yofang.cms.model.CustomerFollow;
import com.yofang.cms.model.OperateLog;
import com.yofang.cms.model.Privilege;
import com.yofang.cms.model.Role;
import com.yofang.cms.model.User;

public class DataManagerTest {
	
	@Test
	public void testDataSource () {
		DruidDataSource ds = DataManager.getDataSource();
		System.out.println(ds);
		Dao dao = new NutDao(ds);
		dao.create(User.class, false);
		dao.create(Role.class, false);
		dao.create(Privilege.class, false);
		dao.create(Channel.class, false);
		dao.create(OperateLog.class, false);
		dao.create(Customer.class, false);
		dao.create(CustomerFollow.class, false);
		dao.create(Approve.class, false);
	}
} 

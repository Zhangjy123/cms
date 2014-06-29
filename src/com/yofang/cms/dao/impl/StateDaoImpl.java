package com.yofang.cms.dao.impl;



import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.StateDao;
import com.yofang.cms.model.State;

@IocBean(name="stateDao",fields={"dao"})
public class StateDaoImpl extends BaseDaoImpl<State> implements StateDao {
	
}


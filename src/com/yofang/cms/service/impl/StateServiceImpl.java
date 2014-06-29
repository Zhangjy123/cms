package com.yofang.cms.service.impl;

import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.impl.StateDaoImpl;
import com.yofang.cms.model.State;
import com.yofang.cms.service.StateService;

@IocBean(name="stateService", args={"refer:stateDao"})
public class StateServiceImpl extends BaseServiceImpl<State, StateDaoImpl> implements StateService {
	
	public StateServiceImpl(StateDaoImpl baseDao) {
		super(baseDao);
	}
}

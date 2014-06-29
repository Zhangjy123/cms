package com.yofang.cms.service.impl;


import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.impl.ProjectDaoImpl;
import com.yofang.cms.model.Project;
import com.yofang.cms.service.ProjectService;

@IocBean(name="projectService", args={"refer:projectDao"})
public class ProjectServiceImpl extends BaseServiceImpl<Project, ProjectDaoImpl> implements ProjectService {
	
	
	public ProjectServiceImpl(ProjectDaoImpl baseDao) {
		super(baseDao);
	}
}

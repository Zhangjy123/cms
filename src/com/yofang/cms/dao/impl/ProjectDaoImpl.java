package com.yofang.cms.dao.impl;



import org.nutz.ioc.loader.annotation.IocBean;

import com.yofang.cms.dao.ProjectDao;
import com.yofang.cms.model.Project;

@IocBean(name="projectDao",fields={"dao"})
public class ProjectDaoImpl extends BaseDaoImpl<Project> implements ProjectDao {

}

/**
 * 把nutzDao对象交有ioc管理
 */
var ioc = {
	dao:{
		type:"org.nutz.dao.impl.NutDao",
		args:[{java: 'com.yofang.cms.manage.datasource.DataManager.getDataSource()'}]
	}
}

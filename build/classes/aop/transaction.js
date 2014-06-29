/**
 * 全局的事务管理
 */
var ioc = {
	/**
	 * 定义数据库的事务级别
	 */
	txNONE : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [ 0 ]
	},
	txREAD_UNCOMMITTED : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [ 1 ]
	},
	txREAD_COMMITTED : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [ 2 ]
	},
	txREPEATABLE_READ : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [ 4 ]
	},
	txSERIALIZABLE : {
		type : 'org.nutz.aop.interceptor.TransactionInterceptor',
		args : [ 8 ]
	},
	
	/**
	 * 根据匹配条件，对service层的方法进行不同的事务管理
	 */
	$aop : {
	    type : 'org.nutz.ioc.aop.config.impl.ComboAopConfigration',
	    fields : {
	        aopConfigrations  : [
	            {	type : 'org.nutz.ioc.aop.config.impl.JsonAopConfigration',
	                fields : {
	                    itemList : [
	                        ['com\\.willar\\.service\\.impl\\..+','(get|find).+','ioc:txREAD_UNCOMMITTED'],			//service中所有以get find的开头的查询方法，开启事务
	                        ['com\\.willar\\.service\\.impl\\..+','^(?!get|find).+','ioc:txREPEATABLE_READ']//service中所有不以get find的开头的方法，开启事务
	                    ]
	                }
	            },
	            {	type : 'org.nutz.ioc.aop.config.impl.AnnotationAopConfigration'}
	        ]
	    }
	}
	
	
	
}

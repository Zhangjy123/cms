package com.yofang.cms.manage.datasource;


import com.alibaba.druid.pool.DruidDataSource;
import com.yofang.cms.manage.config.ConfFactory;
/**
 * 连接数据库
 * @author guolf
 *
 */
public class DataManager {
	/** 数据库驱动地址*/
	/** 数据库地址*/
//	public static String Url = "jdbc:h2:file:d://opt/sail/batch/sample;MODE=MySQL;MVCC=TRUE";
	public static String Url = ConfFactory.getConf().get("jdbcUrl");//"jdbc:h2:tcp://192.168.1.123:9092/sample;MODE=MySQL;MVCC=TRUE";
	public static String driverClassName = ConfFactory.getConf().get("driverClassName","com.mysql.jdbc.Driver");
	public static String username = ConfFactory.getConf().get("username");
	public static String password = ConfFactory.getConf().get("password");
	
	public static DruidDataSource ds = null;
	    
	public static String getUrl() {
		return Url;
	}
	/**
	 * 数据库驱动
	 */
	public static DruidDataSource getDataSource() {
		if(ds == null) {
			ds = new DruidDataSource();
			ds.setDriverClassName(driverClassName);
			ds.setUrl(Url);
			ds.setTestOnBorrow(false);
			ds.setUsername(username);
			ds.setPassword(password);
		}
		return ds;
	}	
}

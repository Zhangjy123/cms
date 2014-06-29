package com.yofang.cms.cache;


import java.util.Hashtable;
import java.util.Map;

import org.nutz.log.Log;
import org.nutz.log.Logs;

public class ManagerCache {

	private static Log log = Logs.getLog(ManagerCache.class);
	private static ManagerCache instance = new ManagerCache();
	
	private ManagerCache(){
		
	}
	
	public static ManagerCache getInstance(){
		return instance;
	}
	
	/**
	 * Key 用户账号 
	 * Value 用户对象
	 * */
	private static Map<String,ManagerLoginInfo> table = new Hashtable<String,ManagerLoginInfo>();
	
	/**
	 * 存储登录用户对象信息
	 * @param key 键名
	 * @param manager 登录用户对象
	 * @return ManagerLoginInfo
	 */
	public ManagerLoginInfo put(String key,ManagerLoginInfo manager){
		table.put(key, manager);
		log.debug("manager logined, the key is : "+ key +", and total size :" + table.size());
		return manager;
	}
	
	/**
	 * 获取登录用户对象信息
	 * @param key 键名
	 * @return ManagerLoginInfo
	 */
	public ManagerLoginInfo get(String key){
		return table.get(key);
	}
	
	/**
	 * 移除登录用户对象信息
	 * @param key 键名
	 */
	public void remove(String key){
		table.remove(key);
		log.debug("manager exit, the key is :" + key + ",and total size :" + table.size());
	}

	public Map<String, ManagerLoginInfo> getTable() {
		return table;
	}
}

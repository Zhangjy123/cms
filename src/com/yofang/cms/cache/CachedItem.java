package com.yofang.cms.cache;

/**
 * 定义被缓存的对象
 * @author liupf@buge.cn
 *
 */
public class CachedItem {
	/** 被缓存对象的主键 */
	private String key;
	/** 被缓存对象，可以是任意的java.lang.Object */
	private Object value;
	/** 缓存超时时间 */
	private long timeOut;
	/** 对象是否过期？ */
	private boolean expired;

	public CachedItem() {
		super();
	}

	public CachedItem(String key, Object value, long timeOut, boolean expired) {
		this.key = key;
		this.value = value;
		this.timeOut = timeOut;
		this.expired = expired;
	}

	public String getKey() {
		return key;
	}

	public long getTimeOut() {
		return timeOut;
	}

	public Object getValue() {
		return value;
	}

	public void setKey(String string) {
		key = string;
	}

	public void setTimeOut(long l) {
		timeOut = l;
	}

	public void setValue(Object object) {
		value = object;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean b) {
		expired = b;
	}
}
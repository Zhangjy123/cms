package com.yofang.cms.cache;



import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class CacheManager {
	private static Hashtable<String, CachedItem> CachedItemMap = new Hashtable<String, CachedItem>();

	private CacheManager() {
		super();
	}

	private synchronized static CachedItem getCachedItem(String key) {
		return (CachedItem) CachedItemMap.get(key);
	}

	private synchronized static boolean hasCachedItem(String key) {
		return CachedItemMap.containsKey(key);
	}

	public synchronized static void invalidateAll() {
		CachedItemMap.clear();
	}

	public synchronized static void invalidate(String key) {
		CachedItemMap.remove(key);
	}

	private synchronized static void putCachedItem(String key, CachedItem object) {
		CachedItemMap.put(key, object);
	}

	private synchronized static Set<String> keySet() {
		return CachedItemMap.keySet();
	}
	
	public synchronized static long removeTimeouts() {
		long count = 0;
		System.out.println("total objects in cache: " + CachedItemMap.size());
		Iterator<String> it = CachedItemMap.keySet().iterator();
		while(it.hasNext()) {
			CachedItem CachedItem = getCachedItem(it.next());
			if (cachedItemExpired(CachedItem)) {
				CachedItem.setExpired(true);
				//过期了，清空缓存，返回null
				it.remove();
				count++;
			}
		}
		System.out.println("Remove timeout cached item: " + count);
		return count;
	}
	
	/**
	 * 获取对象，如果对象不存在，或对象超时，返回null。
	 * 该方法访问缓存后，不会延长缓存对象生命周期
	 * @param key 对象主键
	 * @return 有效的缓存对象
	 */
	public static CachedItem getContent(String key) {
		if (hasCachedItem(key)) {
			CachedItem CachedItem = getCachedItem(key);
			if (cachedItemExpired(CachedItem)) {
				CachedItem.setExpired(true);
				//过期了，清空缓存，返回null
				remove(key);
				return null;
			}
			return CachedItem;
		} else {
			return null;
		}
	}
	
	/**
	 * 模糊匹配，查找缓存中第一个以prefix开始的值以
	 * @param prefix  缓存主键前缀
	 * @return 如果存在，返回第一个缓存对象；否则返回null
	 */
	public static CachedItem getContentByKeyPrefix(String prefix) {
		Set<String> keys = keySet();
		for(String key : keys) {
			if(key.startsWith(prefix))
				return getContent(key);
		}
		return null;
	}
	
	/**
	 * 获取对象，如果对象不存在，或对象超时，返回null。
	 * 该方法访问缓存后，自动延长被缓存对象的存活时间为"ttl+now"
	 * @param key
	 * @param ttl
	 * @return
	 */
	public static CachedItem getContentAndRenew(String key, long ttl) {
		if (hasCachedItem(key)) {
			CachedItem cachedItem = getCachedItem(key);
			if (cachedItemExpired(cachedItem)) {
				cachedItem.setExpired(true);
				//过期了，清空缓存，返回null
				remove(key);
				return null;
			} else {
				cachedItem.setTimeOut(ttl + new Date().getTime());
				return cachedItem;
			}
		} else {
			return null;
		}
	}
	
	public static CachedItem renewContent(String key, long ttl) {
		if (hasCachedItem(key)) {
			CachedItem cachedItem = getCachedItem(key);
			cachedItem.setTimeOut(ttl + new Date().getTime());
			return cachedItem;
		} else {
			return null;
		}
	}

	/**
	 * 存储对象
	 * @param key 主键
	 * @param content 被缓存的对象
	 * @param ttl 超时时间
	 */
	public static CachedItem putContent(String key, Object content, long ttl) {
		CachedItem CachedItem = new CachedItem();
		CachedItem.setKey(key);
		CachedItem.setValue(content);
		CachedItem.setTimeOut(ttl + new Date().getTime());
		CachedItem.setExpired(false);
		putCachedItem(key, CachedItem);
		return CachedItem;
	}

	public synchronized static void remove(String key) {
		CachedItemMap.remove(key);
	}
	
	public static Hashtable<String, CachedItem> getCache() {
		return CachedItemMap;
	}
	
	/**
	 * 判断对象是否过期了
	 * @param CachedItem
	 * @return
	 */
	private static boolean cachedItemExpired(CachedItem CachedItem) {
		if (CachedItem == null) {
			return false;
		}
		long milisNow = new Date().getTime();
		long milisExpire = CachedItem.getTimeOut();
		if (milisExpire < 0) { // CachedItem never expires 
			return false;
		} else if (milisNow >= milisExpire) {
			return true;
		} else {
			return false;
		}
	}

}

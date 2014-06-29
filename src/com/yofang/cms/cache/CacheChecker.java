package com.yofang.cms.cache;


import java.util.Timer;
import java.util.TimerTask;

public class CacheChecker extends TimerTask {

	@Override
	public void run() {
		CacheManager.removeTimeouts();
	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new CacheChecker(), 1000, 5 * 1000);
		CacheManager.putContent("key1", "value1", 3 * 1000);
		CacheManager.putContent("key2", "value2", 6 * 1000);
		CacheManager.putContent("key3", "value3", 9 * 1000);
		CacheManager.putContent("key4", "value4", 12 * 1000);
	}
}

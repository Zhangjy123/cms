package com.yofang.cms.utils;


import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * 订单号工具类
 * 
 * @author hsh
 */
public class OrderUtil {
	private static char[] ca = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
         'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	/**
	 * 生成18为的订单号
	 * @return 前6位随机数字 后12位为时间
	 */
	public static String genOrderNum() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMddmmss");
		String dateString = sdf.format(new Date());
		return randStr(8) + dateString;
	}
	
	/**
	 * 生成18位的交易流水号
	 * @return 前6位随机数字 后12位为时间
	 */
	public static String genDealNum() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMddmmss");
		String dateString = sdf.format(new Date());
		return "HZ" + randStr(6) + dateString;
	}
	
    /**
     * 生成n位随机字符串
     * 
     * @param n
     * @return
     */
    private static String randStr(int n) {
        char[] cr = new char[n];
        SecureRandom random = new SecureRandom();
        random.setSeed(System.nanoTime());
        for (int i = 0; i < n; i++) {
            int x = (int) random.nextLong() % 36;
            if (x < 0)
                x = -x;
            cr[i] = ca[x];
        }
        return (new String(cr));
    }
    
    @Test
    public void test(){
    	for (int i = 0; i < 20; i++) {
    		System.out.println(OrderUtil.genOrderNum());
		}
    }
}

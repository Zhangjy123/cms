package com.yofang.cms.utils;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ImageUtil {

public static Log log = LogFactory.getLog(ImageUtil.class);
	
	public static final String IMAGE_SUFFIX = ".jpg";
	
	/** 图片存储磁盘目录*/
	public static final String ROOT_DIR = "/mnt/share";
	/** 访问主目录*/
	public static final String IMAGE_ROOT = "/images";
	
	private static char[] cash = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	/** 图片类型-小图key*/
	public static final String IMAGE_TYPE_SMALL = "small";
	/** 图片类型-中图key*/
	public static final String IMAGE_TYPE_RECOMEND = "recomend";
	/** 图片类型-大图key*/
	public static final String IMAGE_TYPE_BIG = "big";
	/**
     * 获取文件的后缀
     * @param fileName 文件名
     * @return String 文件名的后缀
     */
    public static String getFilesuffix(String fileName) {
        int last = fileName.lastIndexOf(".");
        return fileName.substring(last);
    }
    
	/**
     * 根据已知的文件类型得出该图片文件的 时间戳目录
     * @return String
     */
    public static String getUploadFileDateRoot() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return "/" + year + "/" + month + "/" + day + "/" + hour + "/";
    }
    
    /**
     * 获得上传文件的随机生成的文件名
     * @param suffix 文件类型
     * @return String 文件名
     */
    public static String getUploadRondomFileName(String suffix) {
        // 图片新的名字
        String hash = randStr(6);
        return hash + suffix;
    }
    
    /**
     * 生成n位随机字符串
     * @param n 位数
     * @return String
     */
    public static String randStr(int n) {
        char[] cr = new char[n];
        SecureRandom random = new SecureRandom();
        random.setSeed(System.nanoTime());
        for (int i = 0; i < n; i++) {
            int x = (int) random.nextLong() % 36;
            if (x < 0)
                x = -x;
            cr[i] = cash[x];
        }
        return (new String(cr));
    }
    
    /**
     * 获得图片的文件名
     * @param type 文件类型
     * @param ronStr 随机六位字符
     * @param fileType 文件尺寸类型
     * @return
     */
    public static String getFilesuffixBySize(String type, String ronStr, String fileType) {
        String hash = ronStr;
        if (fileType.equals(IMAGE_TYPE_SMALL)){
        	return hash + IMAGE_TYPE_SMALL + type;
        } else if (fileType.equals(IMAGE_TYPE_RECOMEND)){
        	return hash + IMAGE_TYPE_RECOMEND + type;
        } else if (fileType.equals(IMAGE_TYPE_BIG)){
        	return hash + IMAGE_TYPE_BIG + type;
        } else {
        	return null;
        }
    }
    
    /**
     * 构造全路径图片地址
     * @param imagePath 图片地址,如:/upload/1.jpg
     * @param imageRoot 主目录,如:/upload
     * @return 全路径图片地址,如D:/file/images/1.jpg
     */
    public static String getRealPath(String imagePath, String imageRoot){
    	if(imagePath.contains(imageRoot)) imagePath = imagePath.replace(imageRoot, ROOT_DIR);
    	return imagePath;
    }
    
    /**
     * 通过大图片地址判断小图或中图地址是否属于一类
     * @param bigPath 大图地址
     * @param path 其他类型图片
     * @return true:相同 false:不同
     */
    public static boolean sameImage(String bigPath, String path){
    	boolean same = false;
    	int lastIndexDian = bigPath.lastIndexOf(".");
    	String sameString = bigPath.substring(0, lastIndexDian);
    	if(path.contains(sameString)) same = true;
    	return same;
    }
    
    /**
     * 相同图片大中小图片集合
     * @param bigImages 大图片地址
     * @param recomendImages 中图片地址
     * @param smallImages 小图片地址
     * @return
     */
    public static List<Map<String, String>> mappingImages(String[] bigImages, String[] recomendImages, String[] smallImages){
    	List<Map<String, String>> images = new ArrayList<Map<String, String>>();
    	if(bigImages != null && bigImages.length >0){
    		int size = bigImages.length;
        	for(int i = 0 ; i < size ; i++){
        		Map<String, String> map = new HashMap<String, String>();
        		map.put(IMAGE_TYPE_BIG, bigImages[i]);
        		map.put(IMAGE_TYPE_RECOMEND, recomendImages[i]);
        		map.put(IMAGE_TYPE_SMALL, smallImages[i]);
        		images.add(map);
        	}
    	}
    	return images;
    }
    
    /**
     * 获取等比高和宽
     * @param sourceWidth 文件宽 
     * @param sourceHeight 文件高
     * @param gw 等比后宽
     * @param gh 等比后高
     * @return int[]
     */
    public static int[] getBili(int sourceWidth,int sourceHeight,int gw,int gh){
		int[] xy = new int[2];
		double dsw = Double.valueOf(new Integer(sourceWidth).toString());
		double dsh = Double.valueOf(new Integer(sourceHeight).toString());
		double dgw = Double.valueOf(new Integer(gw).toString());
		double dgh = Double.valueOf(new Integer(gh).toString());
		//宽高都大
		if(sourceWidth > gw && sourceHeight > gh){
			double wtemp = dgw/dsw;
			double htemp = dgh/dsh;
			//宽度系数 小于 高度系数   (系数越小越需要缩) 需要缩宽
			if(wtemp < htemp){
				xy[0] = new Double(dsw*wtemp).intValue();
				xy[1] = new Double(dsh*wtemp).intValue();
			}
			//高度系数 小于 宽度系数 (系数越小越需要缩) 需要缩高
			else{
				xy[0] = new Double(dsw*htemp).intValue();
				xy[1] = new Double(dsh*htemp).intValue();
			}
		}
		//宽大
		else if(sourceWidth > gw){
			double wtemp = dgw/dsw;
			xy[0] = new Double(dsw*wtemp).intValue();
			xy[1] = new Double(dsh*wtemp).intValue();
		}
		//高大
		else if(sourceHeight > gh){
			double htemp = dgh/dsh;
			xy[0] = new Double(dsw*htemp).intValue();
			xy[1] = new Double(dsh*htemp).intValue();
		}else{
			xy[0] = sourceWidth;
			xy[1] = sourceHeight;
		}
		return xy;
	}
    
    /**
     * 根据当前图片地址和图片类型获取其他图片类型的图片地址
     * @param imagePath 当前图片地址
     * @param imageType 当前图片类型
     * @param otherImageType 其他图片类型
     * @return String
     */
    public static String getOtherTypeImagePath(String imagePath, String imageType, String otherImageType){
    	if(CommonUtil.notEmpty(imagePath)){
    		imagePath = imagePath.replace(imageType, otherImageType);
    	}
    	return imagePath;
    }
}

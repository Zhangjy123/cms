package com.yofang.cms.utils;


import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * 处理字符串相关方法:
 * 1:判断字符串是否为空
 * 2:构造链接
 * 3:判断电话号码
 * 4:字符串截取
 * 5:字符串转码
 * 6:去除字符串中空格
 * 7:通过空格切分字符串集合
 * 8:随机生成字符串
 * @author Administrator
 *
 */
public class CommonUtil {

	/**
	 * 检查字符串是否为空
	 * @param str 字符串
	 * @return true:空 false:不为空
	 */
	public static boolean isEmpty(String str) {
		return (str == null) || (str.equals("")) || (str.equals("null")) || str.equals(" ") || str.equals("　");
	}

	/**
	 * 检查字符串是否不为空
	 * @param str 字符串
	 * @return true:不为空 false:空
	 */
	public static boolean notEmpty(String str) {
		return (str != null && !str.equals("") && !str.equals("null") && !str.equals(" ") && !str.equals("　"));
	}

	/**
	 * 检查超链接是否为合法链接
	 * @param link 超链接
	 * @return true:是 false:否
	 */
	public static boolean isFullUrl(String link) {
		if (link == null) {
			return false;
		}
		link = link.trim().toLowerCase();
		return link.startsWith("http://") || link.startsWith("https://") || link.startsWith("file://");
	}
	
	/**
	 * 通过已知超链接和一个只有部分链接构造全链接
	 * @param pageUrl 已知超链接
	 * @param path 部分链接
	 * @return String 全链接
	 */
	public static String makeUrl(String pageUrl, String path) {
		try {
			URL base = new URL(pageUrl);
			StringBuilder sb = new StringBuilder();
			sb.append(base.getProtocol());
			sb.append("://");
			sb.append(base.getHost());
			if(base.getPort() != 80 && base.getPort() > 0) sb.append(":" + base.getPort());
			if(path.charAt(0) != '/') sb.append('/');
			sb.append(path);
			return sb.toString();
		} catch (Exception e) {
		}
		
		return "";
	}
	
	/**
	 * 考虑各种链接格式，构造正确的url地址
	 * @param pageUrl 当前页url地址
	 * @param link 链接属性 
	 * @return String 构造正确的url地址
	 */
	public static String fullUrl(String pageUrl, String link) {
		if (link == null)
			return "";
		
		if (!isFullUrl(pageUrl)) {  //保证当前页链接是以http://开始
			pageUrl = "http://" + pageUrl;
		}
		
		if (isFullUrl(link)) { //link本来就是绝对地址
			return link;
		} else if (link != null && link.startsWith("?")) { //link是查询参数，"?name=lpf"
			int qindex = pageUrl.indexOf('?');
			if (qindex < 0) {  //pageUrl=http://www.test.com/user，返回"http://www.test.com/use?name=lpf"
				return pageUrl + link;
			} else {           //pageUrl=http://www.test.com/user?name=one，返回"http://www.test.com/use?name=lpf"
				return pageUrl.substring(0, qindex) + link;
			}
		} else if(link.startsWith("/")) { //link是从根目录开始的地址
			return makeUrl(pageUrl, link);
		} else if(link.startsWith("./")) { //link是从"./"开始的地址
			int lastSlashIndex = pageUrl.lastIndexOf('/');
			if(lastSlashIndex > 8) {
				return pageUrl.substring(0, lastSlashIndex) + link.substring(1);
			} else {
				return pageUrl + link.substring(1);
			}
		} else if(link.startsWith("../")) { //link是从"../"开始的地址，回退一级
			return makeAssembleUrl(pageUrl, link);
		} else {
			int lastSlashIndex = pageUrl.lastIndexOf('/');
			if(lastSlashIndex > 8) {
				return pageUrl.substring(0, lastSlashIndex) + "/" + link;
			} else {
				return pageUrl + "/" + link;
			}
		}
	}
	
	/**
	 * 通过相对路径构造绝对绝对路径
	 * @param base
	 * @param multiOmission
	 * @return
	 */
	private static String makeAssembleUrl(String base, String multiOmission) {
		String OMISSION = "../";
		String relative = multiOmission;
		while(relative.startsWith(OMISSION)) {
			base = getParentUrl(base);
			relative = relative.substring(OMISSION.length());
		}
		return base + relative;
	}
	
	/**
	 * 通过当前链接获取父链接
	 * @param url 当前链接
	 * @return String 父链接
	 */
	private static String getParentUrl(String url) {
		int lastSlashIndex = url.lastIndexOf('/');
		String rest = url.substring(0, lastSlashIndex);
		lastSlashIndex = rest.lastIndexOf('/');
		if(lastSlashIndex > 8) {
			return url.substring(0, lastSlashIndex+1);
		} else {
			return url + "/";
		}
	}
	
	/**
	 * 判断是否为手机号码
	 * @param mobile 手机号码
	 * @return true:是 false:否
	 */
	public static boolean isMobile(String mobile) {
        Pattern pattern = Pattern.compile("1[3-5|8]\\d{9}");
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }
	
	/**
	 * 判断是否为手机号码或固定电话号码
	 * @param mobile 手机号码或固定电话号码
	 * @return true:是 false:否
	 */
	public static boolean isMobileOrTel(String mobile) {
        if (mobile.startsWith("13") || mobile.startsWith("15") || mobile.startsWith("18"))
            return isMobile(mobile);
        Pattern pattern = Pattern.compile("(\\d{3,4}[-_－—]?)?\\d{7,8}([-_－—]?\\d{1,7})?");
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }
	
	/**
	 * 去除所有空格
	 * @param source
	 * @return
	 */
	public static String trim(String source) {
		if(null == source) return "";
		
		int start=0, end=source.length()-1;
		for(int i=0; i<source.length(); i++) {
			int code = source.charAt(i);
			if (code != ' ' && code != '　' && code != '\n' && code != '\r' && code != '\t') {
				start = i;
				break;
			}
		}
		
		for(int i=source.length()-1; i>=0; i--) {
			int code = source.charAt(i);
			if (code != ' ' && code != '　' && code != '\n' && code != '\r' && code != '\t' && code != 160) {
				end = i+1;
				break;
			}
		}
		
		if (start < end) {
			return source.substring(start, end);
		} else {
			return source;
		}
	}
	/**
	 * 提取原始字符串nodeValue中prefix以后的子串
	 * @param nodeValue
	 * @param prefix
	 * @return
	 */
	public static String stripAfter(String nodeValue, String prefix) {
		if (isEmpty(nodeValue))
			return "";

		String tmp = nodeValue.trim();
		int begin = 0;
		if (!isEmpty(prefix)) {
			int index = tmp.indexOf(prefix);
			if (index >= 0) {
				begin = index + prefix.length();
				return trim(tmp.substring(begin).trim());
			}
		}

		return trim(tmp);
	}
	/**
	 * 提取原始字符串nodeValue中suffix以前的子串
	 * 
	 * @param nodeValue
	 * @param prefix
	 * @return
	 */
	public static String stripBefore(String nodeValue, String suffix) {
		if (isEmpty(nodeValue))
			return "";

		String tmp = nodeValue.trim();
		int end = tmp.length();
		if (!isEmpty(suffix)) {
			int index = tmp.indexOf(suffix);
			if (index >= 0) {
				end = index;
				return trim(tmp.substring(0, end).trim());
			}
		}

		return trim(nodeValue);
	}
	/**
	 * 切分空格字符串
	 * @return
	 */
	public static String[] splitBlankStr(String source) {
		if (isEmpty(source))
			return null;
		if (source.indexOf("　") >= 0)
			source = source.replace("　", " ");
		source = trim(source);
		return source.split(" ");
	}
	
	/**
	 * 在字符串nodeValue中找"prefix"以后，"suffix"以前的字符串<br/>
	 * 如果prefix为空，则找end以前的字符串；如果suffix为空，则找before以后的字符串
	 * @param nodeValue
	 * @param prefix
	 * @param suffix
	 * @return
	 */
	public static String strip(String nodeValue, String prefix, String suffix) {
		if (isEmpty(nodeValue))
			return "";

		String tmp = nodeValue.trim();
		int begin = 0;
		int end = tmp.length();

		if (!isEmpty(prefix)) {
			int index = tmp.indexOf(prefix);
			if (index >= 0)
				begin = index + prefix.length();
			else
				return ""; // 不包含前缀
		}

		if (!isEmpty(suffix)) {
			int index = tmp.indexOf(suffix, begin);
			if (index > 0)
				end = index;
			else
				return ""; // 不包含后缀
		}

		return trim(end > begin ? tmp.substring(begin, end).trim() : tmp);
	}
	
	/**
	 * 截取字符串，从开始索引到结束索引
	 * @param nodeValue 字符串
	 * @param start 开始索引
	 * @param end 结束索引
	 * @param length 所需要限制长度
	 * @return
	 */
	public static String subStrip(String nodeValue, int start, int end){
		if(isEmpty(nodeValue)){
			return "";
		}else{
			if(nodeValue.length() > end){
				return nodeValue.substring(start, end);
			}else{
				return nodeValue;
			}
		}
	}
	
	/**
	 * 将字符转码为utf-8
	 * @param text
	 * @return
	 */
	public static String encodeUTF8(String text){
		if(notEmpty(text)){
			try {
				return URLEncoder.encode(text, "utf-8");
			} catch (UnsupportedEncodingException e) {
				return "";
			}
		}else{
			return "";
		}
	}
	
	/**
	 * 将字符串转码为utf-8中文
	 * @param text
	 * @return
	 */
	public static String decodeUTF8(String text){
		if(notEmpty(text)){
			try {
				return URLDecoder.decode(text, "utf-8");
			} catch (UnsupportedEncodingException e) {
				return "";
			}
		}else{
			return "";
		}
	}
	
	private static char[] numbers = new char[]{'0','1','2','3','4','5','6','7','8','9'};
	/**
     * 随机生成一个字符串
     * @param n 字符串的长度可以自定义
     * @return
     */
    public static String randNumber(int n) {
        char[] cr = new char[n];
        SecureRandom random = new SecureRandom();
        random.setSeed(System.nanoTime());
        for (int i=0;i<n;i++) {
          int x = (int)random.nextLong() % 10;
          if(x < 0) x = -x;
          cr[i] = numbers[x];
        }
        return (new String(cr));
    }
    
    /**
     * 通过正则表达式获取文本字符串
     * @param source 来源文本
     * @param regex 正则表达式
     * @param group 位置
     * @return String
     */
    public static String regexText(String source, String regex, int group) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(source);
		boolean b = matcher.find();
		if (b) {
			return matcher.group(group);
		}
		return null;
	}
}

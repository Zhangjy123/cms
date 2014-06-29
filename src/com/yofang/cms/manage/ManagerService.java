package com.yofang.cms.manage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.yofang.cms.cache.ManagerCache;
import com.yofang.cms.cache.ManagerLoginInfo;
import com.yofang.cms.model.User;
import com.yofang.cms.utils.CommonUtil;

/**
 * 用户登录管理，把用户信息保存在一个单例对象的一个属性hashtable中
 * @author Administrator
 *
 */
public class ManagerService {
	public static final String COOKIE_AUTO_LOGIN = "auto_login";
	
	
	public static final Log log = Logs.getLog(ManagerCache.class);
	/**
	 * 设置响应Cookie,同时将登录用户对象存储到缓存中
	 * @param manager 登录用户对象
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ManagerLoginInfo
	 */
	public static ManagerLoginInfo setManager(User user, HttpServletRequest request, HttpServletResponse response){
		setUname2Session(user, request);
		ManagerLoginInfo mli = new ManagerLoginInfo();
		mli.setSessionId(request.getSession().getId());
		mli.setUser(user);
		
		//缓存是hashtable，username是唯一的，同一个人会自动覆盖
		ManagerCache managerCache = ManagerCache.getInstance();
		managerCache.put(user.getMobile(), mli);
		log.info("userInfoCache size is " + managerCache.getTable().size());
		return mli;
	}
	
	/**
	 * 设置响应Cookie
	 * @param manager 登录用户对象
	 * @param response HttpServletResponse
	 */
//	private static void setManager(Manager manager, HttpServletResponse response){
//		response.addCookie(CookieUtil.getSimpleCookie("username", CommonUtil.encodeUTF8(manager.getUsername())));
//	}
	
	/**
	 * 设置响应Session
	 * @param manager
	 * @param request
	 */
	private static void setUname2Session(User user, HttpServletRequest request){
		request.getSession().setAttribute("username", CommonUtil.encodeUTF8(user.getMobile()));
	}
	
	/**
	 * 根据请求获取登录用户对象
	 * @param request HttpServletRequest
	 * @return Manager
	 */
//	public static Manager getManager(HttpServletRequest request){
//		String username = "";
//		Cookie[] cookies = request.getCookies();
//		if(cookies != null && cookies.length > 0){
//			for(Cookie c:cookies){
//				String cName = c.getName();
//				String cValue = CommonUtil.decodeUTF8(c.getValue());
//				if("username".equals(cName)){
//					username = cValue;
//				}
//			}
//		}
//		if(CommonUtil.isEmpty(username)) return null;
//		ManagerLoginInfo mli = ManagerCache.getInstance().get(username);
//		if(mli == null) return null;
//		String sessionId = mli.getSessionId();
//		if(!sessionId.equals(request.getSession().getId())) return null;
//		return mli.getManager();
//	}
	
	public static User getUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		if(CommonUtil.isEmpty(username)) return null;
		ManagerLoginInfo mli = ManagerCache.getInstance().get(username);
		if(mli == null) return null;
		String sessionId = mli.getSessionId();
		if(!sessionId.equals(request.getSession().getId())) {
			return null;
		}
			
		return mli.getUser();
	}
	
	/**
	 * 清空响应Cookie,同时清除缓存中的登录用户信息
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 */
//	public static void clearManager(HttpServletRequest request, HttpServletResponse response){
//		Manager manager = getManager(request);
//		if(manager != null){
//			ManagerCache.getInstance().remove(manager.getUsername());
//		}
//		request.getSession().invalidate();
//		response.addCookie(CookieUtil.getClearCookie("username"));
//	}
	
	/**
	 * 在ManagerCache缓存中清除一个用户的信息
	 */
	public static void clearUser(HttpServletRequest request){
		User user = getUser(request);
		if(user != null){
			ManagerCache.getInstance().remove(user.getMobile());
		}
		request.getSession().invalidate();
	}
	
	/**
	 * 系统登录检查
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 */
	public static boolean checkLogin(HttpServletRequest request, HttpServletResponse response){
		//检查是否登录
		User manager = ManagerService.getUser(request);
		if(manager == null){
			String base = request.getContextPath();
			String loginUrl = base + "/back/login?errorMsg=" + CommonUtil.encodeUTF8("请先登录");
			try {
				response.sendRedirect(loginUrl);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
	
	/**
	 * 从请求中的cookie获得登录用户的信息
	 * @param request
	 * @return
	 */
	public static String getCookieMobile(HttpServletRequest request){
		String flag = getCookie(request, ManagerService.COOKIE_AUTO_LOGIN);
		if(flag != null){
			return flag;
		}else{
			return null;
		}
	}
	
	
	
	/**添加cookie**/
	public static void addCookie(HttpServletResponse response,String key,String string) {
		response.addCookie(getSimpleCookie(key,encoder(string)));
		
	}
	/**删除cookie*/
	public static void removeCookie(HttpServletResponse response,
			String key) {
		response.addCookie(getSimpleCookie(key,encoder(null)));
		
	}
	
	/**
	 * 从cookie取值
	 * @param request
	 * @return
	 */
	public static String getCookie(HttpServletRequest request,String key){
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0){
			for(Cookie c:cookies){
				String cName = c.getName();
				String cValue = decoder(c.getValue());
				if(key.equals(cName)){
					return cValue;
				}
			}
		}
		return null;
	}
	/**解码*/
	private static String decoder(String str){
		if(str == null) return null;
		try {
			return URLDecoder.decode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/** Cookie保存时间*/
	private static final int MAXAGE = 60*60*24*365;
	/**设置cookie对象*/
	private static Cookie getSimpleCookie(String key,String value){
		Cookie c = new Cookie(key, value);
		c.setPath("/");
		c.setDomain("yofang.cn");
		//单位秒
		c.setMaxAge(MAXAGE);
		return c;
	}
	/**编码加密**/
	private static String encoder(String str){
		if(str == null) return null;
		try {
			return URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	
}

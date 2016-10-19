package com.wen.util;

import java.io.BufferedReader;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * web工具类.
 */
public class WebUtils {

	/** The Constant COOKIE_MLT. */
	private static final String COOKIE_MLT = "mlt_web";// web登录cookie
	/** The logger. */
	protected static Logger LOGGER = LoggerFactory.getLogger(WebUtils.class);;

	/**
	 * 获取登录成功的用户的身份令牌。.
	 *
	 * @param req the req
	 * @return 登录成功的用户的身份令牌
	 * @throws Exception the exception
	 */
	public static String readLoginToken(HttpServletRequest req) throws Exception {
		Cookie[] cookies = req.getCookies();
		if (cookies == null || cookies.length == 0) {
			return null;
		}
		String token = null;
		for (Cookie ck : cookies) {
			if (COOKIE_MLT.equals(ck.getName())) {
				token = ck.getValue();
				break;
			}
		}
		if (StringUtils.isBlank(token)) {
			token = req.getHeader(COOKIE_MLT);
		}
		return token;
	}

	/**
	 * 登录操作时将最新的token回写给客户端。.
	 *
	 * @param res the res
	 * @param token WebUtils用户登录成功后的身份令牌
	 * @param expireTime expireTime
	 * @throws Exception the exception
	 */
	public static void writeLoginToken(HttpServletResponse res, String token, int expireTime)
			throws Exception {

		if (StringUtils.isBlank(token)) {
			throw new IllegalArgumentException("[Login]illegal blank login token value,token:" + token);
		}
		Cookie loginCookie = new Cookie(COOKIE_MLT, token);
		loginCookie.setMaxAge(expireTime);// cookie有效期
		loginCookie.setDomain(".nong12.com");
		loginCookie.setPath("/");
		res.addCookie(loginCookie);
	}

	/**
	 * 退出操作时,删除系统loginToken
	 *
	 * @param resp
	 * @throws Exception the exception
	 */
	public static void deleteLoginToken(HttpServletResponse resp) throws Exception {
		Cookie cookie = new Cookie(COOKIE_MLT, null);
		cookie.setMaxAge(0);
		cookie.setDomain(".nong12.com");
		cookie.setPath("/");
		resp.addCookie(cookie);
	}

	/**
	 * 读取http请求的body。.
	 *
	 * @param br the br
	 * @return the string
	 * @throws Exception the exception
	 */
	public static String readRequestBody(BufferedReader br) throws Exception {
		StringBuilder sb = new StringBuilder();
		String str = null;
		while ((str = br.readLine()) != null) {
			sb.append(str);
		}
		return sb.toString();
	}

	/**
	 * 获取指定内容数据类型的http请求body
	 *
	 * @param req the req
	 * @param contentType the content type
	 * @return the string
	 * @throws Exception the exception
	 */
	public static String readRequestBody(HttpServletRequest req, String expectedContentType)
			throws Exception {
		if (StringUtils.isBlank(req.getContentType())
				|| !req.getContentType().startsWith(expectedContentType)) {
			return null;
		}
		if (req.getContentType().startsWith(expectedContentType)) {
			String body = readRequestBody(req.getReader());
			if (StringUtils.isNotBlank(body)) {
				return body.trim();
			}
		}
		return null;
	}

	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie cookies[] = request.getCookies();
		if (cookies == null || name == null) {
			return null;
		}
		Cookie cookie = null;
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals(name)) {
				cookie = cookies[i];
				if (request.getServerName().equals(cookie.getDomain())) {
					break;
				}
			}
		}
		return cookie;
	}

	public static void deleteCookie(HttpServletRequest request, HttpServletResponse response,
			String cookieName, Cookie... cookies) {
		if (cookies != null) {
			for (Cookie e : cookies) {
				if (cookieName.equals(e.getName())) {
					delCookie(request, response, e);
				}
			}
		}
	}

	public static void delCookie(HttpServletRequest request, HttpServletResponse response, Cookie cookie) {
		if (cookie != null) {
			String path = StringUtils.isBlank(request.getContextPath()) ? "/" : request.getContextPath();
			cookie.setPath(path);
			cookie.setValue("");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}

	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name,
			String value) {
		setCookie(request, response, name, value, 60 * 60 * 24 * 30);
	}

	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name,
			String value, int maxAge) {
		if (value == null) {
			value = "";
		}
		String path = StringUtils.isBlank(request.getContextPath()) ? "/" : request.getContextPath();
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		cookie.setPath(path);
		response.addCookie(cookie);
	}
}

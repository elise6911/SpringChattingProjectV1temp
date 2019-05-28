package com.kccistc.spring.interceptor;

import java.security.PrivateKey;

import javax.crypto.Cipher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	/*
	 * Controller로 요청이 들어가기 전!!에 수행된다.
	 * 
	 * : request, response, handler 등의 매개변수를 이용가능한데 우리가 아는 HttpServletRequest,
	 * HttpServletResponse,
	 * 
	 * 이고, 나머지 하나는 이 preHandle() 메서드를 수행하고 수행될 컨트롤러 메서드에 대한 정보를 담고 있는 handle
	 * 
	 * 이다.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();

		if (session.getAttribute(LOGIN) != null) {
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}
		/*
		 * String enuid = request.getParameter("userId"); String enupw =
		 * request.getParameter("password");
		 * 
		 * PrivateKey privateKey = (PrivateKey) session.getAttribute("_RSA_WEB_Key_");
		 * 
		 * // 복호화 String deuid = decryptRsa(privateKey, enuid); String deupw =
		 * decryptRsa(privateKey, enupw);
		 * 
		 * System.out.println("deuid: " + deuid); System.out.println("deupw: " + deupw);
		 * 
		 * session.setAttribute("deuid", deuid); session.setAttribute("deupw", deupw);
		 * 
		 * System.out.println(handler);
		 */
		return true;
	}

	/*
	 * 컨트롤러의 메서드의 처리가 끝나 return 되고 화면을 띄워주는 처리가 되기 직전에 이 메서드가 수행된다.
	 * 
	 * : ModelAndView 객체에 컨트롤러에서 전달해 온 Model 객체가 전달됨으로 컨트롤러에서 작업 후
	 * 
	 * : postHandle() 에서 작업할 것이 있다면 ModelAndView를 이용하면 된다.
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();

		Object userVO = modelMap.get("userVO");
		if (userVO != null) {
			logger.info("new login success");
			session.setAttribute(LOGIN, userVO);
			// response.sendRedirect("/");
			if (request.getParameter("useCookie") != null) {
				logger.info("remember me.......................");
				Cookie loginCookie = new Cookie("loginCookie", session.getId());

				loginCookie.setPath("/");
				loginCookie.setMaxAge(60 * 60 * 24 * 7);
				response.addCookie(loginCookie);

			}
			Object dest = session.getAttribute("dest");
			response.sendRedirect(dest != null ? (String) dest : "/");

		}
	}

	// 컨트롤러가 수행되고 화면처리까지 끝난 뒤 호출된다.
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	private String decryptRsa(PrivateKey privateKey, String securedValue) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		byte[] encryptedBytes = hexToByteArray(securedValue);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		String decryptedValue = new String(decryptedBytes, "utf-8"); // 문자 인코딩 주의.
		return decryptedValue;
	}

	public static byte[] hexToByteArray(String hex) {
		if (hex == null || hex.length() % 2 != 0) {
			return new byte[] {};
		}

		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < hex.length(); i += 2) {
			byte value = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
			bytes[(int) Math.floor(i / 2)] = value;
		}
		return bytes;
	}

}

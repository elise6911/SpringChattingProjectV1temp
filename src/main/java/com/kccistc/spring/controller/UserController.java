package com.kccistc.spring.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.kccistc.spring.domain.UserVO;
import com.kccistc.spring.dto.LoginDTO;
import com.kccistc.spring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService service;
	
	// 로그인 화면
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto ) {
		
	}
	// 로그인 처리
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpServletRequest req, Model model, RedirectAttributes rttr) throws Exception {
		HttpSession session = req.getSession();
		
		dto.setUserId((String)req.getParameter("userId"));
		dto.setPassword((String)req.getParameter("password"));
		session.setAttribute("user", dto.getUserId());
		session.setAttribute("user", dto.getPassword());
		UserVO vo = service.login(dto);

		
		if( vo == null) {
			session.setAttribute("user", null);
			rttr.addFlashAttribute("msg", "FAILURE");
			logger.info("login Fail ......" + rttr.getFlashAttributes());
			return;
		}
		
		if( dto.isUseCookie() ) {
			int amount = 60 * 60 * 24 * 7;
			Date sessionLimit = new Date(System.currentTimeMillis() + 1000 * amount);
			service.keepLogin(vo.getUserId(), session.getId(), sessionLimit);
			logger.info("login cookie save ......");
			
		}
		
		session.setAttribute("user", vo);
		model.addAttribute("userVO", vo);
		logger.info("login success ......");
		rttr.addFlashAttribute("msg", "SUCCESS");
	}
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		logger.info("logout.................................1");
		Object object = session.getAttribute("login");
		
		if(object != null ) {
			UserVO vo = (UserVO) object;
			logger.info("logout.................................2");
			session.removeAttribute("login");
			session.invalidate();
			logger.info("logout.................................3");
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			if(loginCookie != null) {
				logger.info("logout.................................4");
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(vo.getUserId(), session.getId(), new Date());
			}
		}

		logger.info("logout success ......");
	
		return "user/logout";
	}
	@ResponseBody
	@RequestMapping(value="/idCheck", method=RequestMethod.POST)
	public boolean postIdCheck(HttpServletRequest request)  throws Exception{
		logger.info("post idCheck");
		String userId = request.getParameter("userId");
		UserVO idCheck = service.idCheck(userId);
		
		boolean result = true;
		
		if( idCheck != null ) {
			result = false;
			logger.info(" idCheck false");
		}
		logger.info(" idCheck true");
		return result;
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signupGet()  throws Exception{
		logger.info("get signup");
		return "user/signup";
	}
	
	@RequestMapping(value="/signupPost", method=RequestMethod.POST)
	public String signupPost(UserVO vo, @RequestParam("datepicker") String birthday)  throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		vo.setBirthday(sdf.parse(birthday));
		System.out.println(vo.getBirthday());
		logger.info("post signup");
		service.insertUser(vo);
		logger.info("post signup success");
		return "user/login";
	}
}

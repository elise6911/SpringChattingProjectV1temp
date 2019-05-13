package com.kccistc.spring.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kccistc.spring.domain.UserVO;
import com.kccistc.spring.dto.LoginDTO;
import com.kccistc.spring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private UserService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto ) {
		
	}
	
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {
		UserVO vo = service.login(dto);
		
		if( vo == null)
			return;
		
		model.addAttribute("userVO", vo);
		
		if( dto.isUseCookie() ) {
			int amount = 60 * 60 * 24 * 7;
			Date sessionLimit = new Date(System.currentTimeMillis() + 1000 * amount);
			service.keepLogin(vo.getUserId(), session.getId(), sessionLimit);
		}
	}
	
	@RequestMapping(value="/loginProcess",method=RequestMethod.POST) 
	public String loginProcess(HttpSession session, LoginDTO dto) throws Exception{
		String returnURL = ""; 
		
		if ( session.getAttribute("login") != null ){ // 기존에 login이란 세션 값이 존재한다면 
			session.removeAttribute("login"); // 기존값을 제거해 준다. 
		}
		
		UserVO vo = service.login(dto);

		if ( vo != null ){ // 로그인 성공
			session.setAttribute("login", vo); // 세션에 login인이란 이름으로 UserVO 객체를 저장해 놈. 
			returnURL = "redirect:./"; // 로그인 성공시 게시글 목록페이지로 바로 이동하도록 하고 
		}else { // 로그인에 실패한 경우 
			returnURL = "redirect:/login"; // 로그인 폼으로 다시 가도록 함 
		}

		return returnURL; // 위에서 설정한 returnURL 을 반환해서 이동시킴 
	}

	
	/*
	 * // 로그인 폼을 띄우는 부분
	 * 
	 * @RequestMapping(value="/login",method=RequestMethod.GET) public String
	 * loginForm(){ return "login/loginForm"; // /login/loginForm.jsp를 띄움. }// end
	 * of loginForm
	 * 
	 * // 로그인 처리하는 부분
	 * 
	 * 
	 * 
	 * // 로그인이 성공하면 UserVO 객체를 반환함. 
	 * 
	 * // 로그아웃 하는 부분
	 * 
	 * @RequestMapping(value="/logout", method = RequestMethod.GET) public String
	 * logout(HttpServletRequest request, HttpServletResponse response, HttpSession
	 * session) throws Exception {
	 * 
	 * Object obj = session.getAttribute("login"); if( obj != null) { UserVO vo =
	 * (UserVO) obj; session.removeAttribute("login"); session.invalidate();
	 * 
	 * Cookie loginCookie = WebUtils.getCookie(request, "loginCookie"); if(
	 * loginCookie != null ) { loginCookie.setPath("/"); loginCookie.setMaxAge(0);
	 * response.addCookie(loginCookie); service.keepLogin(vo.getUserId(),
	 * session.getId(), new Date()); } } // session.removeAttribute("login"); // 하나씩
	 * 하려면 이렇게 해도 됨. return "user/logout";
	 * 
	 * }
	 */
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
}

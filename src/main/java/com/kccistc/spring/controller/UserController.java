package com.kccistc.spring.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kccistc.spring.domain.UserVO;
import com.kccistc.spring.dto.LoginDTO;
import com.kccistc.spring.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Inject
	private UserService service;
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto ) {
		
	}
	
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model ) throws Exception {
		UserVO vo = service.login(dto);
		
		if( vo == null)
			return;
		
		model.addAttribute("userVO", vo);
	}
	
	// 로그인 폼을 띄우는 부분
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginForm(){
		return "login/loginForm"; // /login/loginForm.jsp를 띄움.
	}// end of loginForm
	
	// 로그인 처리하는 부분
	@RequestMapping(value="/loginProcess",method=RequestMethod.POST)
	public String loginProcess(HttpSession session, LoginDTO dto) throws Exception{
		String returnURL = "";
		if ( session.getAttribute("login") != null ){
			// 기존에 login이란 세션 값이 존재한다면
			session.removeAttribute("login"); // 기존값을 제거해 준다.
		}
			
		// 로그인이 성공하면 UserVO 객체를 반환함.
		UserVO vo = service.login(dto);
		
		if ( vo != null ){ // 로그인 성공
			session.setAttribute("login", vo); // 세션에 login인이란 이름으로 UserVO 객체를 저장해 놈. 
			returnURL = "redirect:/chat/chatMain"; // 로그인 성공시 게시글 목록페이지로 바로 이동하도록 하고
		}else { // 로그인에 실패한 경우
			returnURL = "redirect:/login"; // 로그인 폼으로 다시 가도록 함
		}
		
		return returnURL; // 위에서 설정한 returnURL 을 반환해서 이동시킴
	}

	// 로그아웃 하는 부분
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 전체를 날려버림
		//			session.removeAttribute("login"); // 하나씩 하려면 이렇게 해도 됨.
		return "redirect:/login"; // 로그아웃 후 게시글 목록으로 이동하도록...함
	}
}

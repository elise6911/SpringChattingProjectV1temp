package com.kccistc.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kccistc.spring.service.ChatService;

@Controller
@RequestMapping("/chat")
public class ChatController {
	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	@Inject
	private ChatService service;
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String chat(Locale locale, Model model) {
		logger.info("채팅", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "chat/chat";
	}
	
	@RequestMapping(value = "/chatList", method = RequestMethod.GET)
	public String listAll(Model model) throws Exception {
		
		
		model.addAttribute("chatList", service.chatListAll());
		
		logger.info("All Chatting Room List Show ............");
		return "chat/chatRoomList";
	}
	
}

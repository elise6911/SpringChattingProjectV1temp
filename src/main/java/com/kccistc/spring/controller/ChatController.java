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

import com.kccistc.spring.domain.ChatRoomVO;
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
	
	@RequestMapping(value = "/chatRoomList", method = RequestMethod.GET)
	public String listAll(Model model) throws Exception {
		
		model.addAttribute("chatList", service.chatListAll());
		
		logger.info("All Chatting Room List Show ............");
		return "chat/chatRoomList";
	}
	
	@RequestMapping(value = "/createChat", method = RequestMethod.GET)
	public String createChatRoom(ChatRoomVO chat) throws Exception {
		
		logger.info("create chat room GET............");
		return "chat/createChatPost";
	}
	
	@RequestMapping(value = "/createChatPost", method = RequestMethod.POST)
	public String createChatRoomPost(ChatRoomVO chat) throws Exception {
		
		service.create(chat);
		logger.info("create chat room POST............");
		return "chat/chatRoomList";
	}
	
	@RequestMapping(value = "/chatTest", method = RequestMethod.POST)
	public String chatTestPost(Model model) throws Exception {
		
		logger.info("chat Test Post............");
		return "chat/chatTest";
	}
	
	@RequestMapping(value = "/chatTest", method = RequestMethod.GET)
	public String chatTestGet(Model model) throws Exception {
		
		logger.info("chat Test Get............");
		return "chat/chatTest";
	}
	
}

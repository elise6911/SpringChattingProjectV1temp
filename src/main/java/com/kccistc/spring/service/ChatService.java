package com.kccistc.spring.service;

import java.util.List;

import com.kccistc.spring.domain.ChatRoomVO;
import com.kccistc.spring.domain.MessageVO;

public interface ChatService {
	public void regist(ChatRoomVO chat) throws Exception;
	
	public ChatRoomVO read(Integer chatId) throws Exception;
	
	public void modify(ChatRoomVO chat) throws Exception;
	
	public void remove(Integer chatId) throws Exception;
	
	public List<ChatRoomVO> chatListAll() throws Exception;
	public void sendMsg(MessageVO msg) throws Exception;
	public void create(ChatRoomVO chat) throws Exception;
}

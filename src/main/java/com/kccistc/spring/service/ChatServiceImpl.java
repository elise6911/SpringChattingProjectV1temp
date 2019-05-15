package com.kccistc.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kccistc.spring.domain.ChatRoomVO;
import com.kccistc.spring.domain.MessageVO;
import com.kccistc.spring.persistence.BoardDAO;
import com.kccistc.spring.persistence.ChatDAO;

@Service
public class ChatServiceImpl implements ChatService{

	@Inject
	private ChatDAO dao;
	@Override
	public void regist(ChatRoomVO chat) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChatRoomVO read(Integer chatId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(ChatRoomVO chat) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Integer chatId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ChatRoomVO> chatListAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.chatListAll();
	}

	@Override
	public void sendMsg(MessageVO msg) throws Exception {
		// TODO Auto-generated method stub
		dao.send(msg);
	}

	@Override
	public void create(ChatRoomVO chat) throws Exception {
		// TODO Auto-generated method stub
		dao.createRoom(chat);
	}
	
}

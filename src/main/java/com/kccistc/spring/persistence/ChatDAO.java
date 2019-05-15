package com.kccistc.spring.persistence;

import java.util.List;

import com.kccistc.spring.domain.ChatRoomVO;
import com.kccistc.spring.domain.MessageVO;

public interface ChatDAO {
	public void createRoom(ChatRoomVO vo)throws Exception;
	public ChatRoomVO isRoom(ChatRoomVO roomVO)throws Exception;
	public void insertMessage(MessageVO vo)throws Exception;
	public String getPartner(ChatRoomVO vo)throws Exception;
	public String getProfile(String str)throws Exception;
	public String getName(String str)throws Exception;
	public List<MessageVO> getMessageList(String str)throws Exception;
	public List<ChatRoomVO> getRoomList(String str)throws Exception;
	public List<ChatRoomVO> getRoomList2(String str)throws Exception;
	public MessageVO getRecentMessage(String str)throws Exception;
	//public String isGetMessageList(String str)throws Exception;
	
	public String getTutorId(String str)throws Exception;
	public List<ChatRoomVO> getRoomListTutor(String str)throws Exception;
	public void updateReadTime(int class_id , String user_id , String TUTOR_USER_user_id)throws Exception;
	public void updateReadTimeTutor(int class_id , String user_id , String TUTOR_USER_user_id)throws Exception;
	
	public int getUnReadCount(String TUTOR_USER_user_id, int class_id, String user_id)throws Exception;
	public int getUnReadCountTutor(String TUTOR_USER_user_id, int class_id, String user_id)throws Exception;
	
	public int getAllCount(String str);
	public List<ChatRoomVO> chatListAll();
	public void send(MessageVO msg);
}

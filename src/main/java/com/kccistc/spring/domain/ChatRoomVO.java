package com.kccistc.spring.domain;

import java.util.Date;

public class ChatRoomVO {
	private String chatRoomId;
	private String userId;
	private Date openTime;
	public String getChatRoomId() {
		return chatRoomId;
	}
	public void setChatRoomId(String chatRoomId) {
		this.chatRoomId = chatRoomId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	@Override
	public String toString() {
		return "ChatRoomVO [chatRoomId=" + chatRoomId + ", userId=" + userId + ", openTime=" + openTime + "]";
	}
	
}

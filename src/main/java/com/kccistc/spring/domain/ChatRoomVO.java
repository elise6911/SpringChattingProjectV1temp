package com.kccistc.spring.domain;

import java.util.Date;

public class ChatRoomVO {
	private String chatRoomId;
	private String title;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "ChatRoomVO [chatRoomId=" + chatRoomId + ", title=" + title + ", userId=" + userId + ", openTime="
				+ openTime + "]";
	}
	
}

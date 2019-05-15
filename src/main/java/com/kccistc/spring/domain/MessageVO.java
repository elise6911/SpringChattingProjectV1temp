package com.kccistc.spring.domain;

import java.util.Date;

public class MessageVO {
	private String messageId;
	private String senderId;
	private String content;
	private Date sendTime;
	private String chatRoomId;
	
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getChatRoomId() {
		return chatRoomId;
	}

	public void setChatRoomId(String chatRoomId) {
		this.chatRoomId = chatRoomId;
	}

	
	@Override
	public String toString() {
		return "MessageVO [messageId=" + messageId + ", senderId=" + senderId + ", content=" + content + ", sendTime="
				+ sendTime + ", chatRoomId=" + chatRoomId + "]";
	}

	public static MessageVO convertMessage(String payload) {
		// TODO Auto-generated method stub
		return null;
	}
}

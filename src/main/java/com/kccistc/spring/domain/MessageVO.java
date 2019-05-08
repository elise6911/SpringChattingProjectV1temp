package com.kccistc.spring.domain;

import java.util.Date;

public class MessageVO {
	private String messageId;
	private String sender;
	private String receiver;
	private String content;
	private Date sendTime;
	private Date readTime;
	private String userId;
	private String opponentId;
	private String chattingRoomId;
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
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
	public Date getReadTime() {
		return readTime;
	}
	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOpponentId() {
		return opponentId;
	}
	public void setOpponentId(String opponentId) {
		this.opponentId = opponentId;
	}
	public String getChattingRoomId() {
		return chattingRoomId;
	}
	public void setChattingRoomId(String chattingRoomId) {
		this.chattingRoomId = chattingRoomId;
	}
	
	@Override
	public String toString() {
		return "MessageVO [messageId=" + messageId + ", sender=" + sender +
				", receiver=" + receiver + ", content=" + content +
				", sendTime=" + sendTime + ", readTime=" + readTime + 
				", userId=" + userId +", opponentId=" + opponentId +  
				", chattingRoomId=" + chattingRoomId + "]";
	}
	
	public static MessageVO convertMessage(String payload) {
		// TODO Auto-generated method stub
		return null;
	}
}

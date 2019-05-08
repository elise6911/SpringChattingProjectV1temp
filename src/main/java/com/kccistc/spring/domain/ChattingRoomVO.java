package com.kccistc.spring.domain;

public class ChattingRoomVO {
	private String chattingRoomId;
	private String userId;
	private String opponentId;
	public String getChattingRoomId() {
		return chattingRoomId;
	}
	public void setChattingRoomId(String chattingRoomId) {
		this.chattingRoomId = chattingRoomId;
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
	@Override
	public String toString() {
		return "ChattingRoomVO [chattingRoomId=" + chattingRoomId + 
				", userId=" + userId + 
				", opponentId=" + opponentId
				+ "]";
	}
	
}

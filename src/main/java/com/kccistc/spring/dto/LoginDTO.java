package com.kccistc.spring.dto;

public class LoginDTO {
	private String userId;
	private String userPassword;
	private boolean useCookie;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", userPassword=" + userPassword + ", useCookie=" + useCookie + "]";
	}
	
	
}

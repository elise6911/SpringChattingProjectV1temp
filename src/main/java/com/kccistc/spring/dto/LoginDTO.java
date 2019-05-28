package com.kccistc.spring.dto;

public class LoginDTO {
	private String userId;
	private String password;
	private boolean useCookie;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", password=" + password + ", useCookie=" + useCookie + "]";
	}

	
}

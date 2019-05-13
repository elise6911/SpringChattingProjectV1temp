package com.kccistc.spring.domain;

import java.util.Date;

public class UserVO {
	private String userId;
	private String password;
	private String name;
	private Date birthday;
	private String gender;
	private String emailId;
	private String emailDomain;
	private String SNS;
	public String getSNS() {
		return SNS;
	}
	public void setSNS(String sNS) {
		SNS = sNS;
	}

	private String phoneNumber;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", password=" + password + ", name=" + name + ", birthday=" + birthday
				+ ", gender=" + gender + ", emailId=" + emailId + ", emailDomain=" + emailDomain + ", SNS=" + SNS
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	
}

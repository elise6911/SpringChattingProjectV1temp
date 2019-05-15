package com.kccistc.spring.service;

import java.util.Date;

import com.kccistc.spring.domain.UserVO;
import com.kccistc.spring.dto.LoginDTO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
	public void keepLogin(String uid, String sessionId, Date next) throws Exception;
	public UserVO checkLoginBefore(String value);
	public UserVO idCheck(String userId);
	public void insertUser(UserVO vo);

}

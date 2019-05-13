package com.kccistc.spring.persistence;

import java.util.Date;

import com.kccistc.spring.domain.UserVO;
import com.kccistc.spring.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
	public void keepLogin(String uid, String sessionId, Date next);
	public UserVO checkUserWithSessionKey(String value);
	
	public UserVO idCheck(String userId);
	public void insertUser(UserVO vo);
}

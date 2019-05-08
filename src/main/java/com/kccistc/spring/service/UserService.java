package com.kccistc.spring.service;

import com.kccistc.spring.domain.UserVO;
import com.kccistc.spring.dto.LoginDTO;

public interface UserService {
	public UserVO login(LoginDTO dto) throws Exception;
	
}

package com.kccistc.spring.persistence;

import com.kccistc.spring.domain.UserVO;
import com.kccistc.spring.dto.LoginDTO;

public interface UserDAO {
	public UserVO login(LoginDTO dto) throws Exception;
}

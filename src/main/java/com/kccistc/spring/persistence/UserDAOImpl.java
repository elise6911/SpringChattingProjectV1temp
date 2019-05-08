package com.kccistc.spring.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.kccistc.spring.domain.UserVO;
import com.kccistc.spring.dto.LoginDTO;

public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace ="com.kccistc.spring.mapper.UserMapper";
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}

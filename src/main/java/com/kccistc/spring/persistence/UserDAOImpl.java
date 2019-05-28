package com.kccistc.spring.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kccistc.spring.domain.UserVO;
import com.kccistc.spring.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace ="com.kccistc.spring.mapper.userMapper";
	
	@Override
	public UserVO login(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace +".login", dto);
	}

	@Override
	public void keepLogin(String uid, String sessionId, Date next) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", uid);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next);
		
		session.update(namespace + ".keepLogin", paramMap);
	}

	@Override
	public UserVO checkUserWithSessionKey(String value) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".checkUserWithSessionKey", value);
	}

	@Override
	public UserVO idCheck(String userId) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".idCheck", userId);
	}

	@Override
	public void insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".insertUser", vo);
	}
	
}

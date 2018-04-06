package com.dal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dal.dao.UserDao;
import com.dal.dto.UserJoinDto;
import com.dal.dto.UserLoginDto;
import com.dal.vo.UserLoginVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userdao;

	public void joinUser(UserJoinDto userjoindto) {
		
		userdao.insertUserInfo(userjoindto);
		
	}

	public UserLoginVo login(UserLoginDto userlogindto) {
		
		return userdao.login(userlogindto);
	}

	public String idOverlap(String joinIdCheck) {
		
		return userdao.selectId(joinIdCheck);
	}
	
	
}

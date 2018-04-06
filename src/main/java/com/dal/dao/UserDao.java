package com.dal.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dal.dto.UserJoinDto;
import com.dal.dto.UserLoginDto;
import com.dal.vo.UserLoginVo;


@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlsession;

	public void insertUserInfo(UserJoinDto userjoindto) {
		
		sqlsession.insert("insertUserVo", userjoindto);
	}

	public UserLoginVo login(UserLoginDto userlogindto) {
		
		return sqlsession.selectOne("selectUserLoginVoByIdAndPw", userlogindto);
	}

	public String selectId(String joinIdCheck) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("selectId", joinIdCheck);
	}
	
	
}

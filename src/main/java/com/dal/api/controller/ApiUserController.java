package com.dal.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dal.dto.UserJoinDto;
import com.dal.dto.UserLoginDto;
import com.dal.service.UserService;

@Controller
@RequestMapping(value="/api/user")
public class ApiUserController {
	
	@Autowired
	private UserService userservice;
	
	@ResponseBody
	@RequestMapping(value="/login")
	public UserLoginDto login(@RequestBody UserLoginDto userlogindto) {
		System.out.println("/api/user/login");
		System.out.println(userlogindto.toString());
		userservice.login(userlogindto);
		
		return userlogindto;
	}
	
	@ResponseBody
	@RequestMapping(value="/join")
	public UserJoinDto join(@RequestBody UserJoinDto userjoindto) {
		System.out.println("/api/user/join");
		System.out.println(userjoindto);
		userservice.joinUser(userjoindto);
		
		return userjoindto;
	}
	
}

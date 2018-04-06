package com.dal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dal.dto.UserJoinDto;
import com.dal.dto.UserLoginDto;
import com.dal.service.UserService;
import com.dal.vo.UserLoginVo;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/loginform",method = RequestMethod.GET)
	public String loginform() {
		System.out.println("/user/loginform");
		return "user/loginForm";
	}
	
	@ResponseBody
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public UserLoginVo login(@ModelAttribute UserLoginDto userlogindto,
						HttpSession session) {
		System.out.println("/user/login");
		
		UserLoginVo userloginvo = userservice.login(userlogindto);
		session.setAttribute("authUser", userloginvo);
		System.out.println(userloginvo);
		return userloginvo;
	}
	
	@RequestMapping(value="/joinform",method = RequestMethod.GET)
	public String joinform() {
		System.out.println("/user/joinform");
		return "user/joinForm";
	}
	
	@ResponseBody
	@RequestMapping(value="/join",method = RequestMethod.POST)
	public String joinsuccess(@ModelAttribute UserJoinDto userjoindto,
								BindingResult bindingResult ) {
		System.out.println("/user/joinsuccess");
		System.out.println(userjoindto.toString());
		
		System.out.println(bindingResult.getErrorCount());
		if(bindingResult.getErrorCount() != 0) {
			System.out.println(bindingResult.toString());
			return "0";
		}else {
			System.out.println(bindingResult.toString());
			userservice.joinUser(userjoindto);
			
			return "1";
		}
		
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		System.out.println("/logout");
		session.removeAttribute("authUser");
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value="/overlap")
	public String joinIdCheck(@RequestParam("joinIdCheck") String joinIdCheck) {
		System.out.println("/overlap");
		System.out.println(joinIdCheck);
		
		String res = userservice.idOverlap(joinIdCheck);
		
		if(res == null) {
			return "possible";
		}else {
			return "impossible";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/userlist",method = RequestMethod.GET)
	public List<UserLoginVo> userlist() {
		List<UserLoginVo> userlist = new ArrayList<UserLoginVo>();
		
		for(int i  = 0; i < 10; i++) {
			String name = "testNickName";
			UserLoginVo temp = new UserLoginVo(name + i);
			userlist.add(temp);
		}
		
		return userlist; 
	}
	
}

package com.dal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dal.dto.WriteDto;
import com.dal.service.WriteService;

@Controller
public class WriteController {
	
	@Autowired
	private WriteService writeservice;
	
	@RequestMapping(value="/writeform",method = RequestMethod.GET)
	public String writeform() {
		System.out.println("/user/writeform");
		return "write/writeForm";
	}
	
	@RequestMapping(value="/write",method = RequestMethod.GET)
	public String write(@ModelAttribute WriteDto writedto) {
		System.out.println(writedto);
		writeservice.algorithm(writedto);
		return "redirect:/";
	}
}

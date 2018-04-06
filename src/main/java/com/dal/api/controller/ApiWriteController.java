package com.dal.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dal.dto.WriteDto;

@Controller
@RequestMapping(value="/api")
public class ApiWriteController {
	
	@ResponseBody
	@RequestMapping(value="/write")
	public WriteDto write(@RequestBody WriteDto writedto) {
		System.out.println("/write");
		System.out.println(writedto.toString());
		
		return writedto;
	}
}

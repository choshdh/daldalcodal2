package com.dal.service;

import org.springframework.stereotype.Service;

import com.dal.dto.WriteDto;

@Service
public class WriteService {

	
	public void algorithm(WriteDto writedto) {
		float individualCost = writedto.getCost()/writedto.getPeopleNo();
		System.out.println("individualCost:"+individualCost);
		
	}
	
}

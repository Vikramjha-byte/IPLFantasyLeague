package com.IPLFantasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.IPLFantasy.DTO.MatchStatsDto;
import com.IPLFantasy.services.admin.SystemService;


public class SystemController {
	
	@Autowired
	private SystemService service;
	
	@GetMapping("/home")
	public ResponseEntity<List<MatchStatsDto>> getMatchStats(){
		return new ResponseEntity<>(service.getTeamStats(),HttpStatus.OK);
	}	
}

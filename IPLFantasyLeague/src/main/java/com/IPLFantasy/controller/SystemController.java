package com.IPLFantasy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IPLFantasy.DTO.MatchStatsDto;
import com.IPLFantasy.services.SystemService;

@Controller
public class SystemController {
	
	@Autowired
	private SystemService service;
	
	@GetMapping("/home")
	public ResponseEntity<List<MatchStatsDto>> getMatchStats(){
		return new ResponseEntity<>(service.getTeamStats(),HttpStatus.OK);
	}	
}

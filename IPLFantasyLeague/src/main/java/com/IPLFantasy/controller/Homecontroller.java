package com.IPLFantasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homecontroller {

	@GetMapping("/")
	public String getHomePage() {
		return "index";
		
	}
}

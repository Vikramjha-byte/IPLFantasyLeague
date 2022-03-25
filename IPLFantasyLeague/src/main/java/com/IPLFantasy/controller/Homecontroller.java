package com.IPLFantasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homecontroller {

	@GetMapping("/")
	public String getHomePage() {
		return "index";
		
	}
	@GetMapping("/bidder")
	public String getBidderPage() {
		return "bidder";
		
	}
	@GetMapping("/admin")
	public String getAdminPage() {
		return "admin";
		
	}
	@GetMapping("/guest")
	public String getGuestPage() {
		return "guest";
		
	}
}

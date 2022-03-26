package com.IPLFantasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.IPLFantasy.entities.Admin;
import com.IPLFantasy.entities.Bidder;


@Controller

public class Homecontroller {

	@GetMapping("")
	public String getHomePage() {
		return "index";
		
	}
	@GetMapping("/loginbidder")
	public String getBidderPage(Model model) {
		System.out.println("opening bidder page");
		model.addAttribute("loginData",new Bidder());
		return "bidder";
		
	}
	
	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("bidder",new Bidder());
		return "register";
	}
	@GetMapping("/aregister")
	public String showAdminSignUpForm(Model model) {
		model.addAttribute("admin",new Admin());
		return "admin_register";
	}
	@GetMapping("/login")
	public String getAdminPage() {
		return "admin";
		
	}
	@GetMapping("/guest")
	public String getGuestPage() {
		return "redirect:home";
		
	}
}

package com.IPLFantasy.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IPLFantasy.entities.Admin;
import com.IPLFantasy.entities.Team;
import com.IPLFantasy.entities.Tournaments;
import com.IPLFantasy.exceptions.IncorrectPasswordException;
import com.IPLFantasy.exceptions.UsernameNotFoundException;
import com.IPLFantasy.services.admin.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	public ResponseEntity<String> loginAdmin(@RequestBody Admin login) 
			throws UsernameNotFoundException ,IncorrectPasswordException{
			adminService.loginAdmin(login);
			return new ResponseEntity<String>("logged in",HttpStatus.OK);
		}
	

	@PostMapping("/createTournament")
	public void createTournament(@RequestBody Tournaments tournaments) {

		adminService.createTournaments(tournaments);

	}
	@PostMapping("/createTeams")
	public void createTeams(@RequestBody Team team) {
		adminService.createTeams(team);
	}

}

package com.IPLFantasy.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.IPLFantasy.entities.Admin;
import com.IPLFantasy.entities.MatchSchedule;

import com.IPLFantasy.entities.TeamDetails;
import com.IPLFantasy.entities.TeamPoints;
import com.IPLFantasy.entities.Tournaments;
import com.IPLFantasy.exceptions.IncorrectPasswordException;
import com.IPLFantasy.exceptions.UsernameNotFoundException;
import com.IPLFantasy.services.admin.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/login")
	public ResponseEntity<String> loginAdmin(@RequestParam int userId, String password)
			throws UsernameNotFoundException, IncorrectPasswordException {
		adminService.loginAdmin(userId,password);
		return new ResponseEntity<String>("logged in", HttpStatus.OK);
	}

	@GetMapping("/details")
	public List<Admin> getAdmindetails() {
		return adminService.getAdmindetails();
	}

	@PostMapping("/createTournament")
	public ResponseEntity<String> createTournament(@RequestBody Tournaments tournaments) {

		adminService.createTournaments(tournaments);
		return new ResponseEntity<String>("Tournament Created Successfully!!!", HttpStatus.OK);
	}

	@PostMapping("/createTeams")
	public ResponseEntity<String> createTeams(@RequestBody TeamDetails team) {
		adminService.createTeams(team);
		return new ResponseEntity<String>("Team Created Successfully!!!", HttpStatus.OK);
	}

	@PostMapping("/match-schedule")
	public ResponseEntity<String> schedulematch(@RequestBody MatchSchedule match) {
		adminService.scheduleMatch(match);
		return new ResponseEntity<String>("Match Scheduled Successfully!!!", HttpStatus.OK);
	}

	@PutMapping("/match-reschedule/{match_id}")
	public ResponseEntity<String> reschedulematch(@PathVariable Integer match_id) {
		adminService.rescheduleMatch(match_id);
		return new ResponseEntity<String>("Match Rescheduled Successfully!!!", HttpStatus.OK);
	}

	@PutMapping("/update-team/{t_id}")
	public ResponseEntity<String> updateTeams(@PathVariable Integer t_id) {
		adminService.updateTeam(t_id);
		return new ResponseEntity<String>("Team updated Successfully!!!", HttpStatus.OK);
	}

	@DeleteMapping("/update-team/{match_id}")
	public ResponseEntity<String> CancelMatch(@PathVariable Integer match_id) {
		adminService.cancelMatch(match_id);
		return new ResponseEntity<>("Match canceled!!!", HttpStatus.OK);
	}

	@PostMapping("/result")
	public ResponseEntity<String> matchResult(@RequestBody TeamPoints points) {
		adminService.matchResult(points);
		return new ResponseEntity<String>("Result Added Successfully!!!", HttpStatus.OK);
	}
	@GetMapping("/biddings")
	public ResponseEntity<?> getBiddings(){
		return new ResponseEntity<>(adminService.getBiddings(),HttpStatus.OK);
	}
}

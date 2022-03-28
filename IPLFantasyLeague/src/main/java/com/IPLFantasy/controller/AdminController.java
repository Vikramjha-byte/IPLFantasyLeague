package com.IPLFantasy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.IPLFantasy.entities.Admin;
import com.IPLFantasy.entities.Bid;
import com.IPLFantasy.entities.Bidder;
import com.IPLFantasy.entities.Match;
import com.IPLFantasy.entities.MatchSchedule;

import com.IPLFantasy.entities.TeamDetails;
import com.IPLFantasy.entities.TeamPoints;
import com.IPLFantasy.entities.Tournaments;
import com.IPLFantasy.exceptions.IncorrectPasswordException;
import com.IPLFantasy.exceptions.UsernameNotFoundException;
import com.IPLFantasy.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@PostMapping("/register")
	public String registerBidder(Admin admin) {
		
		adminService.registerBidder(admin);

		return "admin_register_success";
	}

	@PostMapping("/login")
	public ModelAndView loginAdmin(Admin admin, Model model, HttpSession httpSession )
			throws UsernameNotFoundException, IncorrectPasswordException {
		
		
		Admin loginAdmin = adminService.loginAdmin(admin);
		ModelAndView modelAndView ;
		if (loginAdmin == null) {
			System.out.println("Invalid Details,Please try again!!");
			modelAndView=new ModelAndView("redirect:login");
		} else {
		httpSession.setAttribute("currentuser", loginAdmin);
		modelAndView=new ModelAndView("redirect:dashboard","msg",new ResponseEntity<String>("logged in",HttpStatus.OK));
		}
		return modelAndView;
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		session.invalidate();	    
		return "redirect:/admin";
	}
	@GetMapping("/dashboard")
	public String getBidderDashboard(Model model,HttpSession session) {
		
		Admin admin = (Admin) session.getAttribute("currentuser");
		if(admin==null) {
			
			return "login";
		}
		model.addAttribute("user", admin);
//		System.out.println(model.getAttribute("msg"));
		List<Admin> admins= adminService.getAdmindetails();
		model.addAttribute("adminlist",admins);
		List<TeamDetails> teams = adminService.getTeams();
		model.addAttribute("teamlist",teams);
		List<Bid> biddings = adminService.getBiddings();
		model.addAttribute("lstbid",biddings);
		List<MatchSchedule> matchSchedule = adminService.getMatchSchedule();
		model.addAttribute("mtchschdl",matchSchedule);
		List<Match> matchsDetails = adminService.getMatchsDetails();
		model.addAttribute("mtchdtls",matchsDetails);
		return "adminpage";
	}
	
	@GetMapping("/details")
	public List<Admin> getAdmindetails() {
		return adminService.getAdmindetails();
	}

	@PostMapping("/createTournament")
	public ResponseEntity<String> createTournament(Tournaments tournaments) {
		
		adminService.createTournaments(tournaments);
		return new ResponseEntity<String>("Tournament Created Successfully!!!", HttpStatus.OK);
	}
	

	@PostMapping("/createTeams")
	public String createTeams( TeamDetails team) {
		adminService.createTeams(team);
	ResponseEntity<String> entity= new 	ResponseEntity<String>("Team Created Successfully!!!", HttpStatus.OK);
		
	return "redirect:dashboard#teams";
	}
	
	@PostMapping("/createMatch")
	public String createMatches( Match match) {
		adminService.createMatches(match);
	ResponseEntity<String> entity= new 	ResponseEntity<String>("Match Created Successfully!!!", HttpStatus.OK);
		
	return "redirect:dashboard#teams";
	}

	@PostMapping("/match-schedule")
	public String schedulematch( MatchSchedule match) {
		
		adminService.scheduleMatch(match);
		
		ResponseEntity<String> entity=new  ResponseEntity<String>("Match Scheduled Successfully!!!", HttpStatus.OK);
	return "redirect:dashboard#smatch";
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

	@GetMapping("/update-match/{match_id}")
	public ResponseEntity<String> CancelMatch(@RequestParam("match_id") Integer match_id) {
		adminService.cancelMatch(match_id);
		return new ResponseEntity<>("Match canceled!!!", HttpStatus.OK);
	}
	@GetMapping("/updatematch/{match_id}/{winner}")
	public ResponseEntity<String> UpdateMatch(@RequestParam("match_id") Integer match_id, String winner) {
		adminService.updateMatch(match_id,winner);
		return new ResponseEntity<>("Match canceled!!!", HttpStatus.OK);
	}
	@PostMapping("/result")
	public ResponseEntity<String> matchResult( TeamPoints points) {
		adminService.matchResult(points);
		return new ResponseEntity<String>("Result Added Successfully!!!", HttpStatus.OK);
	}
	@GetMapping("/getBids")
	public String getBiddings(Model model){
		List<Bid> biddings = adminService.getBiddings();
		System.out.println(biddings);
		model.addAttribute("lstbid",biddings);
		return "redirect:dashboard";
	}
}

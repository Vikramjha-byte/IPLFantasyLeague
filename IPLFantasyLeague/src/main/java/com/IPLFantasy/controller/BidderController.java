package com.IPLFantasy.controller;

import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.IPLFantasy.DTO.BidDTO;
import com.IPLFantasy.DTO.ScheduleDTO;
import com.IPLFantasy.entities.Bidder;
import com.IPLFantasy.exceptions.IncorrectPasswordException;
import com.IPLFantasy.exceptions.LoginException;
import com.IPLFantasy.exceptions.RegistrationException;
import com.IPLFantasy.exceptions.UsernameNotFoundException;
import com.IPLFantasy.services.BidderService;

@Controller
@RequestMapping("/bidder")
@Scope("session")
public class BidderController {

	@Autowired
	private BidderService service;

	@PostMapping("/register")
	public String registerBidder(Bidder bidder) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedString = encoder.encode(bidder.getPassword());
		bidder.setPassword(encodedString);
		service.registerBidder(bidder);

		return "register_success";
	}

	@PostMapping("/login")
	public ModelAndView loginBidder(Bidder login) throws UsernameNotFoundException, IncorrectPasswordException {
		service.loginBidder(login);

		return new ModelAndView("bidderPage", "msg", new ResponseEntity<String>("logged in", HttpStatus.OK));

	}

	@GetMapping("/list_bidders")
	public String viewBiddersList(Model model) {
		List<Bidder> listBidders = service.getBidders();
		model.addAttribute("listBidders", listBidders);
		return "Bidders";
	}

	@GetMapping("/matches-schedule")
	public ResponseEntity<List<ScheduleDTO>> getMatchSchedule() {
		return new ResponseEntity<>(service.getScheduled(), HttpStatus.OK);
	}

	@PostMapping("/bid")
	public ResponseEntity<String> userBid(@RequestBody BidDTO biddto) {
		service.userBid(biddto);
		return new ResponseEntity<>("BID Successful!!", HttpStatus.OK);
	}

	@GetMapping("/match_details")
	public ResponseEntity<?> getMatchDetails() {
		return new ResponseEntity<>(service.getMatchsDetails(), HttpStatus.OK);
	}

	@DeleteMapping("/cancle_bid/{b_id}")
	public ResponseEntity<String> cancelBid(@PathVariable Integer b_id) {
		service.cancelBid(b_id);
		return new ResponseEntity<String>("Bid Canceld!!", HttpStatus.OK);
	}

	@GetMapping("/view_leader_board_team")
	public ResponseEntity<?> getLeaderBoard() {
		return new ResponseEntity<>(service.getTeamPoints(), HttpStatus.OK);
	}

	@GetMapping("/view_leader_board_bidder")
	public ResponseEntity<?> getBidderLeaderBoard() {
		return new ResponseEntity<>(service.getBidderBoard(), HttpStatus.OK);
	}
}

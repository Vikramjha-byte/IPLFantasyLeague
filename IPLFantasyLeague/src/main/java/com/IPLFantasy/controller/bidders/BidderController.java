package com.IPLFantasy.controller.bidders;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.IPLFantasy.DTO.BidDTO;
import com.IPLFantasy.DTO.ScheduleDTO;
import com.IPLFantasy.entities.Bidder;
import com.IPLFantasy.exceptions.LoginException;
import com.IPLFantasy.exceptions.RegistrationException;
import com.IPLFantasy.services.bidders.BidderService;


@RestController
@RequestMapping("/bidder")
@Scope("session")
public class BidderController {

	@Autowired
	private BidderService service;

	@PostMapping("/register")
	public String registerBidder(@RequestBody Bidder bidder) {
		String msg = "";
		try {
			if (bidder.getUserName() != null) {
				if (bidder.getPassword() != null) {
					if (bidder.getName() != null) {
						if (bidder.getEmail() != null) {
							if (bidder.getEmail().matches("[a-z0-9\\._]+@[a-z]+\\.[a-z]{2,3}")) {
								if (bidder.getPhoneNo() != null) {
									Random random = new Random();
									final int value = random.nextInt(1000000) + 1;
									bidder.setBidderId(2022 + value);
									Bidder registerBidder = service.registerBidder(bidder);
									if (registerBidder != null) {
										msg = "Registered Successfully";
									} else {
										throw new RegistrationException(
												"Ohh No! you are not registered yet. please try again");
									}
								} else {
									throw new RegistrationException("phone no. can't be blank");
								}
							} else {
								throw new RegistrationException("You have entered invalid email");
							}
						} else {
							throw new RegistrationException("Email can't be blank");
						}
					} else {
						throw new RegistrationException("Name can't be blank");
					}
				} else {
					throw new RegistrationException("Password can't be blank");
				}
			} else {
				throw new RegistrationException("username can't be blank");
			}
		} catch (RegistrationException e) {
			msg = e.getMessage();
		}
		// bidder.getLeaderboard().setBidderId(bidder.getBidderId());
		return msg;
	}

	@PostMapping("/login")
	public String loginBidder(@RequestParam int userId, String password) {

		String msg = "";
		try {
			if (userId != 0 & password != null) {
				Bidder bidder = service.getBidder(userId, password);
				if (bidder != null) {
					msg = "Login Successfully";
				} else {
					throw new LoginException("invalid username and password");
				}

			} else {
				throw new LoginException("Username and password can’t be left blank.");
			}
		} catch (LoginException e) {
			msg = e.getMessage();
		}
		return msg;

	}
	@GetMapping("/matches-schedule")
	public ResponseEntity<List<ScheduleDTO>> getMatchSchedule()
	{
		return new ResponseEntity<>(service.getScheduled(),HttpStatus.OK);
	}
	
	@PostMapping("/bid")
	public ResponseEntity<String> userBid(@RequestBody BidDTO biddto){
		service.userBid(biddto);
		return new ResponseEntity<>("BID Successful!!",HttpStatus.OK);
	}

	@GetMapping("/match_details")
	public ResponseEntity<?> getMatchDetails(){
		return new ResponseEntity<>(service.getMatchsDetails(),HttpStatus.OK);
	}
	
	@DeleteMapping("/cancle_bid/{b_id}")
	public ResponseEntity<String> cancelBid(@PathVariable Integer b_id) {
		service.cancelBid(b_id);
		return new ResponseEntity<String>("Bid Canceld!!",HttpStatus.OK);
	}
	
	@GetMapping("/view_leader_board_team")
	public ResponseEntity<?> getLeaderBoard(){
		return new ResponseEntity<>(service.getTeamPoints(),HttpStatus.OK);	
	}
	
	@GetMapping("/view_leader_board_bidder")
	public ResponseEntity<?> getBidderLeaderBoard(){
		return new ResponseEntity<>(service.getBidderBoard(),HttpStatus.OK);	
	}
}


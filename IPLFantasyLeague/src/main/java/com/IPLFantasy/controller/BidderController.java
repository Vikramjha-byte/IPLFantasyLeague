package com.IPLFantasy.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.IPLFantasy.DTO.BidDTO;
import com.IPLFantasy.DTO.ScheduleDTO;
import com.IPLFantasy.entities.Bid;
import com.IPLFantasy.entities.Bidder;
import com.IPLFantasy.entities.Leaderboard;
import com.IPLFantasy.entities.Match;
import com.IPLFantasy.entities.TeamDetails;
import com.IPLFantasy.entities.TeamPoints;
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
	public ModelAndView loginBidder(Bidder login, HttpSession httpSession)
			throws UsernameNotFoundException, IncorrectPasswordException {

		Bidder loginBidder = service.loginBidder(login);
		ModelAndView modelAndView;
		if (loginBidder == null) {
			System.out.println("Invalid Details,Please try again!!");
			modelAndView = new ModelAndView("redirect:login");
		} else {
			httpSession.setAttribute("currentuser", loginBidder);
			modelAndView = new ModelAndView("redirect:dashboard", "msg",
					new ResponseEntity<String>("logged in", HttpStatus.OK));
		}
		return modelAndView;

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		session.invalidate();
		return "redirect:/bidder";
	}

	@GetMapping("/dashboard")
	public String getBidderDashboard(Model model, HttpSession session) {
		Bidder bidder = (Bidder) session.getAttribute("currentuser");
		if (bidder == null) {

			return "login";
		}
		model.addAttribute("user", bidder);
		System.out.println(model.getAttribute("msg"));
		Bidder listBidders = service.getBidderbyuserId(bidder.getBidderId());
		model.addAttribute("bidderlist", listBidders);
		List<ScheduleDTO> scheduled = service.getScheduled();
		List<TeamPoints> teamPoints = service.getTeamPoints();
		List<TeamPoints> collect = teamPoints.stream().sorted(Comparator.comparingInt(TeamPoints::getPoints).reversed())
				.collect(Collectors.toList());
		List<Match> matchsDetails = service.getMatchsDetails();
		List<BidDTO> bid = service.getBidbyuserId(bidder.getBidderId());

		model.addAttribute("matchlist", scheduled);
		List<String> playerlist = new ArrayList<>();
		List<String> teamlist = new ArrayList<>();

		for (ScheduleDTO x : scheduled) {
			String team_players = x.getTeamdetails().getTeam_players();
			String team_name = x.getTeamdetails().getTeam_name();
			String team_name2 = x.getTeamdetails2().getTeam_name();

			StringTokenizer stringTokenizer = new StringTokenizer(team_players, ",");

			while (stringTokenizer.hasMoreTokens()) {
				playerlist.add(stringTokenizer.nextToken());
			}
			if (!teamlist.contains(team_name)) {
				teamlist.add(team_name);
			}
			if (!teamlist.contains(team_name2)) {
				teamlist.add(team_name2);
			}

		}

		model.addAttribute("plyrlist", playerlist);
		model.addAttribute("teamlist", teamlist);
		model.addAttribute("mtchdtls", matchsDetails);
		model.addAttribute("bid", bid);
		model.addAttribute("teampoints", collect);
		return "bidderpage";
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
	public ResponseEntity<String> userBid(Bid bid, HttpSession httpSession) {
		int matchid = bid.getMatch_id();
		Bidder bidder = (Bidder) httpSession.getAttribute("currentuser");
		List<BidDTO> bidbyuserId = service.getBidbyuserId(bidder.getBidderId());
		Match matchsDetails = service.getMatchsDetailsbymatchid(matchid);
		ResponseEntity<String> responseEntity;
		if (matchsDetails.getStatus().equals("Not yet started")) {
			bid.setResult("Pending");
			service.userBid(bid);
			responseEntity = new ResponseEntity<>("BID Successful!!", HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<>("Time UP!!", HttpStatus.BAD_REQUEST);
		}

		return responseEntity;
	}

	@GetMapping("/match_details")
	public ResponseEntity<?> getMatchDetails() {
		return new ResponseEntity<>(service.getMatchsDetails(), HttpStatus.OK);
	}

	@GetMapping("/cancel_bid/{b_id}")
	public ResponseEntity<String> cancelBid(@PathVariable Integer b_id) {
		Bid getbyid = service.getbyid(b_id);
		ResponseEntity<String> entity;
		Integer match_id = getbyid.getMatch_id();
		Match match = service.getMatchsDetailsbymatchid(match_id);
		if (match.getStatus().equals("Not yet started")) {
			service.cancelBid(b_id);
			entity = new ResponseEntity<String>("Bid Cancelled!!", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>("Time Up!!", HttpStatus.OK);
		}
		return entity;
	}

	@GetMapping("/view_leader_board_team")
	public ResponseEntity<?> getLeaderBoard() {
		return new ResponseEntity<>(service.getTeamPoints(), HttpStatus.OK);
	}

	@GetMapping("/view_leader_board_bidder")
	public String getBidderLeaderBoard(HttpSession session, Model model) {
		List<Leaderboard> bidderBoard = service.getBidderBoard();

		Bidder bidder = (Bidder) session.getAttribute("currentuser");

		Leaderboard leaderboard = new Leaderboard();
		if (bidderBoard != null) {
			for (Leaderboard lboard : bidderBoard) {
				if (lboard.getBidder_name().equals(bidder.getName())) {
					int lid = lboard.getlId();
					leaderboard.setBidder_name(bidder.getName());
					int bid_participated = (int) service.getBidbyuserId(bidder.getBidderId()).stream().count();
					leaderboard.setBids_participated(bid_participated);
					int bidWon = (int) service.getBidbyuserId(bidder.getBidderId()).stream()
							.filter(x -> x.getResult().equals("Won")).count();
					leaderboard.setBids_won(bidWon);
					double percent = ((double) bidWon / (double) bid_participated);
					leaderboard.setPercentile(percent);
					service.updateleaderboardbyid(lid, leaderboard);
					List<Leaderboard> leaders = service.getLeaders();
					model.addAttribute("leader", leaders);
					return "view_leader_board_bidder";

				}
			}
		}
		leaderboard.setBidder_name(bidder.getName());
		int bid_participated = (int) service.getBidbyuserId(bidder.getBidderId()).stream().count();
		leaderboard.setBids_participated(bid_participated);
		int bidWon = (int) service.getBidbyuserId(bidder.getBidderId()).stream()
				.filter(x -> x.getResult().equals("Won")).count();
		leaderboard.setBids_won(bidWon);
		double percent = ((double) bidWon / (double) bid_participated);
		leaderboard.setPercentile(percent);
		service.saveLeaderboard(leaderboard);

		List<Leaderboard> leaders = service.getLeaders();
		model.addAttribute("leader", leaders);
		return "view_leader_board_bidder";
	}
}

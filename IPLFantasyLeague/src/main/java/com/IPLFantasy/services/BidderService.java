package com.IPLFantasy.services;

import java.util.List;

import com.IPLFantasy.DTO.BidDTO;
import com.IPLFantasy.DTO.ScheduleDTO;
import com.IPLFantasy.dao.BidDao;
import com.IPLFantasy.entities.Bid;
import com.IPLFantasy.entities.Bidder;
import com.IPLFantasy.entities.Leaderboard;
import com.IPLFantasy.entities.Match;
import com.IPLFantasy.entities.TeamPoints;
import com.IPLFantasy.exceptions.IncorrectPasswordException;
import com.IPLFantasy.exceptions.UserNameAlreadyExistException;
import com.IPLFantasy.exceptions.UsernameNotFoundException;

public interface BidderService {

	public Bidder registerBidder(Bidder bidder);

	public List<ScheduleDTO> getScheduled();

	public void userBid(Bid bid);

	public List<Match> getMatchsDetails();

	public void cancelBid(Integer b_id);

	public List<TeamPoints> getTeamPoints();

	public List<Leaderboard> getBidderBoard();

	public List<Bidder> getBidders();

	public Bidder loginBidder(Bidder login) throws UsernameNotFoundException, IncorrectPasswordException;

	public List<BidDTO> getBid();

	public Bidder getBidderbyuserId(int bidderId);

	public List<BidDTO> getBidbyuserId(int bidderId);

	public Match getMatchsDetailsbymatchid(int matchid);


	public Bid getbyid(Integer b_id);

	public void saveLeaderboard(Leaderboard leaderboard);

	public void updateleaderboardbyid(int lid, Leaderboard leaderboard);

	public List<Leaderboard> getLeaders();

	

}

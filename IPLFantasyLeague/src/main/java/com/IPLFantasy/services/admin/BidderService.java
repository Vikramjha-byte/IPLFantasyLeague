package com.IPLFantasy.services.admin;

import java.util.List;

import com.IPLFantasy.DTO.BidDTO;
import com.IPLFantasy.DTO.ScheduleDTO;
import com.IPLFantasy.entities.Bidder;
import com.IPLFantasy.entities.Leaderboard;
import com.IPLFantasy.entities.Match;
import com.IPLFantasy.entities.TeamPoints;






public interface BidderService {

	

	public Bidder registerBidder(Bidder bidder) ;

	public Bidder getBidder(int username,String password) ;
	
	public List<ScheduleDTO> getScheduled();

	public void userBid(BidDTO biddto);

	public List<Match> getMatchsDetails();

	public void cancelBid(Integer b_id);

	public List<TeamPoints> getTeamPoints();

	public List<Leaderboard> getBidderBoard();

	

}

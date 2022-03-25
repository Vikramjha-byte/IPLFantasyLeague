package com.IPLFantasy.services.bidders;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IPLFantasy.DTO.BidDTO;
import com.IPLFantasy.DTO.ScheduleDTO;
import com.IPLFantasy.dao.admin.BidDao;
import com.IPLFantasy.dao.admin.MatchDao;
import com.IPLFantasy.dao.admin.MatchScheduleDAO;
import com.IPLFantasy.dao.admin.TeamPointsDao;
import com.IPLFantasy.dao.bidders.BidderDao;
import com.IPLFantasy.dao.bidders.LeaderboardDao;
import com.IPLFantasy.entities.Bidder;
import com.IPLFantasy.entities.Leaderboard;
import com.IPLFantasy.entities.Match;
import com.IPLFantasy.entities.TeamPoints;
import com.IPLFantasy.utils.BidUtils;
import com.IPLFantasy.utils.MatchScheduleUtils;

@Service
public class BidderserviceImpl implements BidderService {

	@Autowired
	private BidderDao dao;

	@Autowired
	private MatchScheduleDAO scheduleDAO;

	@Autowired
	private BidDao bidDao;

	@Autowired
	private MatchDao matchDao;
	@Autowired
	private TeamPointsDao teaPointsDao;
	
	@Autowired
	private LeaderboardDao lDao;

	@Override
	public Bidder registerBidder(Bidder bidder) {
		// TODO Auto-generated method stub
		return dao.save(bidder);
	}

	@Override
	public Bidder getBidder(int username, String password) {
		// TODO Auto-generated method stub
		return dao.getBidder(username, password);
	}

	@Override
	public List<ScheduleDTO> getScheduled() {
		// TODO Auto-generated method stub
		return MatchScheduleUtils.convertToMatchScheduleDtoList(scheduleDAO.findAll());
	}

	@Override
	public void userBid(BidDTO biddto) {
		// TODO Auto-generated method stub
		bidDao.save(BidUtils.convertToBidEntity(biddto));
	}

	@Override
	public List<Match> getMatchsDetails() {
		// TODO Auto-generated method stub
		return (List<Match>) matchDao.findAll();
	}

	@Override
	public void cancelBid(Integer b_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TeamPoints> getTeamPoints() {
		// TODO Auto-generated method stub
		return teaPointsDao.findAll().stream().sorted(Comparator.comparingInt(TeamPoints::getTeam_id)).limit(3)
				.collect(Collectors.toList());
	}

	@Override
	public List<Leaderboard> getBidderBoard() {
		// TODO Auto-generated method stub
		return (List<Leaderboard>) lDao.findAll();
	}

}

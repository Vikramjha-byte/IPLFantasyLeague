package com.IPLFantasy.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.IPLFantasy.DTO.BidDTO;
import com.IPLFantasy.DTO.ScheduleDTO;
import com.IPLFantasy.dao.BidDao;
import com.IPLFantasy.dao.BidderDao;
import com.IPLFantasy.dao.LeaderboardDao;
import com.IPLFantasy.dao.MatchDao;
import com.IPLFantasy.dao.MatchScheduleDao;
import com.IPLFantasy.dao.TeamPointsDao;
import com.IPLFantasy.entities.Admin;
import com.IPLFantasy.entities.Bid;
import com.IPLFantasy.entities.Bidder;
import com.IPLFantasy.entities.Leaderboard;
import com.IPLFantasy.entities.Match;
import com.IPLFantasy.entities.TeamPoints;
import com.IPLFantasy.exceptions.IncorrectPasswordException;
import com.IPLFantasy.exceptions.UsernameNotFoundException;
import com.IPLFantasy.utils.BidUtils;
import com.IPLFantasy.utils.MatchScheduleUtils;

@Service
public class BidderserviceImpl implements BidderService {

	@Autowired
	private BidderDao dao;

	@Autowired
	private MatchScheduleDao scheduleDAO;

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
	public List<ScheduleDTO> getScheduled() {
		// TODO Auto-generated method stub
		return MatchScheduleUtils.convertToMatchScheduleDtoList(scheduleDAO.findAll());
	}

	@Override
	public void userBid(Bid bid) {
		// TODO Auto-generated method stub
		bidDao.save(bid);
	}

	@Override
	public List<Match> getMatchsDetails() {
		// TODO Auto-generated method stub
		return (List<Match>) matchDao.findAll();
	}

	@Override
	public void cancelBid(Integer b_id) {
		// TODO Auto-generated method stub
		bidDao.deleteById(b_id);
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

	@Override
	public List<Bidder> getBidders() {

		return dao.findAll();
	}

	@Override
	public Boolean loginBidder(Bidder login) throws UsernameNotFoundException, IncorrectPasswordException {
		PasswordEncoder passencoder = new BCryptPasswordEncoder();

		Bidder bident = dao.findByUserName(login.getUserName());
		if (bident == null) {
			throw new UsernameNotFoundException("username not found");
		} else {
			if (!passencoder.matches(login.getPassword(), bident.getPassword())) {
				throw new IncorrectPasswordException("incorrrect password");
			}
			return null;
		}

	}

	@Override
	public List<BidDTO> getBid() {
		// TODO Auto-generated method stub
		return BidUtils.convertToBidEntitylist(bidDao.findAll());
	}

}

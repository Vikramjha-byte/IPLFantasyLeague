package com.IPLFantasy.services.bidders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IPLFantasy.DTO.BidDTO;
import com.IPLFantasy.DTO.ScheduleDTO;
import com.IPLFantasy.dao.admin.BidDao;
import com.IPLFantasy.dao.admin.MatchScheduleDAO;
import com.IPLFantasy.dao.bidders.BidderDao;
import com.IPLFantasy.entities.Bidder;
import com.IPLFantasy.utils.BidUtils;
import com.IPLFantasy.utils.MatchScheduleUtils;



@Service
public class BidderserviceImpl implements BidderService{
	
	@Autowired
	private BidderDao dao;
	
	@Autowired
	private MatchScheduleDAO scheduleDAO;
	
	@Autowired
	private BidDao bidDao;

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

}

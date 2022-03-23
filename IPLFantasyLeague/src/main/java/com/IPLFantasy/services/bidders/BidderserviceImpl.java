package com.IPLFantasy.services.bidders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IPLFantasy.dao.bidders.BidderDao;
import com.IPLFantasy.entities.Bidder;

@Service
public class BidderserviceImpl implements BidderService{
	
	@Autowired
	private BidderDao dao;

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

}

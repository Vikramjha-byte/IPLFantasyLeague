package com.IPLFantasy.services.bidders;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IPLFantasy.dao.bidders.BidderDao;
import com.IPLFantasy.entities.Bidder;


public interface BidderService {

	

	public Bidder registerBidder(Bidder bidder) ;

	public Bidder getBidder(int username,String password) ;
}

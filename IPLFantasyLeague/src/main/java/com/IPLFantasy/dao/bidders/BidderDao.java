package com.IPLFantasy.dao.bidders;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.Bidder;

@Repository
public interface BidderDao extends CrudRepository<Bidder, Integer> {
	@Query("select p from Bidder p where p.bidderId=?1 and p.password=?2 ")
	 Bidder getBidder(int username,String password);
}

package com.IPLFantasy.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.Bid;

@Repository
public interface BidDao extends CrudRepository<Bid, Integer>,JpaRepository<Bid, Integer>{
	@Query("select p from Bid p where p.bidby=?1")
	List<Bid> getByUserId(int bidderId);

}

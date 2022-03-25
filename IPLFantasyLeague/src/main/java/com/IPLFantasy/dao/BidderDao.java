package com.IPLFantasy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.Bidder;

@Repository
public interface BidderDao extends CrudRepository<Bidder, Integer>, JpaRepository<Bidder, Integer> {

	public Bidder findByUserName(String user_Name);
}

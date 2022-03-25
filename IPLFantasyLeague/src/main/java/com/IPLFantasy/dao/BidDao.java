package com.IPLFantasy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.Bid;

@Repository
public interface BidDao extends CrudRepository<Bid, Integer>,JpaRepository<Bid, Integer>{

}

package com.IPLFantasy.dao.bidders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.Match;

@Repository
public interface MatchDao extends CrudRepository<Match, Integer>, JpaRepository<Match, Integer>{

}
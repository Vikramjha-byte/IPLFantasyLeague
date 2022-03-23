package com.IPLFantasy.dao.admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.Match;

public interface MatchDao extends CrudRepository<Match, Integer> {

}

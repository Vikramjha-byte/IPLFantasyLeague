package com.IPLFantasy.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.Tournaments;

@Repository
public interface TournamentDao extends CrudRepository<Tournaments, Integer> {

}

package com.IPLFantasy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.Leaderboard;

@Repository
public interface LeaderboardDao extends CrudRepository<Leaderboard, Integer>,JpaRepository<Leaderboard, Integer>{

}

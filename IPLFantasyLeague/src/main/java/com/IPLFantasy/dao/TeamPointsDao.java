package com.IPLFantasy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.TeamPoints;

@Repository
public interface TeamPointsDao extends CrudRepository<TeamPoints, Integer>,JpaRepository<TeamPoints, Integer> {

}

package com.IPLFantasy.dao.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.IPLFantasy.entities.TeamPoints;

public interface TeamPointsDao extends CrudRepository<TeamPoints, Integer>, JpaRepository<TeamPoints, Integer>{

}

package com.IPLFantasy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.MatchSchedule;


@Repository
public interface MatchScheduleDao extends CrudRepository<MatchSchedule, Integer>, JpaRepository<MatchSchedule, Integer> {

}

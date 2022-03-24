package com.IPLFantasy.dao.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.MatchSchedule;

@Repository
public interface MatchScheduleDAO extends CrudRepository<MatchSchedule, Integer>,JpaRepository<MatchSchedule, Integer>{

}

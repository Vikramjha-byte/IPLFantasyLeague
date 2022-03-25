package com.IPLFantasy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.TeamDetails;

@Repository
public interface TeamDao extends CrudRepository<TeamDetails, Integer>,JpaRepository<TeamDetails, Integer> {

}

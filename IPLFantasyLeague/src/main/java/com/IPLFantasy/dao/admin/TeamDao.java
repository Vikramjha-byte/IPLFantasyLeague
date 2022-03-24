package com.IPLFantasy.dao.admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.Team;

@Repository
public interface TeamDao extends CrudRepository<Team, Integer> {

}

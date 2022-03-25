package com.IPLFantasy.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.IPLFantasy.entities.Admin;

@Repository
public interface AdminDao extends CrudRepository<Admin, Integer> {
	public Admin findByUsername(String user_name);
}

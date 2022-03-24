package com.IPLFantasy.services.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IPLFantasy.dao.admin.TeamDao;
import com.IPLFantasy.dao.admin.TournamentDao;
import com.IPLFantasy.entities.Team;
import com.IPLFantasy.entities.Tournaments;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private TournamentDao dao;
	@Autowired
	private TeamDao teamDao;

	@Override
	public void createTournaments(Tournaments tournaments) {
		dao.save(tournaments);
	}

	@Override
	public void createTeams(Team team) {
		teamDao.save(team);
	}

}

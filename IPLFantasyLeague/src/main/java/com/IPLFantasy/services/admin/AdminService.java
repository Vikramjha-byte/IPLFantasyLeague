package com.IPLFantasy.services.admin;

import com.IPLFantasy.entities.Team;
import com.IPLFantasy.entities.Tournaments;


public interface AdminService {
	public void createTournaments(Tournaments tournaments);
	public void createTeams(Team team);
}

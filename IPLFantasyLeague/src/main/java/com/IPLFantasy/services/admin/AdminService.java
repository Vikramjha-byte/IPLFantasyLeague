package com.IPLFantasy.services.admin;

import com.IPLFantasy.entities.Admin;
import com.IPLFantasy.entities.Team;
import com.IPLFantasy.entities.Tournaments;
import com.IPLFantasy.exceptions.IncorrectPasswordException;
import com.IPLFantasy.exceptions.UsernameNotFoundException;

public interface AdminService {
	public void createTournaments(Tournaments tournaments);

	public void createTeams(Team team);

	Boolean loginAdmin(Admin login) throws UsernameNotFoundException, IncorrectPasswordException;

}

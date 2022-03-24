package com.IPLFantasy.services.admin;

import java.util.List;

import com.IPLFantasy.entities.Admin;
import com.IPLFantasy.entities.Bid;
import com.IPLFantasy.entities.MatchSchedule;

import com.IPLFantasy.entities.TeamDetails;
import com.IPLFantasy.entities.TeamPoints;
import com.IPLFantasy.entities.Tournaments;
import com.IPLFantasy.exceptions.IncorrectPasswordException;
import com.IPLFantasy.exceptions.UsernameNotFoundException;

public interface AdminService {
	public void createTournaments(Tournaments tournaments);

	public void createTeams(TeamDetails team);

	Boolean loginAdmin(int username,String password) throws UsernameNotFoundException, IncorrectPasswordException;

	public List<Admin> getAdmindetails();

	public void scheduleMatch(MatchSchedule match);

	public void rescheduleMatch(Integer match_id);

	public void updateTeam(Integer t_id);

	public void cancelMatch(Integer match_id);

	public void matchResult(TeamPoints points);

	public List<Bid> getBiddings();

}

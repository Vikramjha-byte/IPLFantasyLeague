package com.IPLFantasy.services;

import java.util.List;

import com.IPLFantasy.entities.Admin;
import com.IPLFantasy.entities.Bid;
import com.IPLFantasy.entities.Match;
import com.IPLFantasy.entities.MatchSchedule;

import com.IPLFantasy.entities.TeamDetails;
import com.IPLFantasy.entities.TeamPoints;
import com.IPLFantasy.entities.Tournaments;
import com.IPLFantasy.exceptions.IncorrectPasswordException;
import com.IPLFantasy.exceptions.UsernameNotFoundException;

public interface AdminService {
	public void createTournaments(Tournaments tournaments);

	public void createTeams(TeamDetails team);

	Admin loginAdmin(Admin admin) throws UsernameNotFoundException, IncorrectPasswordException;

	public List<Admin> getAdmindetails();

	public void scheduleMatch(MatchSchedule match);

	public void rescheduleMatch(Integer match_id);

	public void updateTeam(Integer t_id);

	public void cancelMatch(Integer match_id);

	public void matchResult(TeamPoints points);

	public List<Bid> getBiddings();

	public Admin registerBidder(Admin admin);

	public List<TeamDetails> getTeams();

	public List<MatchSchedule> getMatchSchedule();

	public void createMatches(Match match);

	public Admin getAdmindetailsbyid(int admin_id);

	public List<Match> getMatchsDetails();

	public void updateMatch(Integer match_id, String winner);

}

package com.IPLFantasy.services.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.IPLFantasy.dao.admin.AdminDao;
import com.IPLFantasy.dao.admin.BidDao;
import com.IPLFantasy.dao.admin.MatchScheduleDAO;
import com.IPLFantasy.dao.admin.TeamDao;
import com.IPLFantasy.dao.admin.TeamPointsDao;
import com.IPLFantasy.dao.admin.TournamentDao;
import com.IPLFantasy.entities.Admin;
import com.IPLFantasy.entities.Bid;
import com.IPLFantasy.entities.MatchSchedule;
import com.IPLFantasy.entities.TeamDetails;
import com.IPLFantasy.entities.TeamPoints;
import com.IPLFantasy.entities.Tournaments;
import com.IPLFantasy.exceptions.IncorrectPasswordException;
import com.IPLFantasy.exceptions.UsernameNotFoundException;




@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private TournamentDao dao;
	@Autowired
	private TeamDao teamDao;
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private MatchScheduleDAO scheduleDAO;
	
	@Autowired
	TeamPointsDao pointsDao;

	@Autowired
	BidDao bidDao;
	
	@Override
	public void createTournaments(Tournaments tournaments) {
		dao.save(tournaments);
	}

	@Override
	public void createTeams(TeamDetails team) {
		teamDao.save(team);
	}

	@Override
	public Boolean loginAdmin(int username,String password) throws UsernameNotFoundException, IncorrectPasswordException {
		// TODO Auto-generated method stub
		PasswordEncoder passencoder = new BCryptPasswordEncoder();
		Admin login= new Admin();
		Admin adment = adminDao.findByUsername(login.getUsername());
		if(adment==null) {
			throw new UsernameNotFoundException("username not found");
		}
		else{			
			if(!passencoder.matches(login.getPassword(), adment.getPassword())){
				throw new IncorrectPasswordException("incorrrect password");
			}
		return null;
	}

	}

	@Override
	public List<Admin> getAdmindetails() {
		// TODO Auto-generated method stub
		return (List<Admin>) adminDao.findAll();
	}

	@Override
	public void scheduleMatch(MatchSchedule match) {
		// TODO Auto-generated method stub
		scheduleDAO.save(match);
	}

	@Override
	public void rescheduleMatch(Integer match_id) {
		// TODO Auto-generated method stub
		scheduleDAO.save(scheduleDAO.getById(match_id));
	}
	@Override
	public void updateTeam(Integer t_id) {
		TeamDetails teamDetails = teamDao.getById(t_id);
		teamDao.save(teamDetails);		
	}

	@Override
	public void cancelMatch(Integer match_id) {
		// TODO Auto-generated method stub
		scheduleDAO.delete(scheduleDAO.getById(match_id));
	}

	@Override
	public void matchResult(TeamPoints points) {
		// TODO Auto-generated method stub
		pointsDao.save(points);
	}

	@Override
	public List<Bid> getBiddings() {
		// TODO Auto-generated method stub
		return bidDao.findAll();
	}
}

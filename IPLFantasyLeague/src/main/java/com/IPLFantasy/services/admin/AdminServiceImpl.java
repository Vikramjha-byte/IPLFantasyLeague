package com.IPLFantasy.services.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.IPLFantasy.dao.admin.AdminDao;
import com.IPLFantasy.dao.admin.TeamDao;
import com.IPLFantasy.dao.admin.TournamentDao;
import com.IPLFantasy.entities.Admin;
import com.IPLFantasy.entities.Team;
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

	@Override
	public void createTournaments(Tournaments tournaments) {
		dao.save(tournaments);
	}

	@Override
	public void createTeams(Team team) {
		teamDao.save(team);
	}

	@Override
	public Boolean loginAdmin(Admin login) throws UsernameNotFoundException, IncorrectPasswordException {
		// TODO Auto-generated method stub
		PasswordEncoder passencoder = new BCryptPasswordEncoder();
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

}

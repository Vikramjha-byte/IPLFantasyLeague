package com.IPLFantasy.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IPLFantasy.DTO.MatchStatsDto;
import com.IPLFantasy.dao.MatchDao;
import com.IPLFantasy.utils.TeamStatsUtils;

@Service
public class SystemServiceImpl implements SystemService {
	
	@Autowired
	private MatchDao dao;

	@Override
	public List<MatchStatsDto> getTeamStats() {
		List<MatchStatsDto> matchdto = TeamStatsUtils.convertToMatchStatsList(dao.findAll());
		return matchdto.stream().filter(e->e.getStatus().equals("finished")).collect(Collectors.toList());
	}

}

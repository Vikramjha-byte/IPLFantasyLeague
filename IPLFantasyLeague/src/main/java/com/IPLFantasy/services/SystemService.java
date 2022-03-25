package com.IPLFantasy.services;

import java.util.List;

import com.IPLFantasy.DTO.MatchStatsDto;

public interface SystemService {

	List<MatchStatsDto> getTeamStats();

}

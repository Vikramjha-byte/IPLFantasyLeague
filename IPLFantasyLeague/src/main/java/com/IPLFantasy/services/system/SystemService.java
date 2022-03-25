package com.IPLFantasy.services.system;

import java.util.List;

import com.IPLFantasy.DTO.MatchStatsDto;

public interface SystemService {

	List<MatchStatsDto> getTeamStats();

}

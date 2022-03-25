package com.IPLFantasy.utils;

import java.util.ArrayList;
import java.util.List;

import com.IPLFantasy.DTO.MatchStatsDto;
import com.IPLFantasy.entities.Match;



public class TeamStatsUtils {

	public static List<MatchStatsDto> convertToMatchStatsList(List<Match> list){
		List<MatchStatsDto> dtolist = new ArrayList<MatchStatsDto>();
		for(Match matchSchedule:list) {
			dtolist.add(convertToMatchDto(matchSchedule));
		}
		return dtolist;
	}

	public static MatchStatsDto convertToMatchDto(Match stats) {
		MatchStatsDto dto = new MatchStatsDto();
		dto.setMatch_id(stats.getMatch_id());
		dto.setDelay(stats.getDelay());
		dto.setMatch_date(stats.getMatch_date());
		dto.setMatch_stadium(stats.getMatch_stadium());
		dto.setMatch_time(stats.getMatch_time());
		dto.setStatus(stats.getStatus());
		dto.setTeamdetails(stats.getTeamdetails());
		dto.setTeamdetails2(stats.getTeamdetails2());
		dto.setWinner(stats.getWinner());
		return dto;
	}
}

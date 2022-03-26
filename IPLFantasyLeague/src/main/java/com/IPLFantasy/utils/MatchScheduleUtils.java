package com.IPLFantasy.utils;

import java.util.ArrayList;
import java.util.List;

import com.IPLFantasy.DTO.ScheduleDTO;
import com.IPLFantasy.entities.MatchSchedule;



public class MatchScheduleUtils {

	public static List<ScheduleDTO> convertToMatchScheduleDtoList(List<MatchSchedule> list){
		List<ScheduleDTO> dtolist = new ArrayList<ScheduleDTO>();
		for(MatchSchedule matchentity:list) {
			
			dtolist.add(convertToMatchScheduleDto(matchentity));
		}
		
		return dtolist;
	}
	public static ScheduleDTO convertToMatchScheduleDto(MatchSchedule matchentity) {
		ScheduleDTO matchdto = new ScheduleDTO();
		matchdto.setMatch_id(matchentity.getMatch_id());
		matchdto.setStart_time(matchentity.getStart_time());
		matchdto.setTeamdetails(matchentity.getTeamdetails());
		matchdto.setTeamdetails2(matchentity.getTeamdetails2());
		matchdto.setEnd_time(matchentity.getEnd_time());
		matchdto.setMatch_date(matchentity.getMatch_date());
		matchdto.setResult(matchentity.getResult());
		return matchdto;
	}
}

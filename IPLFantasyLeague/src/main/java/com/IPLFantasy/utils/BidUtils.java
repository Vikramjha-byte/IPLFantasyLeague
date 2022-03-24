package com.IPLFantasy.utils;

import com.IPLFantasy.DTO.BidDTO;
import com.IPLFantasy.entities.Bid;

//import java.util.ArrayList;
//import java.util.List;



public class BidUtils {

//	public static List<MatchScheduleDTO> convertToMatchScheduleDtoList(List<MatchScheduleEntity> list){
//		List<MatchScheduleDTO> dtolist = new ArrayList<MatchScheduleDTO>();
//		for(MatchScheduleEntity matchentity:list) {
//			dtolist.add(convertToMatchScheduleDto(matchentity));
//		}
//		return dtolist;
//	}
	
	public static Bid convertToBidEntity(BidDTO biddto) {
		Bid bident = new Bid();
		bident.setUser_id(biddto.getUser_id());
		bident.setUser_opinion1(biddto.getUser_opinion1());
		bident.setUser_opinion2(biddto.getUser_opinion2());		
		bident.setMatch_id(biddto.getMatch_id());
		return bident;
	}
}

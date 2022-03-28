package com.IPLFantasy.utils;

import java.util.ArrayList;
import java.util.List;

import com.IPLFantasy.DTO.BidDTO;
import com.IPLFantasy.DTO.ScheduleDTO;
import com.IPLFantasy.entities.Bid;
import com.IPLFantasy.entities.MatchSchedule;

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
//	public static List<ScheduleDTO> convertToBIDDtoList(List<Bid> list){
//		List<BidDTO> dtolist = new ArrayList<BidDTO>();
//		for(Bid bid:list) {
//			
//			dtolist.add(convertToBidEntity(bid));
//		}
//		
//		return dtolist;
//	}
	public static Bid convertToBidEntity(BidDTO biddto) {
		Bid bident = new Bid();
		bident.setUser_id(biddto.getUser_id());
		bident.setUser_opinion1(biddto.getUser_opinion1());
		bident.setUser_opinion2(biddto.getUser_opinion2());		
		bident.setMatch_id(biddto.getMatch_id());
		bident.setBidby(biddto.getBidby());
		bident.setResult(biddto.getResult());
		return bident;
	}
	public static BidDTO convertToBidEntityDto(Bid biddto) {
		BidDTO bident = new BidDTO();
		bident.setUser_id(biddto.getUser_id());
		bident.setUser_opinion1(biddto.getUser_opinion1());
		bident.setUser_opinion2(biddto.getUser_opinion2());		
		bident.setMatch_id(biddto.getMatch_id());
		bident.setBidby(biddto.getBidby());
		bident.setResult(biddto.getResult());
		return bident;
	}

	public static List<BidDTO> convertToBidEntitylist(List<Bid> findAll) {
		// TODO Auto-generated method stub
		List<BidDTO> dtoList= new ArrayList<>();
		for(Bid x: findAll) {
			dtoList.add(convertToBidEntityDto(x));
		}
		return dtoList;
	}
}

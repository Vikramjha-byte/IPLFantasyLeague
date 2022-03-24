package com.IPLFantasy.DTO;

import java.util.Date;

import com.IPLFantasy.entities.TeamDetails;

public class ScheduleDTO {
	private Integer match_id;
	private TeamDetails teamdetails;
	private TeamDetails teamdetails2;
	private String start_time;
	private String end_time;
	private String result;
	private Date Match_date;
	public Integer getMatch_id() {
		return match_id;
	}
	public void setMatch_id(Integer match_id) {
		this.match_id = match_id;
	}
	public Date getMatch_date() {
		return Match_date;
	}
	public void setMatch_date(Date match_date) {
		Match_date = match_date;
	}
	public TeamDetails getTeamdetails() {
		return teamdetails;
	}
	public void setTeamdetails(TeamDetails teamdetails) {
		this.teamdetails = teamdetails;
	}
	public TeamDetails getTeamdetails2() {
		return teamdetails2;
	}
	public void setTeamdetails2(TeamDetails teamdetails2) {
		this.teamdetails2 = teamdetails2;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ScheduleDTO [match_id=" + match_id + ", teamdetails=" + teamdetails + ", teamdetails2=" + teamdetails2
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", result=" + result + ", Match_date="
				+ Match_date + "]";
	}
}

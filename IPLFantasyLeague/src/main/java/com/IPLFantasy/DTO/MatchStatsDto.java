package com.IPLFantasy.DTO;

import java.sql.Time;
import java.util.Date;

import com.IPLFantasy.entities.TeamDetails;


public class MatchStatsDto {

	private Integer match_id;

	private TeamDetails teamdetails;

	private TeamDetails teamdetails2;

	private Date match_date;

	private String match_time;
	
	public Integer getMatch_id() {
		return match_id;
	}
	public void setMatch_id(Integer match_id) {
		this.match_id = match_id;
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
	public Date getMatch_date() {
		return match_date;
	}
	public void setMatch_date(Date match_date) {
		this.match_date = match_date;
	}
	public String getMatch_time() {
		return match_time;
	}
	public void setMatch_time(String string) {
		this.match_time = string;
	}
	public String getMatch_stadium() {
		return match_stadium;
	}
	public void setMatch_stadium(String match_stadium) {
		this.match_stadium = match_stadium;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDelay() {
		return delay;
	}
	public void setDelay(String delay) {
		this.delay = delay;
	}
	private String match_stadium;
	private String winner;
	private String status;
	private String delay;

}

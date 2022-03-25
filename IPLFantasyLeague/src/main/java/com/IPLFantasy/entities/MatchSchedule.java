package com.IPLFantasy.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "match_scheduled")
public class MatchSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer match_id;
	@OneToOne
	@JoinColumn(name = "team_1_id")
	private TeamDetails teamdetails;

	@OneToOne
	@JoinColumn(name = "team_2_id")
	private TeamDetails teamdetails2;

	private String start_time;
	private String end_time;
	private String result;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date match_date;

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

	@Override
	public String toString() {
		return "MatchSchedule [match_id=" + match_id + ", teamdetails=" + teamdetails + ", teamdetails2=" + teamdetails2
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", result=" + result + ", match_date="
				+ match_date + "]";
	}

}

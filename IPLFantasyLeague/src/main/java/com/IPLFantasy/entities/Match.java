package com.IPLFantasy.entities;

import java.sql.Time;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer match_id;
	@OneToOne
	@JoinColumn(name = "team_one")
	private TeamDetails teamdetails;

	@OneToOne
	@JoinColumn(name = "team_two")
	private TeamDetails teamdetails2;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date match_date;
   
	private String match_time;
	@Column(length = 150)
	private String match_stadium;
	private String winner;
	private String status;
	private String delay;

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

	public void setMatch_time(String match_time) {
		this.match_time = match_time;
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

	@Override
	public String toString() {
		return "Match [match_id=" + match_id + ", teamdetails=" + teamdetails + ", teamdetails2=" + teamdetails2
				+ ", match_date=" + match_date + ", match_time=" + match_time + ", match_stadium=" + match_stadium
				+ ", winner=" + winner + ", status=" + status + ", delay=" + delay + "]";
	}

}

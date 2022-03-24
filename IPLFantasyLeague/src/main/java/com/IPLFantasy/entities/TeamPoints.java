package com.IPLFantasy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TeamPoints")
public class TeamPoints {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer team_id;
	
	@Column(length = 50)
	private String team_name;
	
	private Integer matches_played;
	private Integer matches_won;
	private Integer matches_lost;
	private Integer match_drawn;
	private Integer points;
	public Integer getTeam_id() {
		return team_id;
	}
	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public Integer getMatches_played() {
		return matches_played;
	}
	public void setMatches_played(Integer matches_played) {
		this.matches_played = matches_played;
	}
	public Integer getMatches_won() {
		return matches_won;
	}
	public void setMatches_won(Integer matches_won) {
		this.matches_won = matches_won;
	}
	public Integer getMatches_lost() {
		return matches_lost;
	}
	public void setMatches_lost(Integer matches_lost) {
		this.matches_lost = matches_lost;
	}
	public Integer getMatch_drawn() {
		return match_drawn;
	}
	public void setMatch_drawn(Integer match_drawn) {
		this.match_drawn = match_drawn;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	
}

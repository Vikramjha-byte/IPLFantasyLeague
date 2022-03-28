package com.IPLFantasy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Team_details")
public class TeamDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer match_id;
	@Column(length = 50)
	private String team_name;
	@Column(length = 50)
	private String home_ground;
	@Column(length = 10000)
	private String team_players;
	@Column(length = 50)
	private String captain;

	public Integer getMatch_id() {
		return match_id;
	}

	public void setMatch_id(Integer match_id) {
		this.match_id = match_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getHome_ground() {
		return home_ground;
	}

	public void setHome_ground(String home_ground) {
		this.home_ground = home_ground;
	}

	public String getTeam_players() {
		return team_players;
	}

	public void setTeam_players(String team_players) {
		this.team_players = team_players;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}

	@Override
	public String toString() {
		return "TeamDetails [match_id=" + match_id + ", team_name=" + team_name + ", home_ground=" + home_ground
				+ ", team_players=" + team_players + ", captain=" + captain + "]";
	}

}

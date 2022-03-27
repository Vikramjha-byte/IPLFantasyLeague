package com.IPLFantasy.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Tournaments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tournament_id;
	
	private Integer number_of_qualifiers;
	
	private Integer number_of_teams;
	private Integer number_of_matches_completed;
	
	@OneToOne
	@JoinColumn(name="match_id")
	private Match match_id;

	public Integer getTournament_id() {
		return tournament_id;
	}

	public void setTournament_id(Integer tournament_id) {
		this.tournament_id = tournament_id;
	}

	public Integer getNumber_of_qualifiers() {
		return number_of_qualifiers;
	}

	public void setNumber_of_qualifiers(Integer number_of_qualifiers) {
		this.number_of_qualifiers = number_of_qualifiers;
	}

	public Integer getNumber_of_teams() {
		return number_of_teams;
	}

	public void setNumber_of_teams(Integer number_of_teams) {
		this.number_of_teams = number_of_teams;
	}

	public Integer getNumber_of_matches_completed() {
		return number_of_matches_completed;
	}

	public void setNumber_of_matches_completed(Integer number_of_matches_completed) {
		this.number_of_matches_completed = number_of_matches_completed;
	}

	public Match getMatch_id() {
		return match_id;
	}

	public void setMatch_id(Match match_id) {
		this.match_id = match_id;
	}
	

}

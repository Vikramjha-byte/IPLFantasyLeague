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

@Entity
public class Tournaments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int tournamentsId;
	public int numOfTeams;
	public Date duration;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "mId")
	private List<Match> matches;

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public int getTournamentsId() {
		return tournamentsId;
	}

	public void setTournamentsId(int tournamentsId) {
		this.tournamentsId = tournamentsId;
	}

	public int getNumOfTeams() {
		return numOfTeams;
	}

	public void setNumOfTeams(int numOfTeams) {
		this.numOfTeams = numOfTeams;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Tournaments [tournamentsId=" + tournamentsId + ", numOfTeams=" + numOfTeams + ", duration=" + duration
				+ ", matches=" + matches + "]";
	}

}

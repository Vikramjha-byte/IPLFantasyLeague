package com.IPLFantasy.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class System {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "rid")
	private List<Result> result;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "bId")
	private List<Bidder> bidder;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "tId")
	private List<Team> team;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}

	public List<Bidder> getBidder() {
		return bidder;
	}

	public void setBidder(List<Bidder> bidder) {
		this.bidder = bidder;
	}

	public List<Team> getTeam() {
		return team;
	}

	public void setTeam(List<Team> team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "System [id=" + id + ", result=" + result + ", bidder=" + bidder + ", team=" + team + "]";
	}

}

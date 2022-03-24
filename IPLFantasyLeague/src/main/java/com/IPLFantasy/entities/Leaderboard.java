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
public class Leaderboard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int lId;
	public int bidderId;
	public int bidsParticipated;
	public int bidsWon;
	public int bidsLost;
	public double percentile;
	public int bidder_ranking;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "bId")
	private List<Bidder> bidders;
	
	

	public List<Bidder> getBidders() {
		return bidders;
	}

	public void setBidders(List<Bidder> bidders) {
		this.bidders = bidders;
	}

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public int getBidderId() {
		return bidderId;
	}

	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

	public int getBidsParticipated() {
		return bidsParticipated;
	}

	public void setBidsParticipated(int bidsParticipated) {
		this.bidsParticipated = bidsParticipated;
	}

	public int getBidsWon() {
		return bidsWon;
	}

	public void setBidsWon(int bidsWon) {
		this.bidsWon = bidsWon;
	}

	public int getBidsLost() {
		return bidsLost;
	}

	public void setBidsLost(int bidsLost) {
		this.bidsLost = bidsLost;
	}

	public double getPercentile() {
		return percentile;
	}

	public void setPercentile(double percentile) {
		this.percentile = percentile;
	}

	public int getBidder_ranking() {
		return bidder_ranking;
	}

	public void setBidder_ranking(int bidder_ranking) {
		this.bidder_ranking = bidder_ranking;
	}

	@Override
	public String toString() {
		return "Leaderboard [lId=" + lId + ", bidderId=" + bidderId + ", bidsParticipated=" + bidsParticipated
				+ ", bidsWon=" + bidsWon + ", bidsLost=" + bidsLost + ", percentile=" + percentile + ", bidder_ranking="
				+ bidder_ranking + ", bidders=" + bidders + "]";
	}

}

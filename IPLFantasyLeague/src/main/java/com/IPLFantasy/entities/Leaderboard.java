package com.IPLFantasy.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Leaderboard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int lId;

	public String bidder_name;

	public int bidder_points;

	public int bids_participated;

	public int bids_won;

	public double percentile;

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public String getBidder_name() {
		return bidder_name;
	}

	public void setBidder_name(String bidder_name) {
		this.bidder_name = bidder_name;
	}

	public int getBidder_points() {
		return bidder_points;
	}

	public void setBidder_points(int bidder_points) {
		this.bidder_points = bidder_points;
	}

	public int getBids_participated() {
		return bids_participated;
	}

	public void setBids_participated(int bids_participated) {
		this.bids_participated = bids_participated;
	}

	public int getBids_won() {
		return bids_won;
	}

	public void setBids_won(int bids_won) {
		this.bids_won = bids_won;
	}

	public double getPercentile() {
		return percentile;
	}

	public void setPercentile(double percentile) {
		this.percentile = percentile;
	}

	@Override
	public String toString() {
		return "Leaderboard [lId=" + lId + ", bidder_name=" + bidder_name + ", bidder_points=" + bidder_points
				+ ", bids_participated=" + bids_participated + ", bids_won=" + bids_won + ", percentile=" + percentile
				+ "]";
	}

}
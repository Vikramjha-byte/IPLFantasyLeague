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
	
    @OneToOne
    @JoinColumn(name="bidder_name")
	public Bidder bidder;
    
    @OneToOne
    @JoinColumn(name="bidder_points")
    public Bid bid;
	
	
    @OneToOne
    @JoinColumn(name="bids_participated")
    public Bid bid2;
    
    @OneToOne
    @JoinColumn(name="bids_won")
    public Bid bid3;
	
    @OneToOne
    @JoinColumn(name="percentile")
    public Bid bid4;

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public Bidder getBidder() {
		return bidder;
	}

	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public Bid getBid2() {
		return bid2;
	}

	public void setBid2(Bid bid2) {
		this.bid2 = bid2;
	}

	public Bid getBid3() {
		return bid3;
	}

	public void setBid3(Bid bid3) {
		this.bid3 = bid3;
	}

	public Bid getBid4() {
		return bid4;
	}

	public void setBid4(Bid bid4) {
		this.bid4 = bid4;
	}

	@Override
	public String toString() {
		return "Leaderboard [lId=" + lId + ", bidder=" + bidder + ", bid=" + bid + ", bid2=" + bid2 + ", bid3=" + bid3
				+ ", bid4=" + bid4 + "]";
	}
    
    
}

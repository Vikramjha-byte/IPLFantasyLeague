package com.IPLFantasy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="bid_Details")
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	@Column(length=100)
	private String user_opinion1;
	@Column(length = 100)
	private String user_opinion2;
	private Integer match_id;
	private Integer bidby;
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_opinion1() {
		return user_opinion1;
	}
	public void setUser_opinion1(String user_opinion1) {
		this.user_opinion1 = user_opinion1;
	}
	public String getUser_opinion2() {
		return user_opinion2;
	}
	public void setUser_opinion2(String user_opinion2) {
		this.user_opinion2 = user_opinion2;
	}
	public Integer getMatch_id() {
		return match_id;
	}
	public void setMatch_id(Integer match_id) {
		this.match_id = match_id;
	}
	public Integer getBidby() {
		return bidby;
	}
	public void setBidby(Integer bidby) {
		this.bidby = bidby;
	}
	
}

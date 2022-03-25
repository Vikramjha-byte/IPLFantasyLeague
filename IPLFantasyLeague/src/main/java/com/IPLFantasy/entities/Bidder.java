package com.IPLFantasy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Generated;

@Entity
public class Bidder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int bidderId;
	@Column(nullable = false,length=20)
	private String userName;
	@Column(nullable = false ,length=64)
	private String password;
	@Column(nullable = false,length=20)
	@NotBlank
	@Size(min = 3,max = 20)
	public String name;
	@Column(nullable = false)
	@NotBlank
	@Size(min = 3,max = 20)
	public String email;
	@Column(nullable = false)
	@NotBlank
	@Size(min = 3,max = 20)
	private String phoneNo;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "leaderboard_id")
//	private Leaderboard leaderboard;

	public int getBidderId() {
		return bidderId;
	}

	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Bidder [bidderId=" + bidderId + ", userName=" + userName + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", phoneNo=" + phoneNo + "]";
	}

//	public Leaderboard getLeaderboard() {
//		return leaderboard;
//	}
//
//	public void setLeaderboard(Leaderboard leaderboard) {
//		this.leaderboard = leaderboard;
//	}

}

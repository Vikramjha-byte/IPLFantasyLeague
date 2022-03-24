package com.IPLFantasy.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Result {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int result_id;
	public String firstTeam;
	public String secondTeam;
	public String thirdTeam;

	public int getResult_id() {
		return result_id;
	}

	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}

	public String getFirstTeam() {
		return firstTeam;
	}

	public void setFirstTeam(String firstTeam) {
		this.firstTeam = firstTeam;
	}

	public String getSecondTeam() {
		return secondTeam;
	}

	public void setSecondTeam(String secondTeam) {
		this.secondTeam = secondTeam;
	}

	public String getThirdTeam() {
		return thirdTeam;
	}

	public void setThirdTeam(String thirdTeam) {
		this.thirdTeam = thirdTeam;
	}

	@Override
	public String toString() {
		return "Result [result_id=" + result_id + ", firstTeam=" + firstTeam + ", secondTeam=" + secondTeam
				+ ", thirdTeam=" + thirdTeam + "]";
	}

}

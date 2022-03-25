package com.IPLFantasy.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.IPLFantasy.entities.Bidder;

public class customBidderController implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Bidder bidder;

	public customBidderController(Bidder bidder) {
		super();
		this.bidder = bidder;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return bidder.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return Integer.toString(bidder.getBidderId());
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

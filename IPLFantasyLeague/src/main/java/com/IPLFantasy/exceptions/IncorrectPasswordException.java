package com.IPLFantasy.exceptions;

public class IncorrectPasswordException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectPasswordException(String msg){
		super(msg);
	}
}

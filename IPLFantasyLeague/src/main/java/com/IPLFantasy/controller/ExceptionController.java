package com.IPLFantasy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.IPLFantasy.exceptions.UsernameNotFoundException;
import com.IPLFantasy.exceptions.IncorrectPasswordException;
import com.IPLFantasy.exceptions.UserAlreadyExistException;
import com.IPLFantasy.exceptions.UserNameAlreadyExistException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<String> InvalidInputException(UserAlreadyExistException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNameAlreadyExistException.class)
	public ResponseEntity<String> UserNameAlreadyExistException(UserAlreadyExistException excep) {
		return new ResponseEntity<String>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<String> UsernameNotFoundException(UsernameNotFoundException excep) {
		return new ResponseEntity<String>(excep.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IncorrectPasswordException.class)
	public ResponseEntity<String> IncorrectPasswordException(IncorrectPasswordException excep) {
		return new ResponseEntity<String>(excep.getMessage(), HttpStatus.NOT_FOUND);
	}

}

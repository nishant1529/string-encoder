package com.ssc.exercise.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = 3394511110958575442L;

	public InvalidInputException(String value) {
		super(value);
	}
}

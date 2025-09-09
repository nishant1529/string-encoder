package com.ssc.exercise.service;

import com.ssc.exercise.exception.InvalidInputException;

public interface EncodeStringService {

	String encodeString(String str) throws InvalidInputException;
	
	String encodeStringUsingStream(String str) throws InvalidInputException;
	
	String encodeStringUsingStreamAndRegex(String str) throws InvalidInputException;
	
	
	
}

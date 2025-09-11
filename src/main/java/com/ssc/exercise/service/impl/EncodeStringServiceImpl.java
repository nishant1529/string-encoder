package com.ssc.exercise.service.impl;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.ssc.exercise.exception.InvalidInputException;
import com.ssc.exercise.service.EncodeStringService;

import io.micrometer.common.util.StringUtils;

@Service
public class EncodeStringServiceImpl implements EncodeStringService {

	// This method is clean and simple method without using Java Stream
	@Override
	public String encodeString(String str) throws InvalidInputException {
		StringBuilder result = new StringBuilder();
		
		int count = 1;
		if(StringUtils.isBlank(str)) {
			throw new InvalidInputException("Invalid input: " + str);
		} else {
			for (int i = 1; i <= str.length(); i++) {
	            if (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
	                count++;
	            } else {
	                result.append(str.charAt(i - 1)).append(count);
	                count = 1;
	            }
	        }
		}
		
        return result.toString();
    }
	
	//This method will use Java stream 
	//will use IntStream to define the range and then iterate each character using forEach
	@Override
	public String encodeStringUsingStream(String str) throws InvalidInputException {
		StringBuilder result = new StringBuilder();
	    
		if (StringUtils.isBlank(str)) {
			throw new InvalidInputException("Invalid input: " + str);
	    } else {
	    	IntStream.range(0, str.length())
	            .forEach(i -> {
	                if (i == 0 || str.charAt(i) != str.charAt(i - 1)) {
	                    int count = 1;
	                    while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
	                        count++;
	                        i++;
	                    }
	                    result.append(str.charAt(i)).append(count);
	                }
	        });
	    }
		
	    return result.toString();
	}
	
	// This method uses regex and stream 
	//used common.util.StringUtils
	@Override
	public String encodeStringUsingStreamAndRegex(String str) throws InvalidInputException {
		String result =  "";

		if(!StringUtils.isBlank(str)) {
			result = Arrays.stream(str.split("(?<=(.))(?!\\1)"))
	                .map(s -> s.charAt(0) + String.valueOf(s.length()))
	                .collect(Collectors.joining());
		} else {
			throw new RuntimeException(new InvalidInputException("Invalid imput : " + str));
		}
		
        return result; // a4b3c3
	}

}

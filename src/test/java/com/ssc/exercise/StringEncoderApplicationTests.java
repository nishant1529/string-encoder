package com.ssc.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssc.exercise.exception.InvalidInputException;
import com.ssc.exercise.service.EncodeStringService;

@SpringBootTest
class StringEncoderApplicationTests {

	@Autowired
	EncodeStringService encodeStringService;
	
	@Test
    void testEncodeStringWithRepetitions() {
        // Test a normal case with repeated characters
        String input = "aabcccaaa";
        String expected = "a2b1c3a3";
        Assertions.assertEquals(expected, encodeStringService.encodeString(input));
    }

    @Test
    void testEncodeStringWithNoRepetitions() {
        // Test a string with no repeating characters
        String input = "abcde";
        String expected = "a1b1c1d1e1";
        Assertions.assertEquals(expected, encodeStringService.encodeString(input));
    }

    @Test
    void testEncodeStringWithEmptyString() {
        // Test with an empty string
        String input = "";
        //String expected = "Invalid input: null";
        //Assertions.assertEquals(expected, encodeStringService.encodeString(input));
        Assertions.assertThrows(InvalidInputException.class, () -> {
        	encodeStringService.encodeString(input);
        });
    }

    @Test
    void testEncodeStringWithNull() {
        // Test with a null string
        String input = null;
        //String expected = "Invalid input: null";
        //Assertions.assertEquals(expected, encodeStringService.encodeString(input));
        
        Assertions.assertThrows(InvalidInputException.class, () -> {
        	encodeStringService.encodeString(input);
        });
    }

    @Test
    void testEncodeStringWithSingleCharacter() {
        // Test with a single character
        String input = "a";
        String expected = "a1";
        Assertions.assertEquals(expected, encodeStringService.encodeString(input));
    }
    
    @Test
    void testEncodeStringWithAllSameCharacters() {
        // Test with a string where all characters are the same
        String input = "aaaaa";
        String expected = "a5";
        Assertions.assertEquals(expected, encodeStringService.encodeString(input));
    }

}

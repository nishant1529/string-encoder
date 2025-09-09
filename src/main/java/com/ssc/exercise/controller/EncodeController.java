package com.ssc.exercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssc.exercise.dto.RequestDto;
import com.ssc.exercise.service.EncodeStringService;

@RestController
@RequestMapping("/")
public class EncodeController {

	private final EncodeStringService encodeStringService;

    public EncodeController(EncodeStringService encodeStringService) {
        this.encodeStringService = encodeStringService;
    }

    @GetMapping("/simple")
    public String stringEncoder(@RequestBody RequestDto rowString) {
        String encodedString = rowString.rowString() + " >>> encodeString >>> " + encodeStringService.encodeString(rowString.rowString());
        
        return encodedString;
    }
    
	
	@GetMapping("/stream")
	public String stringEncoderusingStream(@RequestBody RequestDto rowString) {
		String encodedString = rowString.rowString() + " >>> encodeStringUsingStream >>> " + encodeStringService.encodeStringUsingStream(rowString.rowString());
		
		return encodedString;
	}
	
	@GetMapping("/streamandregex")
	public String stringEncoderUsingStreamAndRegex(@RequestBody RequestDto rowString) {
		String encodedString = rowString.rowString() + " >>> encodeStringUsingStreamAndRegex >>> " + encodeStringService.encodeStringUsingStreamAndRegex(rowString.rowString());
		
		return encodedString;
	}
}

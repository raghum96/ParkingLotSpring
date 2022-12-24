package com.raghu.ParkingLotSpring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController {

	@GetMapping(value = "/test")
	public ResponseEntity<String> testController(){
		return ResponseEntity.ok("Bhai bhai !");
	}
		
}
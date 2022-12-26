package com.raghu.ParkingLotSpring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import com.raghu.ParkingLotSpring.service.ParkingService;

@RestController
public class ParkingController {
	
	

	@GetMapping(value = "/test")
	public ResponseEntity<String> testController(){
		return ResponseEntity.ok("Bhai bhai !");
	}
	
	
	@GetMapping(value="/getSlot")
	public ResponseEntity<ParkingBox> getSLot(){
		ParkingService parkingService = new ParkingService();
		return ResponseEntity.ok(parkingService.getNearestSlot());
	}
	
		
}
package com.raghu.ParkingLotSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import com.raghu.ParkingLotSpring.Modal.Vehicles.Car;
import com.raghu.ParkingLotSpring.Modal.Vehicles.Vehicle;
import com.raghu.ParkingLotSpring.Modal.facility.ParkingSlot;
import com.raghu.ParkingLotSpring.service.ParkingManager;
import com.raghu.ParkingLotSpring.service.ParkingService;

@RestController
public class ParkingController {
	
	@Autowired
	ParkingService parkingService;
	
	@Autowired 
	ParkingManager parkingManager;

	@GetMapping(value = "/test")
	public ResponseEntity<String> testController(){
		return ResponseEntity.ok("Bhai bhai !");
	}
	
	
	@GetMapping(value="/viewSlot")
	public ResponseEntity<ParkingBox> viewNearestSlot(){
		ParkingService parkingService = new ParkingService();
		return ResponseEntity.ok(parkingService.showNearestSlot());
	}
	
	@PostMapping(value="/park")
	public ResponseEntity<String> parkVehicleController(Vehicle v){
			
		Vehicle c= new Car(); //getfactory
		c.setRegisterationNumber(v.getRegisterationNumber());
		
		System.out.println("Got Vehicle to park "+ c.getRegisterationNumber() + c.getVehicleType());
		
		ParkingSlot parkingSlot=parkingManager.park(c);
		
		
		return ResponseEntity.ok("Park your khatara to "+ parkingSlot.getSlot().getId()+ " . Your Parking ID is "+ parkingSlot.getParkingId());
	} 
	
	@PostMapping(value="/unpark")
	public ResponseEntity<String> unParkVehicleController(int id){
		
		System.out.println("Got Vehicle to unpark with Parking Ticket no "+id);
		
		parkingManager.unParkByParkingID(id);
		
		
		return ResponseEntity.ok("take your khatara out !! Free hai mazze kar!");
	} 
	
	@GetMapping(value = "/getFees")
	public ResponseEntity<Double> getFareController(int id){
		return ResponseEntity.ok(parkingService.getFare(id));
		
	}
	
		
}
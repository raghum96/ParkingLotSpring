package com.raghu.ParkingLotSpring.service;

import org.springframework.stereotype.Service;

import com.raghu.ParkingLotSpring.Initializer;
import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import com.raghu.ParkingLotSpring.Modal.Vehicles.VehicleType;
import com.raghu.ParkingLotSpring.Modal.facility.ParkingSlot;

import static com.raghu.ParkingLotSpring.SavedData.*;

@Service
public class ParkingService {
	
	ParkingFareCalculator parkingFareCalculator;
	
	public ParkingBox getNearestSlot() {
		ParkingBox slot;
		slot = EMPTY_BOXES.poll();
		System.out.println("Got slot as : " + slot.getId());
		return slot;
	}
	
	public ParkingBox showNearestSlot() {
		ParkingBox slot; 
		slot = EMPTY_BOXES.peek();	
		return slot;
	}
	
	public double getFare(int id) {
		return PARKING_TICKETS.get(id).getFare();
	}
	
	public double fareCalulator(ParkingSlot parkingSlot) {
		VehicleType type= parkingSlot.getVehicle().getVehicleType();
		switch (type) {
		case Car:
			parkingFareCalculator= new CarFareCalculator();
			break;
		default:
			break;
		}
		
		return parkingFareCalculator.calculateFare(parkingSlot);
		
	}
}

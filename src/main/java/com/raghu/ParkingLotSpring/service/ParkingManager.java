package com.raghu.ParkingLotSpring.service;

import java.util.Date;

import com.raghu.ParkingLotSpring.Initializer;
import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import com.raghu.ParkingLotSpring.Modal.Vehicles.Vehicle;
import com.raghu.ParkingLotSpring.Modal.facility.ParkingSlot;
import com.raghu.ParkingLotSpring.service.ParkingService;

public class ParkingManager {
	
	ParkingService parkingService = new ParkingService();

	public ParkingSlot park(Vehicle vehicle) {
		
		//getSlot
		
		ParkingBox slot=parkingService.getNearestSlot();
		slot.setStatus(true);
		
		//add vehicle
		
		
		//provide slot
		ParkingSlot parkingSlot = new ParkingSlot();
		parkingSlot.setSlot(slot);
		parkingSlot.setParkingId(1);
		parkingSlot.setInTime(new Date());
		parkingSlot.setVehicle(vehicle);
		
		
		return parkingSlot;
	}
	
	public void unPark(String slotId) {

		ParkingBox slot = Initializer.GenericParking.getParkingBoxList().stream().filter(s -> s.getId().equals(slotId))
				.findFirst().orElse(null);

		slot.setStatus(false);
		Initializer.minBoxHeap.add(slot);

	}
	
}

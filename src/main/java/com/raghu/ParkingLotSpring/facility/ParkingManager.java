package com.raghu.ParkingLotSpring.facility;

import java.util.Date;

import com.raghu.ParkingLotSpring.Initializer;
import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import com.raghu.ParkingLotSpring.Modal.Vehicles.Vehicle;
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
		parkingSlot.slot=slot;
		parkingSlot.parkingId=1;
		parkingSlot.inTime=new Date();
		parkingSlot.v=vehicle;
		
		
		return parkingSlot;
	}
	
	public void unPark(String slotId) {

		ParkingBox slot = Initializer.GenericParking.getParkingBoxList().stream().filter(s -> s.getId().equals(slotId))
				.findFirst().orElse(null);

		slot.setStatus(false);
		Initializer.minBoxHeap.add(slot);

	}
	
}

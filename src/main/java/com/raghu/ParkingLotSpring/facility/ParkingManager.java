package com.raghu.ParkingLotSpring.facility;

import java.util.Date;

import com.raghu.ParkingLotSpring.Initializer;
import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import com.raghu.ParkingLotSpring.Modal.Vehicles.Vehicle;

public class ParkingManager {

	public static ParkingSlot park(Vehicle vehicle) {
		
		//getSlot
		ParkingBox slot; //get slot here
		//slot = Initializer.GenericParking.getParkingBoxList().get(1);
		slot=Initializer.minBoxHeap.poll();
		System.out.println("Got slot as : "+slot.getId());
		
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
	
	public static void unPark(String slotId) {
	
		ParkingBox slot=Initializer.GenericParking.getParkingBoxList().stream().
				filter(s->s.getId().equals(slotId)).findFirst().orElse(null);
		
		slot.setStatus(false);
		Initializer.minBoxHeap.add(slot);
		
		
	}
	
}

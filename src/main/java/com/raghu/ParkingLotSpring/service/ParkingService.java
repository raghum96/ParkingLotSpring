package com.raghu.ParkingLotSpring.service;

import com.raghu.ParkingLotSpring.Initializer;
import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;

public class ParkingService {
	public ParkingBox getNearestSlot() {
		ParkingBox slot; // get slot here
		// slot = Initializer.GenericParking.getParkingBoxList().get(1);
		slot = Initializer.minBoxHeap.poll();
		System.out.println("Got slot as : " + slot.getId());
		return slot;
	}
	
	public ParkingBox showNearestSlot() {
		ParkingBox slot; 
		slot = Initializer.minBoxHeap.peek();	
		return slot;
	}
}

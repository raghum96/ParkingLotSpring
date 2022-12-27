package com.raghu.ParkingLotSpring.service;

import org.springframework.stereotype.Service;

import com.raghu.ParkingLotSpring.Initializer;
import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import static com.raghu.ParkingLotSpring.SavedData.*;

@Service
public class ParkingService {
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
}

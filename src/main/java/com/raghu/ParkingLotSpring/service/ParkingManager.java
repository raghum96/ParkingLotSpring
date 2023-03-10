package com.raghu.ParkingLotSpring.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import com.raghu.ParkingLotSpring.Modal.Vehicles.Vehicle;
import com.raghu.ParkingLotSpring.Modal.facility.ParkingSlot;
import static com.raghu.ParkingLotSpring.SavedData.*;

@Service
public class ParkingManager {
	private static int PARKING_ID_COUNTER=1;
	
	@Autowired
	ParkingService parkingService;

	public ParkingSlot park(Vehicle vehicle) {
		
		//getSlot
		ParkingBox slot=parkingService.getNearestSlot();
		slot.setStatus(true);
		
		//add vehicle
	
		//provide slot
		ParkingSlot parkingSlot = new ParkingSlot();
		parkingSlot.setSlot(slot);
		parkingSlot.setParkingId(PARKING_ID_COUNTER++);
		parkingSlot.setInTime(new Date());
		parkingSlot.setVehicle(vehicle);
		
		//add to persistence
		PARKING_TICKETS.put(parkingSlot.getParkingId(), parkingSlot);
		
		return parkingSlot;
	}
	
	public void unParkByParkingID(int parkingId) {
		ParkingSlot parkingSlot=PARKING_TICKETS.get(parkingId);
		parkingSlot.setOutTime(new Date());
		calculateParkingFee(parkingSlot);
		
		ParkingBox box= parkingSlot.getSlot();
		box.setStatus(false);
		EMPTY_BOXES.add(box);
	
	}
	
	private void unPark(String slotId) {

		ParkingBox slot = GenericParking.getParkingBoxList().stream().filter(s -> s.getId().equals(slotId))
				.findFirst().orElse(null);
		slot.setStatus(false);
		EMPTY_BOXES.add(slot);

	}
	
	public void calculateParkingFee(ParkingSlot slot) {
		double amount=parkingService.fareCalulator(slot);
		slot.setFare(amount);
		System.out.println("Paise bange "+ amount);
	}
	
}

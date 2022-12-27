package com.raghu.ParkingLotSpring;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import com.raghu.ParkingLotSpring.Modal.Vehicles.Car;
import com.raghu.ParkingLotSpring.Modal.Vehicles.Vehicle;
import com.raghu.ParkingLotSpring.Modal.facility.ParkingSlot;
import com.raghu.ParkingLotSpring.service.ParkingManager;
import static com.raghu.ParkingLotSpring.SavedData.*;

public class Handler {
	static {
		Initializer.init();

	}
	
	ParkingManager parkingManager;
	
	public static void main(String[] args) {
		
		ParkingManager parkingManager = new ParkingManager();
		
		// get a car
		Vehicle v = new Car();
		v.setRegisterationNumber("JK08K6360");

		// car ready

		ParkingSlot s1=parkingManager.park(v);
		
		System.out.printf("Car Parked at %s with parking id %s \n",s1.getSlot().getId(),s1.getParkingId() );

		System.out.println("Empty SLot list");
		GenericParking.getParkingBoxList().stream().filter(Predicate.not(ParkingBox::getStatus))
				.forEach(s -> System.out.println(s.getId()));
		
		System.out.println("################################");
		
		ParkingSlot s2=parkingManager.park(v);
		
		System.out.printf("Car Parked at %s with parking id %s \n",s2.getSlot().getId(),s2.getParkingId() );

		System.out.println("Empty SLot list");
		GenericParking.getParkingBoxList().stream().filter(Predicate.not(ParkingBox::getStatus))
				.forEach(s -> System.out.println(s.getId()));
		
		System.out.println("################################\n unparking");

		
		parkingManager.unParkByParkingID(s1.getParkingId());
		
		System.out.println("Empty SLot list");
		GenericParking.getParkingBoxList().stream().filter(Predicate.not(ParkingBox::getStatus))
				.forEach(s -> System.out.println(s.getId()));
		

		System.out.println("################################");

		PARKING_TICKETS.values().stream().forEach(System.out::println);
		

	}
}

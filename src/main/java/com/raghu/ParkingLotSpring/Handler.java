package com.raghu.ParkingLotSpring;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import com.raghu.ParkingLotSpring.Modal.Vehicles.Car;
import com.raghu.ParkingLotSpring.Modal.Vehicles.Vehicle;
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

		parkingManager.park(v);

		System.out.println("Empty SLot list");
		GenericParking.getParkingBoxList().stream().filter(Predicate.not(ParkingBox::getStatus))
				.forEach(s -> System.out.println(s.getId()));
		
		parkingManager.park(v);

		System.out.println("Empty SLot list");
		GenericParking.getParkingBoxList().stream().filter(Predicate.not(ParkingBox::getStatus))
				.forEach(s -> System.out.println(s.getId()));
		
		parkingManager.unPark("p1a2");
		
		System.out.println("Empty SLot list");
		GenericParking.getParkingBoxList().stream().filter(Predicate.not(ParkingBox::getStatus))
				.forEach(s -> System.out.println(s.getId()));
		

	}
}

package com.raghu.ParkingLotSpring;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import com.raghu.ParkingLotSpring.Modal.Vehicles.Car;
import com.raghu.ParkingLotSpring.Modal.Vehicles.Vehicle;
import com.raghu.ParkingLotSpring.facility.ParkingManager;

public class Handler {
	static {
		Initializer.init();
	}
	
	public static void main(String[] args) {
		// get a car
		Vehicle v = new Car();
		v.setRegisterationNumber("JK08K6360");

		// car ready

		ParkingManager.park(v);

		System.out.println("Empty SLot list");
		Initializer.GenericParking.getParkingBoxList().stream().filter(Predicate.not(ParkingBox::getStatus))
				.forEach(s -> System.out.println(s.getId()));
		
		ParkingManager.park(v);

		System.out.println("Empty SLot list");
		Initializer.GenericParking.getParkingBoxList().stream().filter(Predicate.not(ParkingBox::getStatus))
				.forEach(s -> System.out.println(s.getId()));
		
		ParkingManager.unPark("p1a2");
		
		System.out.println("Empty SLot list");
		Initializer.GenericParking.getParkingBoxList().stream().filter(Predicate.not(ParkingBox::getStatus))
				.forEach(s -> System.out.println(s.getId()));
		

	}
}

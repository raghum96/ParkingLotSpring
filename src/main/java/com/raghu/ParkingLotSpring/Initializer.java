package com.raghu.ParkingLotSpring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.raghu.ParkingLotSpring.Modal.ParkingArea.SingleLevelParkingStructure;
import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import static com.raghu.ParkingLotSpring.SavedData.*;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {
	
	
	public static void init() {

		// add floors/slots to parking
		ParkingBox s1 = new ParkingBox("p1a1");
		ParkingBox s2 = new ParkingBox("p1a2");
		ParkingBox s3 = new ParkingBox("p1a3");

		List<ParkingBox> slotList = Arrays.asList(s1, s2, s3);

		// add parkings

		GenericParking = new SingleLevelParkingStructure("p1", "My Parking", "Mumbai", slotList);
		// myp.setSlots(slotList);

		// parking ready
		
		EMPTY_BOXES= new PriorityQueue<>();
		
		EMPTY_BOXES.addAll(GenericParking.getParkingBoxList());

		//init parking ticket memory
		PARKING_TICKETS= new HashMap<>();
		
		System.out.println("Parking Lot ready!!!");


	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init();
	}
		
}

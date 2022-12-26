package com.raghu.ParkingLotSpring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.raghu.ParkingLotSpring.Modal.ParkingArea.SingleLevelParkingStructure;
import com.raghu.ParkingLotSpring.Modal.ParkingArea.IParkingStructure;
import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {
	
	public static IParkingStructure GenericParking;
	public static PriorityQueue<ParkingBox> minBoxHeap;
	
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
		
		minBoxHeap= new PriorityQueue<>(new Comparator<ParkingBox>() {

			@Override
			public int compare(ParkingBox o1, ParkingBox o2) {
				// TODO Auto-generated method stub
				return o1.getId().compareTo(o2.getId());
			} 
		});
		
		minBoxHeap.addAll(GenericParking.getParkingBoxList());
		
		System.out.println("Parking Lot ready!!!");


	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init();
	}
		
}

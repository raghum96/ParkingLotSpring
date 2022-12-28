package com.raghu.ParkingLotSpring.service;

import java.util.Optional;

import com.raghu.ParkingLotSpring.Modal.facility.ParkingSlot;

public class CarFareCalculator implements ParkingFareCalculator{

	@Override
	public double calculateFare(ParkingSlot parkingSlot) {
		
		Optional<ParkingSlot> p = Optional.ofNullable(parkingSlot);
		
		if(p.isEmpty()) return 0;
		
		long minutes=(parkingSlot.getOutTime().getTime()-parkingSlot.getInTime().getTime())/(1000*60);
		
		if(minutes<=120) return 30;
		
		double extraHours= Math.ceil(((double)minutes/60)-2);		
		return (extraHours*20)+30;
		
	}

}

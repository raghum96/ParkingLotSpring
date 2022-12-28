package com.raghu.ParkingLotSpring.service;

import com.raghu.ParkingLotSpring.Modal.facility.ParkingSlot;

@FunctionalInterface
public interface ParkingFareCalculator {
	double calculateFare(ParkingSlot parkingSlot);
}

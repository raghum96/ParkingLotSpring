package com.raghu.ParkingLotSpring;

import java.util.Map;
import java.util.PriorityQueue;

import com.raghu.ParkingLotSpring.Modal.ParkingArea.IParkingStructure;
import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import com.raghu.ParkingLotSpring.Modal.facility.ParkingDetails;

public class SavedData {
	
	
	/**
	 * This will contain parking lot structure
	 */
	public static IParkingStructure GenericParking;
	
	/**
	 * This will contain all the empty parking box, it can return the nearest one as defined in comparator
	 */
	public static PriorityQueue<ParkingBox> EMPTY_BOXES;
	
	/**
	 * This contains details of parking details
	 */
	// TO DO modified to have parking tickets
	public static Map<Integer, ParkingDetails> PARKING_TICKETS;
}

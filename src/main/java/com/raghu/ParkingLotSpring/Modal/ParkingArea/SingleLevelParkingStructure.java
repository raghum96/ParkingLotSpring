package com.raghu.ParkingLotSpring.Modal.ParkingArea;

import java.util.List;

import com.raghu.ParkingLotSpring.utility.UtilityFunctions;

public final class SingleLevelParkingStructure extends ParkingStructure implements IParkingStructure {
	// single level no floors
	private final List<ParkingBox> parkingBoxList;

	@Override
	public List<ParkingBox> getParkingBoxList() {
		//return UtilityFunctions.getNewList(this.parkingBoxList);;
		return this.parkingBoxList;
	}

	public SingleLevelParkingStructure(String parkingRegistrationId, String parkingName, String parkingAddress,
			List<ParkingBox> boxList) {
		super(parkingRegistrationId, parkingName, parkingAddress);
		this.parkingBoxList = UtilityFunctions.getNewList(boxList);
	}

}

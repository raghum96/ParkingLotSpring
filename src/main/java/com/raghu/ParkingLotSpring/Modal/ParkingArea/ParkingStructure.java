package com.raghu.ParkingLotSpring.Modal.ParkingArea;

public abstract class ParkingStructure {
	private final String parkingRegistrationId;
	private final String parkingName;
	private final String parkingAddress;

	public ParkingStructure(String parkingRegistrationId, String parkingName, String parkingAddress) {
		super();
		this.parkingRegistrationId = parkingRegistrationId;
		this.parkingName = parkingName;
		this.parkingAddress = parkingAddress;

	}

	public String getParkingRegistrationId() {
		return parkingRegistrationId;
	}

	public String getParkingName() {
		return parkingName;
	}

	public String getParkingAddress() {
		return parkingAddress;
	}

}

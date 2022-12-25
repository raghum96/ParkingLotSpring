package com.raghu.ParkingLotSpring.Modal.Vehicles;

public abstract class Vehicle {
	String registerationNumber;
	VehicleType vehicleType;

	protected abstract void setType();

	public String getRegisterationNumber() {
		return registerationNumber;
	}

	public void setRegisterationNumber(String registerationNumber) {
		this.registerationNumber = registerationNumber;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

}

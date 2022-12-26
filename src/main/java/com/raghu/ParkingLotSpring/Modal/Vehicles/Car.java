package com.raghu.ParkingLotSpring.Modal.Vehicles;

public class Car extends Vehicle implements IVehicle{
	
	public Car(){
		setType();
	}

	@Override
	public void setType() {
		this.vehicleType=VehicleType.Car;		
	}

	
	

}

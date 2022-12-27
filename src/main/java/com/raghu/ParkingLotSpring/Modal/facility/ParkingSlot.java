package com.raghu.ParkingLotSpring.Modal.facility;

import java.util.Date;

import com.raghu.ParkingLotSpring.Modal.ParkingArea.ParkingBox;
import com.raghu.ParkingLotSpring.Modal.Vehicles.Vehicle;

public class ParkingSlot {
	int parkingId;
	ParkingBox slot;
	Vehicle vehicle;
	Date inTime;
	Date outTime;
	
	
	public int getParkingId() {
		return parkingId;
	}
	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}
	public ParkingBox getSlot() {
		return slot;
	}
	public void setSlot(ParkingBox slot) {
		this.slot = slot;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public Date getOutTime() {
		return outTime;
	}
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	
	
	
}

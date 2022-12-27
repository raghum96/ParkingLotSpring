package com.raghu.ParkingLotSpring.Modal.ParkingArea;

public class ParkingBox implements Comparable<ParkingBox>{
	String id;
	int floorNumber;
	boolean status;

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public ParkingBox(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	@Override
	public int compareTo(ParkingBox o) {
		return this.getId().compareTo(o.getId());
	}
}

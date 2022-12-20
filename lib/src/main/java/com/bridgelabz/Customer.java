package com.bridgelabz;

public class Customer {
	private int id;
	private Ride[] rides;

	public Customer(int id, Ride[] rides) {
		this.id = id;
		this.rides = rides;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ride[] getRides() {
		return rides;
	}

	public void setRides(Ride[] rides) {
		this.rides = rides;
	}
}

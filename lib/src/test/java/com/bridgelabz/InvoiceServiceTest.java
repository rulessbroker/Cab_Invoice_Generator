package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InvoiceServiceTest {

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateTotalFare(distance, time);
		Assertions.assertEquals(25, fare);

	}

	@Test
	public void givenLessDistanceAndTimeReturnMinFare() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateTotalFare(distance, time);
		Assertions.assertEquals(5, fare);

	}

	@Test
	public void givenMultipleRides_ShouldReturnTotalOfTotalFare() {
		Ride[] rides = { new Ride(4.0, 5), 
						 new Ride(5.0, 10),
						 new Ride(0.1, 1),
						 new Ride(20, 60) };
		InvoiceGenerator invoiceService = new InvoiceGenerator();
		double totalFare = invoiceService.calculateFareForMultipleRides(rides);
		Assertions.assertEquals(260, totalFare);
	}
	
	@Test
	public void givenMultipleRides_ShouldReturnAggregateOfTotalFare() {
		Ride[] rides = { new Ride(4.0, 5), 
						 new Ride(5.0, 10),
						 new Ride(0.1, 1),
						 new Ride(20, 60) };
		InvoiceGenerator invoiceService = new InvoiceGenerator();
		double totalFare = invoiceService.calculateFareForMultipleRides(rides);
		Assertions.assertEquals(65, totalFare/4);
		
	}

}

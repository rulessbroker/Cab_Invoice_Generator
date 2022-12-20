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
		Ride[] rides = { new Ride(4.0, 5), new Ride(5.0, 10), new Ride(0.1, 1), new Ride(20, 60) };
		InvoiceGenerator invoiceService = new InvoiceGenerator();
		double totalFare = invoiceService.calculateFareForMultipleRides(rides);
		Assertions.assertEquals(260, totalFare);

	}

	@Test
	public void givenMultipleRides_ShouldReturnAggregateOfTotalFare() {
		Ride[] rides = { new Ride(4.0, 5), new Ride(5.0, 10), new Ride(0.1, 1), new Ride(20, 60) };
		InvoiceGenerator invoiceService = new InvoiceGenerator();
		double totalFare = invoiceService.calculateFareForMultipleRides(rides);
		Assertions.assertEquals(65, totalFare / 4);

	}

	@Test
	public void givenMultipleRidesShouldReturnFareSummary() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceGenerator.invoiceSummaryCalculation(rides);
		InvoiceSummary expectedInvoicesummmary = new InvoiceSummary(2, 30.0, 30.0 / 2);
		Assertions.assertEquals(expectedInvoicesummmary, summary);

	}

	@Test
	void givenUserId_ShouldReturn_Invoice() {
		RideRepository.customerList.clear();
		Ride ride1 = new Ride(10, 6);
		Ride ride2 = new Ride(15, 8);
		Ride ride3 = new Ride(0.2, 2);
		Ride[] rides1 = new Ride[] { ride1, ride2, ride3 };
		RideRepository.customerList.add(new Customer(1, rides1));
		InvoiceGenerator obj = new InvoiceGenerator();
		double totalFare = obj.calculateFareForMultipleRides(rides1);
		InvoiceSummary actualInvoice = InvoiceService.generateInvoiceById(1);
		InvoiceSummary expectedInvoice = new InvoiceSummary(rides1.length, totalFare, totalFare / rides1.length);
		Assertions.assertEquals(expectedInvoice, actualInvoice);
	}

}

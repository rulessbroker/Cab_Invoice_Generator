package com.bridgelabz;

public class InvoiceGenerator {

	private static final double MINIMUM_COST_PER_KM = 10;
	private static final int COST_PER_TIME = 1;
	private static final double MIN_FARE = 5;

	public static double calculateFare(double distance, double time) {
		double totalFare = distance * Ride.RideCategory.NORMAL_RIDE.costPerKm
				+ time * Ride.RideCategory.NORMAL_RIDE.costPerMinute;
		if (totalFare < Ride.RideCategory.NORMAL_RIDE.minimumFarePerRide) {
			return Ride.RideCategory.NORMAL_RIDE.minimumFarePerRide;
		} else
			return totalFare;
	}

	public static double calculatePremiumFare(double distance, double time) {
		double totalFare = distance * Ride.RideCategory.PREMIUM_RIDE.costPerKm
				+ time * Ride.RideCategory.PREMIUM_RIDE.costPerMinute;
		if (totalFare < Ride.RideCategory.PREMIUM_RIDE.minimumFarePerRide) {
			return Ride.RideCategory.PREMIUM_RIDE.minimumFarePerRide;
		} else {
			return totalFare;
		}
	}

	public static double calculateTotalFare(double distance, int time) {
		double totalFare = (distance * MINIMUM_COST_PER_KM) + (time * COST_PER_TIME);
		if (totalFare < MIN_FARE)
			return MIN_FARE;
		else
			return totalFare;
	}

	public static double calculateFareForMultipleRides(Ride[] rides) {

		double totalFare = 0.0;

		for (Ride ride : rides) {
			totalFare = calculateTotalFare(ride.getDistance(), ride.getTime());
		}

		return totalFare;
	}

	public static InvoiceSummary invoiceSummaryCalculation(Ride[] rides) {
		double totalFare = 0.0;
		for (Ride ride : rides) {
			totalFare = totalFare + calculateTotalFare(ride.getDistance(), ride.getTime());
		}
		return new InvoiceSummary(rides.length, totalFare, totalFare / rides.length);
	}

	public static InvoiceSummary generateInvoice(Ride[] rides) {
		double totalFare = calculateFareForMultipleRides(rides);
		int totalNumberOfRides = rides.length;
		double averageFarePerRide = totalFare / totalNumberOfRides;
		return new InvoiceSummary(totalNumberOfRides, totalFare, averageFarePerRide);
	}

}

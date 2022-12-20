package com.bridgelabz;

import java.util.Objects;

public class InvoiceSummary {
	public final int numOfRides;
	public final double totalFare;
	public final double avgFare;

	public InvoiceSummary(int numOfRides, double totalFare, double avgFare) {
		this.numOfRides = numOfRides;
		this.totalFare = totalFare;
		this.avgFare = this.totalFare / this.numOfRides;
	}

	@Override
	public String toString() {
		return "CabInvoice{" + "TotalNumberOfRides=" + numOfRides + ", TotalFare=" + totalFare + ", AverageFarePerRide="
				+ avgFare + '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		InvoiceSummary that = (InvoiceSummary) obj;
		return numOfRides == that.numOfRides && Double.compare(that.totalFare, totalFare) == 0
				&& Double.compare(that.avgFare, avgFare) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numOfRides, totalFare, avgFare);
	}

}

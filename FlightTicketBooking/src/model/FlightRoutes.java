package model;

import java.util.List;

public class FlightRoutes {
	private int flightId;
	private String flightName;
	private int seats;
	private int unUsedSeats;
	private List<String> routes;
	private int fare;
	private int departure;
	private int arrival;

	public FlightRoutes(int flightId, String flightName, int seats, int fare, int departure, int arrival,
			List<String> routes) {
		this.flightId = flightId;
		this.flightName = flightName;
		this.seats = seats;
		this.unUsedSeats = seats;
		this.fare = fare;
		this.departure = departure;
		this.arrival = arrival;
		this.routes = routes;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public List<String> getRoutes() {
		return routes;
	}

	public void setRoutes(List<String> routes) {
		this.routes = routes;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public int getDeparture() {
		return departure;
	}

	public void setDeparture(int departure) {
		this.departure = departure;
	}

	public int getArrival() {
		return arrival;
	}

	public void setArrival(int arrival) {
		this.arrival = arrival;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getUnUsedSeats() {
		return unUsedSeats;
	}

	public void setUnUsedSeats(int unUsedSeats) {
		this.unUsedSeats = unUsedSeats;
	}

}

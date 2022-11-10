package model;

import java.util.ArrayList;
import java.util.List;

public class Bookings {
	private long pnrNo;
	private int flightId;
	private int seatsBooked;
	private String status;
	private List<Passenger> passenger;

	public Bookings(long pnrNo, int flightId, int seatsBooked, String status) {
		this.pnrNo = pnrNo;
		this.flightId = flightId;
		this.seatsBooked = seatsBooked;
		this.status = status;
		this.passenger = new ArrayList<>();
	}

	public long getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(long pnrNo) {
		this.pnrNo = pnrNo;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger.add(passenger);
	}

}

package controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Bookings;
import model.FlightRoutes;
import model.Passenger;
import repository.FlightDB;
import view.PassengerManage;

public class BookingController {
	private static long pnr = 34564777;
	private FlightDB flightDB = FlightDB.getInstance();
	private PassengerManage manage;

	public BookingController(PassengerManage manage) {
		this.manage = manage;
	}

	public Set<FlightRoutes> getAvailableFlights(String from, String to) {
		Set<FlightRoutes> answer = new HashSet<>();
		List<FlightRoutes> routeList = flightDB.getRoutesList();
		for (FlightRoutes route : routeList) {
			List<String> locations = route.getRoutes();
			int size = locations.size();
			for (int index = 0; index <= size / 2; index++) {
				if (locations.get(index).equals(from) || locations.get(index).equals(to)) {
					answer.add(route);
				}
			}
		}
		return answer;
	}

	public Passenger addPassenger(String id, String name, String dob, String gender, FlightRoutes flight) {
		if (flight.getUnUsedSeats() > 0) {
			Passenger passenger = new Passenger(Integer.valueOf(id), name, dob, gender, "CNF", flight.getFlightId());
			flightDB.setPassengerlist(passenger);
			return passenger;
		} else {
			manage.alert("Flight seats already filled");
		}
		return null;
	}

	public FlightRoutes getFlight(String flightId) {
		List<FlightRoutes> flightsList = flightDB.getRoutesList();
		for (FlightRoutes flight : flightsList) {
			if (flight.getFlightId() == Integer.valueOf(flightId)) {
				return flight;
			}
		}
		return null;
	}

	public Bookings bookTicket(FlightRoutes flight, Passenger users, int totalPassenger) {
		Bookings book = new Bookings(pnr++, flight.getFlightId(), totalPassenger, "CNF");
		flightDB.setBookingList(book);
		return book;
	}

}

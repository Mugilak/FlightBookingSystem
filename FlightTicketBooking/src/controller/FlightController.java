package controller;

import java.util.List;

import model.FlightRoutes;
import repository.FlightDB;

public class FlightController {
	private FlightDB flightDB = FlightDB.getInstance();
	private FlightRoutes route;

	public boolean isFlightsCreated() {
		if (FlightDB.getInstance().getRoutesList().size() > 0) {
			return true;
		}
		return false;
	}

	public boolean isValid(String word, String regex) {
		if (word.matches(regex)) {
			return true;
		}
		return false;
	}

	public void addFlight(String flightId, String flightName, String seats, String departure, String arrival,
			String fare, String stops, List<String> routes) {
		route = new FlightRoutes(Integer.valueOf(flightId), flightName, Integer.valueOf(seats), Integer.valueOf(fare),
				Integer.valueOf(departure), Integer.valueOf(arrival), routes);
		flightDB.setRoutesList(route);
	}

}

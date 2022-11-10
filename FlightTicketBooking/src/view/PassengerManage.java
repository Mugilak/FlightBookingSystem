package view;

import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import controller.BookingController;
import model.Bookings;
import model.FlightRoutes;
import model.Passenger;

public class PassengerManage {
	private BookingController booking;
	private Stack<Passenger> user;
	private Scanner input = new Scanner(System.in);
	private Passenger users;
	private String from, to, flightId, name, dob, id, gender;

	public PassengerManage() {
		booking = new BookingController(this);
	}

	public void initBooking() {
		procced();
	}

	private void procced() {
		System.out.println("### Plan My Journey ###");
		System.out.println("Enter From Station : ");
		from = input.nextLine();
		System.out.println("Enter To Station : ");
		to = input.nextLine();
		Set<FlightRoutes> flightsAvail = booking.getAvailableFlights(from, to);
		if (flightsAvail != null || flightsAvail.size() > 0) {
			showFlights(flightsAvail);
			System.out.println("Enter Flight no. :");
			flightId = input.nextLine();
			FlightRoutes flight = booking.getFlight(flightId);
			if (flight != null) {
				int totalPassenger = addPassenger(flight);
				bookTicket(flight, totalPassenger);
			}
		} else
			System.out.println("No flights are available right now");
	}

	private void bookTicket(FlightRoutes flight, int totalPassenger) {
		System.out.println("Total fare : " + (flight.getFare() * totalPassenger));
		System.out.println("""
				Pay :
				(1 - Pay , 2-Cancel , 3- reschedule)
				""");
		String choice = input.nextLine();
		switch (choice) {
		case "1":
			Bookings book = booking.bookTicket(flight, users, totalPassenger);
			System.out.println("Ticket(s) booked Succesfully\n PNR  no. : " + book.getPnrNo());
			break;
		case "2":
			System.out.println("Thankyou for using");
			break;
		case "3":
			System.out.println("Enter date to reschedule : ");
			String date = input.nextLine();
			System.out.println("You are data are drafted ... you can book by it later");
			break;
		default:
			System.out.println("Invalid number ");
		}
	}

	private int addPassenger(FlightRoutes flight) {
		user = new Stack<>();
		System.out.println("Enter number of Passenger : ");
		String count = input.nextLine();
		for (int i = 1; i < Integer.valueOf(count); i++) {
			getPassengerDetails();
			users = booking.addPassenger(id, name, dob, gender, flight);
			if (user != null) {
				user.push(users);
			}
		}
		return Integer.valueOf(count);
	}

	private void getPassengerDetails() {
		System.out.println("Enter Passenger Name : ");
		name = input.nextLine();
		System.out.println("enter Date of Birth : ");
		dob = input.nextLine();
		System.out.println("Enter Gender : ");
		gender = input.nextLine();
		System.out.println("Enter ID : ");
		id = input.nextLine();
	}

	private void showFlights(Set<FlightRoutes> flightsAvail) {
		System.out.println("Available Flights : \n--------------");
		for (FlightRoutes routes : flightsAvail) {
			System.out.println("Flight Id : " + routes.getFlightId() + " || Flight name: " + routes.getFlightName()
					+ " || total Seats : " + routes.getSeats() + "");
			System.out.println("Arrival : " + routes.getArrival() + " || Departure : " + routes.getDeparture()
					+ " || fare :  " + routes.getFare() + "\n\n");
		}
		System.out.println("--------------");
	}

	public void alert(String string) {
		System.out.println(string);
	}

	public void getStatus() {
		System.out.println("Enter PNR no. : ");
		String pnr = input.nextLine();
		showStatus(Long.valueOf(pnr));
	}

	private void showStatus(Long valueOf) {

	}

}

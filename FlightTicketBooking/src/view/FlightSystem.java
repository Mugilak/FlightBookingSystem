package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FlightSystem {
	private Scanner input = new Scanner(System.in);
	private CreatingFlight create;
	private PassengerManage passenger;

	FlightSystem() {
		create = new CreatingFlight();
		passenger = new PassengerManage();
	}

	public static void main(String[] args) {
		new FlightSystem().getStart();
	}

	private void getStart() {
		System.out.println("---- WELCOME TO INDIAN RAILWAYS ----");
		create.createFlight();
		proceed();
	}

	private void proceed() {
		System.out.println("Welcome to IRCTC");
		try {
			String choice = "1";
			do {
				System.out.println("""
						1. Booking
						2. View PNR Status
						3. Booked Tickets
						4. Cancel Tickets
						5. Search Passenger
						6. List Flight Routes
						---Enter choices accordingly---
						""");
				choice = input.nextLine();
				switch (choice) {
				case "1":
					passenger.initBooking();
					break;
				case "2":
					passenger.getStatus();
				}
			} while (choice != "0");
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input .. Exited");
		}

	}
}
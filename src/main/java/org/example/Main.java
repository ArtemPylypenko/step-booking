package org.example;

import org.example.booking.BookingController;
import org.example.booking.BookingService;
import org.example.booking.BookingsDAO;
import org.example.flight.FlightGenerator;
import org.example.flight.FlightService;
import org.example.flight.FlightsController;
import org.example.flight.FlightsDAO;
import org.example.users.UserService;
import org.example.users.UsersController;
import org.example.users.UsersDao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyConsoleException {
        UsersDao usersDao = new UsersDao("usersDB.txt");
        Scanner scanner = new Scanner(System.in);
        FlightsDAO flightsDao = new FlightsDAO();
        BookingsDAO bookingsDAO = new BookingsDAO("bookingsDB.txt");
        for (int i = 0; i < 50; i++) {
            flightsDao.addFlight(new FlightGenerator().generate());
        }
        MyConsoleClass consoleClass = new MyConsoleClass(new FlightsController(new FlightService(flightsDao)),
                new UsersController(new UserService(usersDao)),
                new BookingController(new BookingService(bookingsDAO)));

        boolean isActive = true;
        while (isActive) {
            consoleClass.logIn();
            int operation = 0;

            try {
                operation = Integer.parseInt(scanner.nextLine());
                if (operation < 1 || operation > 6)
                    throw new MyConsoleException("Incorrect operation");
                if (operation == 6)
                    isActive = false;
                MyConsoleClass.operations.get(operation).run();
            } catch (MyConsoleException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
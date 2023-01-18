package org.example;

import org.example.booking.Booking;
import org.example.booking.BookingController;
import org.example.flight.Flight;
import org.example.flight.FlightsController;
import org.example.users.User;
import org.example.users.UsersController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

public class MyConsoleClass {
    static HashMap<Integer, Runnable> operations = new HashMap<>();
    FlightsController flightsController;
    UsersController usersController;
    BookingController bookingController;
    User user;
    Scanner scanner;


    MyConsoleClass(FlightsController flightsController, UsersController usersController, BookingController bookingController) {
        scanner = new Scanner(System.in);
        this.flightsController = flightsController;
        this.bookingController = bookingController;
        this.usersController = usersController;
        operations.put(0, System.out::println);
        operations.put(1, () -> {
            Iterator<Flight> it = flightsController.getAllFlights().iterator();
            int count = 0;
            while (it.hasNext()) {
                System.out.println(count + " " + it.next().toString());
                count++;
            }
        });
        operations.put(2, () -> {
            System.out.println("Введите индекс рейса");
            int num = scanner.nextInt();
            try {
                if (num < 0 || num >= flightsController.getAllFlights().size())
                    throw new MyConsoleException("Incorrect input!");
                System.out.println(flightsController.getAllFlights().get(num).toString());
            } catch (MyConsoleException e) {
                System.out.println(e.getMessage());
            }
        });
        operations.put(3, () -> {
            System.out.println("Enter place to");
            String placeTo = scanner.nextLine();
            System.out.println("Enter date(format yyyy-mm-dd)");
            String date = scanner.nextLine();
            System.out.println("Enter seats you need");
            int seats = Integer.parseInt(scanner.nextLine());
            Stream<Flight> flightStream = flightsController.getAllFlights().stream().filter(flight ->
                    flight.getPlaceTo().equals(placeTo)
                            && flight.getDate().equals(date)
                            && flight.getFreeSeats() > seats
            );

            //find all flights
            Iterator<Flight> iterator = flightsController.getAllFlights().stream().filter(flight ->
                    flight.getPlaceTo().equals(placeTo)
                            && flight.getDate().equals(date)
                            && flight.getFreeSeats() > seats
            ).iterator();
            int count = 1;
            while (iterator.hasNext()) {
                System.out.println(count + " " + iterator.next().toString());
                count++;
            }

            //choose flight
            System.out.println("Choose flight to book");
            int flightIndex = Integer.parseInt(scanner.nextLine());

            if (flightIndex != 0) {
                Flight flightToBook = flightsController.getAllFlights().stream().filter(flight ->
                        flight.getPlaceTo().equals(placeTo)
                                && flight.getDate().equals(date)
                                && flight.getFreeSeats() > seats
                ).toList().get(flightIndex - 1);
                bookingController.addBooking(new Booking(user.getLogin(),
                        flightToBook.getPlaceTo(), flightToBook.getDate(), seats));
            }
        });
        operations.put(4, () -> {
            bookingController.getBookingOfUser(user.getLogin()).forEach(booking -> System.out.println(booking.toString()));
        });
        operations.put(5, () -> {
            Iterator<Booking> iterator = bookingController.getBookingOfUser(user.getLogin()).stream().iterator();
            int count = 0;
            while (iterator.hasNext()) {
                System.out.println(count + " " + iterator.next().toString());
                count++;
            }
            System.out.println("Choose book to delete");
            int bookToDelete = Integer.parseInt(scanner.nextLine());
            if (bookToDelete < 0 || bookToDelete >= bookingController.getBookingOfUser(user.getLogin()).size())
                throw new MyConsoleException("Incorrect index!");
            bookingController.deleteBooking(bookingController.getBookingOfUser(user.getLogin()).get(bookToDelete));
        });
        operations.put(6, () -> {
        });
    }

    static public void showSystem() {
        System.out.println(
                """
                        1. Онайн-табло
                        2. Посмотреть информацию о рейсе
                        3. Поиск и бронировка рейса
                        4. Мои бронирования
                        5. Отмена бронирования
                        6. Завершить сеанс""");
    }

    public void logIn() {
        if (user == null) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter login");
            String login = scanner.nextLine();

            System.out.println("Enter password");
            String password = scanner.nextLine();
            user = new User(login, password);
            if (usersController.checkUser(user)) {
                showSystem();
            } else {
                System.out.println("new user!");
                usersController.addUser(user);
                showSystem();
            }
        } else {
            showSystem();
        }
    }
}

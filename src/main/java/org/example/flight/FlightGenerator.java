package org.example.flight;

import java.util.Random;

public class FlightGenerator {
    private final String[] time = {"11:30", "12:00", "16:00", "22:40", "18:30", "04:15"};
    private final String[] from = {"Kiev", "Zaporizhzhia", "Lviv"};
    private final String[] to = {"Paris", "Budapest", "London", "Riga", "Vilnius", "Sofia", "Monaco", "Ljubljana"};
    private final String[] date = {"2023-01-15", "2023-02-10", "2023-03-08"};

    private final int[] freeSeats = {0, 30, 40, 50, 15, 25, 15, 10, 5};

    public Flight generate() {
        Random r = new Random();
        String time = this.time[r.nextInt(this.time.length)];
        String from = this.from[r.nextInt(this.from.length)];
        String to = this.to[r.nextInt(this.to.length)];
        String date = this.date[r.nextInt(this.date.length)];
        int freeSeats = this.freeSeats[r.nextInt(this.freeSeats.length)];
        return new Flight(date, time, from, to, freeSeats);
    }
}

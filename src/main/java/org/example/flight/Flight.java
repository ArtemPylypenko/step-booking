package org.example.flight;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;

public class Flight {
    private String date;
    private String time;
    private String placeFrom;
    private String placeTo;
    private int freeSeats;

    public Flight(String date, String time, String placeFrom, String placeTo, int freeSeats) {
        this.date = date;
        this.time = time;
        this.placeFrom = placeFrom;
        this.placeTo = placeTo;
        this.freeSeats = freeSeats;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPlaceFrom() {
        return placeFrom;
    }

    public String getPlaceTo() {
        return placeTo;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    @Override
    public String toString() {
        return  "Date=" + date +
                ", Time='" + time + '\'' +
                ", From='" + placeFrom + '\'' +
                ", To='" + placeTo + '\'' +
                ", Free seats=" + freeSeats ;
    }
}

package org.example.flight;

import java.util.ArrayList;
import java.util.List;

public class FlightsDAO implements FlightDao {

    List<Flight> flights;

    public FlightsDAO() {
        this.flights = new ArrayList<>();
    }

    @Override
    public List<Flight> getAllFlights() {
        return flights;
    }

    @Override
    public void addFlight(Flight f) {
        flights.add(f);
    }

    @Override
    public Flight getFlight(Integer index) {
        return flights.get(index);
    }
}

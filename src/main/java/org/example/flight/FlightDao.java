package org.example.flight;

import java.util.List;

public interface FlightDao {
    public List<Flight> getAllFlights();

    public void addFlight(Flight f);
    public Flight getFlight(Integer index);
}

package org.example.flight;

import java.util.List;

public class FlightService {
    FlightsDAO dao;

    public FlightService(FlightsDAO dao) {
        this.dao = dao;
    }

    public List<Flight> getAllFlights() {
        return dao.getAllFlights();
    }
}

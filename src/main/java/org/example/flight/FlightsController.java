package org.example.flight;

import java.util.List;

public class FlightsController {
    FlightService service;

    public FlightsController(FlightService service) {
        this.service = service;
    }

    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }

}

package org.example.flight;

import java.util.List;

public class FlightsController {
    FlightsDAO dao;
    public FlightsController(FlightsDAO dao){
        this.dao=dao;
    }
    public List<Flight> getAllFlights(){
        return dao.getAllFlights();
    }

//    public Flight getFlight(){
//
//    }
}

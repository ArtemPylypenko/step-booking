package org.example.flight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightsDAOTest {

    @Test
    void getAllFlights() {
        FlightsDAO dao = new FlightsDAO();
        Flight test1 = new Flight("test1","test1","test1","test1",1);
        Flight test2 = new Flight("test2","test2","test2","test2",2);
        dao.addFlight(test1);
        dao.addFlight(test2);
        assertEquals(test1,dao.getFlight(0));
        assertNotEquals(test1,dao.getFlight(1));
    }

    @Test
    void addFlight() {
        FlightsDAO dao = new FlightsDAO();
        Flight test1 = new Flight("test1","test1","test1","test1",1);
        Flight test2 = new Flight("test2","test2","test2","test2",2);
        dao.addFlight(test1);
        dao.addFlight(test2);
        assertEquals(test1,dao.getFlight(0));
        assertNotEquals(test1,dao.getFlight(1));
    }

    @Test
    void getFlight() {
        FlightsDAO dao = new FlightsDAO();
        Flight test1 = new Flight("test1","test1","test1","test1",1);
        Flight test2 = new Flight("test2","test2","test2","test2",2);

        dao.addFlight(test2);
        assertEquals(test1,dao.getFlight(0));
        assertNotEquals(test1,dao.getFlight(1));
    }
}
package com.ias.ejercicio_reactiva.flight_booking;

public class ExternalFlight {

    private String flightId;
    private boolean available;
    private int availableSeats;

    public ExternalFlight(String flightId, boolean available, int availableSeats) {
        this.flightId = flightId;
        this.available = available;
        this.availableSeats = availableSeats;
    }

    public String getFlightId() {
        return flightId;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}

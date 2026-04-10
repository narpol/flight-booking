package com.ias.ejercicio_reactiva.flight_booking.exception;

public class NoAvailabilityException extends RuntimeException {
    public NoAvailabilityException(String id) {
        super("No seats available for flight: " + id);
    }
}

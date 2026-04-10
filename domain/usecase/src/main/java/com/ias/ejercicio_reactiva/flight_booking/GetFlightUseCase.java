package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.exception.FlightNotFoundException;
import com.ias.ejercicio_reactiva.flight_booking.exception.NoAvailabilityException;
import com.ias.ejercicio_reactiva.flight_booking.gateway.FlightRepository;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class GetFlightUseCase {

    private final FlightRepository flightRepository;

    public GetFlightUseCase(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Mono<Flight> getFlightById(String id) {
        return flightRepository.findById(id)
                .switchIfEmpty(Mono.error(new FlightNotFoundException(id)))
                .filter(flight -> flight.getAvailableSeats() >  0)
                .switchIfEmpty(Mono.error(new NoAvailabilityException(id)))
                .delayElement(Duration.ofSeconds(2));
    }
}

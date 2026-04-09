package com.ias.ejercicio_reactiva.flight_booking;

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
                .delayElement(Duration.ofSeconds(2));
    }
}

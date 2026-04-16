package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.exception.FlightNotFoundException;
import com.ias.ejercicio_reactiva.flight_booking.ports.ExternalFlightPort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ExternalFlightAvailabilityUseCase {

    private final ExternalFlightPort externalFlightPort;

    public ExternalFlightAvailabilityUseCase(ExternalFlightPort externalFlightPort) {
        this.externalFlightPort = externalFlightPort;
    }
    public Flux<ExternalFlight> getAllFlight() {
        return externalFlightPort.getAllFlight();
    }

    public Mono<ExternalFlight> getFlightById(String flightId) {
        return externalFlightPort.getAllFlight()
                .filter(flight -> flight.getFlightId().equals(flightId))
                .next()
                .switchIfEmpty(Mono.error(new FlightNotFoundException(flightId)));
    }
}

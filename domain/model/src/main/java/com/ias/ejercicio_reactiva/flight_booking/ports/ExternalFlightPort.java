package com.ias.ejercicio_reactiva.flight_booking.ports;

import com.ias.ejercicio_reactiva.flight_booking.ExternalFlight;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ExternalFlightPort {

    //Mono<Boolean> isFlightAvailable(String flightId);

    Flux<ExternalFlight> getAllFlight();
}

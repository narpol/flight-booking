package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.gateway.FlightRepository;
import reactor.core.publisher.Mono;

public class FlightRepositoryAdapter  implements FlightRepository {

    @Override
    public Mono<Flight> findById(String id) {
        return Mono.just( new Flight(
                id,
                "Medellín",
                "Bogotá",
                100,
                20
        ));
    }
}

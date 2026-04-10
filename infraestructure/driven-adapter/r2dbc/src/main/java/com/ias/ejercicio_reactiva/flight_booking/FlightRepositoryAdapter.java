package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.gateway.FlightRepository;
import reactor.core.publisher.Mono;

public class FlightRepositoryAdapter  implements FlightRepository {

    @Override
    public Mono<Flight> findById(String id) {

        if (id.equals("1")) {
            return Mono.just( new Flight(
                    id,
                    "Medellín",
                    "Bogotá",
                    100,
                    20
            ));
        }

        if (id.equals("2")) {
            return Mono.just( new Flight(
                    id,
                    "Medellín",
                    "Cali",
                    100,
                    0
            ));
        }

        return Mono.empty();

    }
}

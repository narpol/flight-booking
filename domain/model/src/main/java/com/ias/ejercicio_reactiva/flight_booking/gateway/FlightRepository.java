package com.ias.ejercicio_reactiva.flight_booking.gateway;

import com.ias.ejercicio_reactiva.flight_booking.Flight;
import reactor.core.publisher.Mono;

public interface FlightRepository {

    Mono<Flight> findById(String id);
}

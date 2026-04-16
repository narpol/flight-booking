package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.dbo.ExternalFlightDBO;
import com.ias.ejercicio_reactiva.flight_booking.mapper.ExternalFlightDBOMapper;
import com.ias.ejercicio_reactiva.flight_booking.ports.ExternalFlightPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ExternalFlightAdapter implements ExternalFlightPort {

    private final WebClient webClient;

/*    @Override
    public Mono<Boolean> isFlightAvailable(String flightId) {
        return webClient.get()
                .uri("/c/d1e7-c949-4c89-a9e0")
                .retrieve()
                .bodyToFlux(FlightAvailabilityDBO.class)
                .filter( flight -> flight.getFlightId().equals(flightId))
                .next()
                .switchIfEmpty(Mono.error(new RuntimeException("Flight not found")))
                .map(FlightAvailabilityDBO::isAvailable);
    }*/

    @Override
    public Flux<ExternalFlight> getAllFlight() {
        return webClient.get()
                .uri("/c/d1e7-c949-4c89-a9e0")
                .retrieve()
                .bodyToFlux(ExternalFlightDBO.class)
                .map(ExternalFlightDBOMapper::toDomain);
    }
}
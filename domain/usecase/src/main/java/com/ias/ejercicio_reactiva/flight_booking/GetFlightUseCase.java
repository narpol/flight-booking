package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.exception.FlightNotFoundException;
import com.ias.ejercicio_reactiva.flight_booking.exception.NoAvailabilityException;
import com.ias.ejercicio_reactiva.flight_booking.exception.TechnicalException;
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
                .doOnError( error -> System.out.println("Technical error detected: " + error.getMessage()) )
                .onErrorMap(error -> new TechnicalException("Error to access database"))
                .switchIfEmpty(Mono.error(new FlightNotFoundException(id)))
                .filter(flight -> flight.getAvailableSeats() >  0)
                .switchIfEmpty(Mono.error(new NoAvailabilityException(id)))
                .onErrorResume( TechnicalException.class, error -> fallBackFlight(id) )
                .delayElement(Duration.ofSeconds(3));
    }

    private Mono<Flight> fallBackFlight(String id) {
        return Mono.just(new Flight(id, "N/A", "N/A", 0, 0));
    }
}

package com.ias.ejercicio_reactiva.flight_booking;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final GetFlightUseCase getFlightUseCase;

    @GetMapping("/{id}")
    public Mono<Flight> getFlightById(@PathVariable String id) {
        return getFlightUseCase.getFlightById(id);
    }


}

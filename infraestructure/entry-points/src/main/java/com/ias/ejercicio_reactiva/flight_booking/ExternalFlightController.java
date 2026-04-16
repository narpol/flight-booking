package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.dto.ExternalFlightDTO;
import com.ias.ejercicio_reactiva.flight_booking.mapper.ExternalFligthDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/external-flights")
@RequiredArgsConstructor
public class ExternalFlightController {

    private final ExternalFlightAvailabilityUseCase externalFlightAvailabilityUseCase;

    @GetMapping("/{id}")
    public Mono<ExternalFlightDTO> findFlightById(@PathVariable String id) {
        return externalFlightAvailabilityUseCase.getFlightById(id)
                .map(ExternalFligthDTOMapper::toDTO);
    }


    @GetMapping("/flights")
    public Flux<ExternalFlightDTO> findAllFlights() {
        return externalFlightAvailabilityUseCase.getAllFlight()
                .map(ExternalFligthDTOMapper::toDTO);
    }
}

package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.dto.FlightResponseDTO;
import com.ias.ejercicio_reactiva.flight_booking.mapper.FligthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final GetFlightUseCase getFlightUseCase;

    @GetMapping("/{id}")
    public Mono<ResponseEntity<FlightResponseDTO>> getFlightById(@PathVariable String id) {
        return getFlightUseCase.getFlightById(id)
                .map(FligthMapper::toDTO)
                .map(ResponseEntity::ok);
    }

    @PostMapping
    public Mono<ResponseEntity<String>> createFlight() {
        return Mono.just(ResponseEntity.ok("Flight created"));
    }
}

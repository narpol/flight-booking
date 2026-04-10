package com.ias.ejercicio_reactiva.flight_booking.dto;

import com.ias.ejercicio_reactiva.flight_booking.Flight;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightResponseDto {

    private String id;
    private String route;
    private String status;

    public static FlightResponseDto fromDomain(Flight flight) {
        return FlightResponseDto.builder()
                .id(flight.getId())
                .route(flight.getOrigin() + " - " + flight.getDestination())
                .status("Available")
                .build();
    }

}

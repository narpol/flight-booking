package com.ias.ejercicio_reactiva.flight_booking.mapper;

import com.ias.ejercicio_reactiva.flight_booking.Flight;
import com.ias.ejercicio_reactiva.flight_booking.dto.FlightResponseDto;

public class FligthMapper {

    public static FlightResponseDto toDTO(Flight flight) {
        return FlightResponseDto.builder()
                .id(flight.getId())
                .route(flight.getOrigin() + " - " + flight.getDestination())
                .status( flight.getOrigin().equals("N/A") ? "Not Available" : "Available")
                .build();
    }
}

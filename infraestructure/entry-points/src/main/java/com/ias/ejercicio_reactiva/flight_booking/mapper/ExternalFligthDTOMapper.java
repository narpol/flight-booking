package com.ias.ejercicio_reactiva.flight_booking.mapper;

import com.ias.ejercicio_reactiva.flight_booking.ExternalFlight;
import com.ias.ejercicio_reactiva.flight_booking.dto.ExternalFlightDTO;

public class ExternalFligthDTOMapper {

    public static ExternalFlight toDomain(ExternalFlightDTO dto) {
        return new ExternalFlight(dto.getFlightId(), dto.isAvailable(), dto.getAvailableSeats());
    }

    public static ExternalFlightDTO toDTO(ExternalFlight externalFlight) {
        return ExternalFlightDTO.builder()
                .flightId(externalFlight.getFlightId())
                .available(externalFlight.isAvailable())
                .availableSeats(externalFlight.getAvailableSeats())
                .build();
    }
}

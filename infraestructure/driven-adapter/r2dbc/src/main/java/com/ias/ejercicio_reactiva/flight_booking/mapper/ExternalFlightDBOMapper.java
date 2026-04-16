package com.ias.ejercicio_reactiva.flight_booking.mapper;

import com.ias.ejercicio_reactiva.flight_booking.ExternalFlight;
import com.ias.ejercicio_reactiva.flight_booking.dbo.ExternalFlightDBO;

public class ExternalFlightDBOMapper {

    public static ExternalFlight toDomain(ExternalFlightDBO dbo) {
        return new ExternalFlight(dbo.getFlightId(), dbo.isAvailable(), dbo.getAvailableSeats());
    }
}

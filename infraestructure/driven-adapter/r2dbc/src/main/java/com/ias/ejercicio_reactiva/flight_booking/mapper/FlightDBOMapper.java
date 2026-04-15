package com.ias.ejercicio_reactiva.flight_booking.mapper;

import com.ias.ejercicio_reactiva.flight_booking.Flight;
import com.ias.ejercicio_reactiva.flight_booking.dbo.FlightDBO;

public class FlightDBOMapper {

    public static Flight toDomain(FlightDBO flightDBO) {
        return new Flight(
                flightDBO.getId(),
                flightDBO.getOrigin(),
                flightDBO.getDestination(),
                flightDBO.getCapacity(),
                flightDBO.getAvailableSeats()
        );
    }

    public static FlightDBO toDBO(Flight flight) {
        return FlightDBO.builder()
                .id(flight.getId())
                .origin(flight.getOrigin())
                .destination(flight.getDestination())
                .capacity(flight.getCapacity())
                .availableSeats(flight.getAvailableSeats())
                .build();
    }
}

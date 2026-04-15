package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.dbo.FlightR2DBCRepository;
import com.ias.ejercicio_reactiva.flight_booking.exception.TechnicalException;
import com.ias.ejercicio_reactiva.flight_booking.gateway.FlightRepository;
import com.ias.ejercicio_reactiva.flight_booking.mapper.FlightDBOMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FlightRepositoryAdapter  implements FlightRepository {

    private final FlightR2DBCRepository flightR2DBCRepository;

    @Override
    public Mono<Flight> findById(String id) {

        return flightR2DBCRepository.findById(id)
                .switchIfEmpty(Mono.empty())
                .onErrorMap(error -> new TechnicalException("The item was not found."))
                .map(FlightDBOMapper::toDomain);

    }

    @Override
    public Mono<Flight> save(Flight flight) {
        return flightR2DBCRepository.save(FlightDBOMapper.toDBO(flight))
                .map(FlightDBOMapper::toDomain)
                .onErrorMap(error -> new TechnicalException("Error saving the item."));
    }


    /*@Override
    public Mono<Flight> findById(String id) {

        if( id.equals("db-error")){
            return Mono.error(new TechnicalException("Database error - conection failed"));
        }

        if (id.equals("1")) {
            return Mono.just( new Flight(
                    id,
                    "Medellín",
                    "Bogotá",
                    100,
                    20
            ));
        }

        if (id.equals("2")) {
            return Mono.just( new Flight(
                    id,
                    "Medellín",
                    "Cali",
                    100,
                    0
            ));
        }

        return Mono.empty();

    }*/
}

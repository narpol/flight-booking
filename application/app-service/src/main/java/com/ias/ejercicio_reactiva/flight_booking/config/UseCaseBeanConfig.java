package com.ias.ejercicio_reactiva.flight_booking.config;

import com.ias.ejercicio_reactiva.flight_booking.FlightRepositoryAdapter;
import com.ias.ejercicio_reactiva.flight_booking.gateway.FlightRepository;
import com.ias.ejercicio_reactiva.flight_booking.GetFlightUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public FlightRepository flightRepository() {
        return new FlightRepositoryAdapter();
    }

    @Bean
    public GetFlightUseCase getFlightUseCase(FlightRepository flightRepository) {
        return new GetFlightUseCase(flightRepository);
    }
}

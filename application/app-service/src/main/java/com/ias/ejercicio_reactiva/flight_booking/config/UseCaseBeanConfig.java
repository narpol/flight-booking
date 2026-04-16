package com.ias.ejercicio_reactiva.flight_booking.config;

import com.ias.ejercicio_reactiva.flight_booking.*;
import com.ias.ejercicio_reactiva.flight_booking.dbo.BookingR2DBCRepository;
import com.ias.ejercicio_reactiva.flight_booking.dbo.FlightR2DBCRepository;
import com.ias.ejercicio_reactiva.flight_booking.gateway.BookingRepository;
import com.ias.ejercicio_reactiva.flight_booking.gateway.FlightRepository;
import com.ias.ejercicio_reactiva.flight_booking.ports.ExternalFlightPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public FlightRepository flightRepository(FlightR2DBCRepository flightR2DBCRepository) {
        return new FlightRepositoryAdapter(flightR2DBCRepository);
    }

    @Bean
    public BookingRepository bookingRepository(BookingR2DBCRepository bookingR2DBCRepository) {
        return new BookingRepositoryAdapter(bookingR2DBCRepository);
    }

    @Bean
    public ExternalFlightPort flightAvailabilityPort(WebClient webClient) {
        return new ExternalFlightAdapter(webClient);
    }

    @Bean
    public GetFlightUseCase getFlightUseCase(FlightRepository flightRepository) {
        return new GetFlightUseCase(flightRepository);
    }

    @Bean
    public CreateBookingUseCase createBookingUseCase(FlightRepository flightRepository, BookingRepository bookingRepository) {
        return new CreateBookingUseCase(flightRepository, bookingRepository);
    }

    @Bean
    public ExternalFlightAvailabilityUseCase externalFlightAvailabilityUseCase(ExternalFlightPort externalFlightPort) {
        return new ExternalFlightAvailabilityUseCase(externalFlightPort);
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://dummyjson.com")
                .build();
    }

}

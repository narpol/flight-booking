package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.gateway.BookingRepository;
import com.ias.ejercicio_reactiva.flight_booking.gateway.FlightRepository;
import com.ias.ejercicio_reactiva.flight_booking.mapper.BookingMapper;
import org.mockito.Mockito;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.ias.ejercicio_reactiva.flight_booking")  // ⬅️ AGREGADO
/*@Configuration
@EnableWebFlux*/
public class TestBookingConfiguration {

    @Bean
    public BookingRepository bookingRepository() {
        return Mockito.mock(BookingRepository.class);
    }

    @Bean
    public FlightRepository flightRepository() {
        return Mockito.mock(FlightRepository.class);
    }

    @Bean
    public CreateBookingUseCase createBookingUseCase(
            FlightRepository flightRepository,
            BookingRepository bookingRepository) {
        return new CreateBookingUseCase(flightRepository, bookingRepository);
    }

    @Bean
    public BookingMapper bookingMapper() {
        return new BookingMapper();
    }
}
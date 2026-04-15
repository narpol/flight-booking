package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.exception.NoAvailabilityException;
import com.ias.ejercicio_reactiva.flight_booking.gateway.BookingRepository;
import com.ias.ejercicio_reactiva.flight_booking.gateway.FlightRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class CreateBookingUseCase {

    private final FlightRepository  flightRepository;
    private final BookingRepository bookingRepository;

    public CreateBookingUseCase(FlightRepository flightRepository, BookingRepository bookingRepository) {
        this.flightRepository = flightRepository;
        this.bookingRepository = bookingRepository;
    }

    public Mono<Booking> createBooking(String flightId, String passengerName) {
        return flightRepository.findById(flightId)
                .filter(flight -> flight.getAvailableSeats() > 0)
                .switchIfEmpty(Mono.error(new NoAvailabilityException("Flight " + flightId + " has no available seats")))
                .flatMap(flight -> {
                    Booking booking = new Booking(
                            null,
                            flightId,
                            passengerName
                    );

                    return bookingRepository.saveBooking(booking)
                            .flatMap(savedBooking -> {
                                flight.setAvailableSeats(flight.getAvailableSeats() - 1);
                                return flightRepository.save(flight)
                                        .thenReturn(savedBooking);
                            })
                            .flatMap( savedBooking ->
                                    emitEvent(savedBooking).thenReturn(savedBooking)
                            );
                });
    }

    private Mono<Void> emitEvent(Booking booking){
        return Mono.fromRunnable(() ->
            System.out.println("Event: Booking created " + booking.getId())
        );
    }
}

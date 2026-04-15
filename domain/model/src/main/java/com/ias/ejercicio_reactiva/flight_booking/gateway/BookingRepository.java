package com.ias.ejercicio_reactiva.flight_booking.gateway;

import com.ias.ejercicio_reactiva.flight_booking.Booking;
import reactor.core.publisher.Mono;

public interface BookingRepository {

    Mono<Booking> saveBooking(Booking booking);

}

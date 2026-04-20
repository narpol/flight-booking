package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.dbo.BookingR2DBCRepository;
import com.ias.ejercicio_reactiva.flight_booking.gateway.BookingRepository;
import com.ias.ejercicio_reactiva.flight_booking.mapper.BookingDBOMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BookingRepositoryAdapter implements BookingRepository {

    private final BookingR2DBCRepository bookingR2dbcRepository;

    @Override
    public Mono<Booking> saveBooking(Booking booking) {

        return bookingR2dbcRepository.save(BookingDBOMapper.toDBO(booking))
                .map(BookingDBOMapper::toDomain);
    }
}

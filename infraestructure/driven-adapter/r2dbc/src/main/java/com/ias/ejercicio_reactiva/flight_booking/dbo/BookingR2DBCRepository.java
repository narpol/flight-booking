package com.ias.ejercicio_reactiva.flight_booking.dbo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BookingR2DBCRepository extends ReactiveCrudRepository<BookingDBO, Long> {
}

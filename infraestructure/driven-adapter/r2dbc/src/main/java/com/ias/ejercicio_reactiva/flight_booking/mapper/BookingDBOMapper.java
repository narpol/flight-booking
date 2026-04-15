package com.ias.ejercicio_reactiva.flight_booking.mapper;

import com.ias.ejercicio_reactiva.flight_booking.Booking;
import com.ias.ejercicio_reactiva.flight_booking.dbo.BookingDBO;

public class BookingDBOMapper {

    public static Booking  toDomain(BookingDBO bookingDBO) {
        return new Booking(
            bookingDBO.getId(),
            bookingDBO.getFlightId(),
            bookingDBO.getPassengerName()
        );
    }

    public static BookingDBO toDBO(Booking booking) {
        return BookingDBO.builder()
                .id(booking.getId())
                .flightId(booking.getFlightId())
                .passengerName(booking.getPassengerName())
                .build();
    }
}

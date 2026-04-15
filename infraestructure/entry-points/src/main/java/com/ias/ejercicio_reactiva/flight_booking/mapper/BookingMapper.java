package com.ias.ejercicio_reactiva.flight_booking.mapper;

import com.ias.ejercicio_reactiva.flight_booking.Booking;
import com.ias.ejercicio_reactiva.flight_booking.dto.BookingResponseDTO;

public class BookingMapper {

    public static BookingResponseDTO toDTO(Booking booking){
        return BookingResponseDTO.builder()
                .bookingId(booking.getId())
                .flightId(booking.getFlightId())
                .passengerName(booking.getPassengerName())
                .status("CONFIRMED")
                .build();
    }
}

package com.ias.ejercicio_reactiva.flight_booking.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingResponseDTO {

    private Long bookingId;
    private String flightId;
    private String passengerName;
    private String status;

}

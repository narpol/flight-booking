package com.ias.ejercicio_reactiva.flight_booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingResponseDTO {

    private Long bookingId;
    private String flightId;
    private String passengerName;
    private String status;

}

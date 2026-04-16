package com.ias.ejercicio_reactiva.flight_booking.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExternalFlightDTO {

    private String flightId;
    private boolean available;
    private int availableSeats;

}

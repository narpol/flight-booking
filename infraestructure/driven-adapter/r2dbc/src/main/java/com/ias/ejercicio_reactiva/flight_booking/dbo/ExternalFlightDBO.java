package com.ias.ejercicio_reactiva.flight_booking.dbo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExternalFlightDBO {

    private String flightId;
    private boolean available;
    private int availableSeats;

}

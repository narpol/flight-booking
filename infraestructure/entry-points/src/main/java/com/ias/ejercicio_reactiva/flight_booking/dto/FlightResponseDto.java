package com.ias.ejercicio_reactiva.flight_booking.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlightResponseDto {

    private String id;
    private String route;
    private String status;


}

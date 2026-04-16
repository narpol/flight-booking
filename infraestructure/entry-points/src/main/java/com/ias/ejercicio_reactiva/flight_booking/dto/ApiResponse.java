package com.ias.ejercicio_reactiva.flight_booking.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse<T> {

    private T data;
    private String status;
    private String message;

}

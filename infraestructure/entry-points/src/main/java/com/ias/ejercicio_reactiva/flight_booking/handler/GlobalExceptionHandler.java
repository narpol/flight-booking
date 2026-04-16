package com.ias.ejercicio_reactiva.flight_booking.handler;


import com.ias.ejercicio_reactiva.flight_booking.dto.ApiResponse;
import com.ias.ejercicio_reactiva.flight_booking.exception.FlightNotFoundException;
import com.ias.ejercicio_reactiva.flight_booking.exception.NoAvailabilityException;
import com.ias.ejercicio_reactiva.flight_booking.exception.TechnicalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoAvailabilityException.class)
    public Mono<ResponseEntity<ApiResponse<Object>>> handleNoAvailabilityException(NoAvailabilityException ex) {
        return Mono.just(
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        ApiResponse.builder()
                                .data(null)
                                .status("ERROR")
                                .message(ex.getMessage())
                                .build()
                )
        );
    }

    @ExceptionHandler(FlightNotFoundException.class)
    public Mono<ResponseEntity<ApiResponse<Object>>> handleNotFound(FlightNotFoundException ex) {
        return Mono.just(
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        ApiResponse.builder()
                                .data(null)
                                .status("ERROR")
                                .message(ex.getMessage())
                                .build()
                )
        );
    }

    @ExceptionHandler(TechnicalException.class)
    public Mono<ResponseEntity<ApiResponse<Object>>> handleTechnical(TechnicalException ex) {
        return Mono.just(
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                        ApiResponse.builder()
                                .data(null)
                                .status("ERROR")
                                .message("Internal Server Error")
                                .build()
                )
        );
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<ApiResponse<Object>>> handleGeneric(Exception ex) {
        return Mono.just(
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                        ApiResponse.builder()
                                .data(null)
                                .status("ERROR")
                                .message("Unexpected Error")
                                .build()
                )
        );
    }


}

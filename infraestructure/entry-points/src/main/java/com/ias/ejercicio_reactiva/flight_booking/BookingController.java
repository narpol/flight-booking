package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.dto.BookingRequestDTO;
import com.ias.ejercicio_reactiva.flight_booking.dto.BookingResponseDTO;
import com.ias.ejercicio_reactiva.flight_booking.mapper.BookingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final CreateBookingUseCase createBookingUseCase;

    @PostMapping
    public Mono<ResponseEntity<BookingResponseDTO>> createBooking(@RequestBody BookingRequestDTO bookingRequestDTO){
        return createBookingUseCase.createBooking(bookingRequestDTO.getFlightId(), bookingRequestDTO.getPassengerName())
                .map(BookingMapper::toDTO)
                .map(ResponseEntity::ok);
    }
}

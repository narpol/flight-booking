package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.dto.BookingRequestDTO;
import com.ias.ejercicio_reactiva.flight_booking.dto.BookingResponseDTO;
import com.ias.ejercicio_reactiva.flight_booking.exception.NoAvailabilityException;
import com.ias.ejercicio_reactiva.flight_booking.mapper.BookingMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;


@WebFluxTest(controllers = BookingController.class)
@Import(BookingMapper.class)
@ContextConfiguration(classes = {BookingRequestDTO.class, BookingResponseDTO.class})
class BookingControllerTest {


    @Autowired
    private WebTestClient webTestClient;

    @MockitoBean
    private CreateBookingUseCase createBookingUseCase;

    @Test
    void shouldCreateBookingSuccessfully() {

        // 🔹 Arrange
        BookingRequestDTO request = new BookingRequestDTO();
        request.setFlightId("1");
        request.setPassengerName("Felipe");

        Booking booking = new Booking(1L, "1", "Felipe");


        Mockito.when(createBookingUseCase.createBooking("1", "Felipe"))
                .thenReturn(Mono.just(booking));

        // 🔹 Act & Assert
        webTestClient.post()
                .uri("/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.bookingId").isEqualTo(1)
                .jsonPath("$.flightId").isEqualTo("1")
                .jsonPath("$.passengerName").isEqualTo("Felipe")
                .jsonPath("$.status").isEqualTo("CONFIRMED");
    }

    @Test
    void shouldReturnErrorWhenNoAvailability() {

        BookingRequestDTO request = new BookingRequestDTO();
        request.setFlightId("2");
        request.setPassengerName("Felipe");

        Mockito.when(createBookingUseCase.createBooking("2", "Felipe"))
                .thenReturn(Mono.error(new NoAvailabilityException("No seats available")));

        webTestClient.post()
                .uri("/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().is4xxClientError(); // o 400 si tienes handler
    }

    @Test
    void shouldReturnValidJsonStructure() {

        Booking booking = new Booking(2L, "3", "Felipe");

        Mockito.when(createBookingUseCase.createBooking(Mockito.any(), Mockito.any()))
                .thenReturn(Mono.just(booking));

        webTestClient.post()
                .uri("/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new BookingRequestDTO("3", "Felipe"))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.bookingId").exists()
                .jsonPath("$.flightId").exists()
                .jsonPath("$.passengerName").exists()
                .jsonPath("$.status").exists();
    }

}


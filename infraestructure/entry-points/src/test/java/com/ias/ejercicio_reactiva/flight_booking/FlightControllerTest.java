package com.ias.ejercicio_reactiva.flight_booking;

import com.ias.ejercicio_reactiva.flight_booking.dto.BookingRequestDTO;
import com.ias.ejercicio_reactiva.flight_booking.exception.FlightNotFoundException;
import com.ias.ejercicio_reactiva.flight_booking.mapper.FligthMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@WebFluxTest(controllers = FlightController.class)
@Import(FligthMapper.class)
@ContextConfiguration(classes = FligthMapper.class)
class FlightControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockitoBean
    private GetFlightUseCase getFlightUseCase;

    @Test
    void shouldReturnFlightById() {

        Flight flight = new Flight("1", "BOG", "MDE", 100, 10);


        Mockito.when(getFlightUseCase.getFlightById("1"))
                .thenReturn(Mono.just(flight));

        webTestClient.get()
                .uri("/flights/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("1")
                .jsonPath("$.origin").isEqualTo("BOG")
                .jsonPath("$.destination").isEqualTo("MDE")
                .jsonPath("$.availableSeats").isEqualTo(10);
    }


    @Test
    void shouldReturnErrorWhenFlightNotFound() {

        Mockito.when(getFlightUseCase.getFlightById("99"))
                .thenReturn(Mono.error(new RuntimeException("Flight not found")));

        webTestClient.get()
                .uri("/flights/99")
                .exchange()
                .expectStatus().is5xxServerError();
    }

    @Test
    void shouldReturnNotFoundWhenFlightNotFound() {

        Mockito.when(getFlightUseCase.getFlightById("99"))
                .thenReturn(Mono.error(new FlightNotFoundException("99")));

        webTestClient.get()
                .uri("/flights/99")
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("$.status").isEqualTo("ERROR")
                .jsonPath("$.message").value(msg ->
                        ((String) msg).contains("99"));
    }

    @Test
    void shouldCreateFlight() {

        webTestClient.post()
                .uri("/flights")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("Flight created");
    }

    @Test
    void shouldReturnValidJsonStructure() {

        Flight flight = new Flight("1", "BOG", "MDE", 100, 5);


        Mockito.when(getFlightUseCase.getFlightById(Mockito.any()))
                .thenReturn(Mono.just(flight));

        webTestClient.get()
                .uri("/flights/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").exists()
                .jsonPath("$.origin").exists()
                .jsonPath("$.destination").exists()
                .jsonPath("$.availableSeats").exists();
    }

}
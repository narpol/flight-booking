package com.ias.ejercicio_reactiva.flight_booking.dbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("flight")
public class FlightDBO {

    @Id
    private String id;
    private String origin;
    private String destination;
    private Integer capacity;
    private Integer availableSeats;

}

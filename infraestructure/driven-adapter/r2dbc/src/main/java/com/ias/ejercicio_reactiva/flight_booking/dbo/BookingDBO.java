package com.ias.ejercicio_reactiva.flight_booking.dbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("booking")
//implements Persistable<String>
public class BookingDBO  {

    @Id
    private Long id;

    @Column("flight_id")
    private String flightId;

    @Column("passenger_name")
    private String passengerName;

/*    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return true;
    }*/
}

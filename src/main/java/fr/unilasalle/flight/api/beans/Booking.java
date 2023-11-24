package fr.unilasalle.flight.api.beans;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
public class Booking extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
            name = "bookings_sequence_in_java_code",
            sequenceName = "bookings_sequence",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookings_sequence_in_java_code")
    private Long id;
    @Column(unique = false, nullable = false)
    private Integer flightId;
    @Column(unique = false, nullable = false)
    private Integer passengerId;
}

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
@Table(name = "flights")
@Getter
@Setter
@NoArgsConstructor
public class Flight extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
            name = "flights_sequence_in_java_code",
            sequenceName = "flights_sequence",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flights_sequence_in_java_code")
    private Long id;
    @Column(unique = true, nullable = false)
    private String number;
    @Column(unique = false, nullable = false)
    private String origin;
    @Column(unique = false, nullable = false)
    private String destination;
    @Column(unique = false, nullable = false)
    private String departure_date;
    @Column(unique = false, nullable = false)
    private String departure_time;
    @Column(unique = false, nullable = false)
    private String arrival_date;
    @Column(unique = false, nullable = false)
    private String arrival_time;
    @Column(unique = false, nullable = false)
    private Integer plane_id;
}

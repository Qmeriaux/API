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
@Table(name = "planes")
@Getter
@Setter
@NoArgsConstructor
public class Plane extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
            name = "planes_sequence_in_java_code",
            sequenceName = "planes_sequence",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "planes_sequence_in_java_code")
    private Long id;
    @Column(unique = false, nullable = false)
    String operator;
    @Column(unique = false, nullable = false)
    String model;
    @Column(unique = true, nullable = false)
    String registration;
    @Column(unique = false, nullable = false)
    Integer capacity;
}

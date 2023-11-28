package fr.unilasalle.flight.api.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "passengers")
@Getter
@Setter
@NoArgsConstructor
public class Passenger extends PanacheEntityBase {
    @Id
    @SequenceGenerator(
            name = "passengers_sequence_in_java_code",
            sequenceName = "passengers_sequence",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passengers_sequence_in_java_code")
    private Long id;
    @Column(unique = false, nullable = false)
    private String firstname;
    @Column(unique = false, nullable = false)
    private String lastname;
    @Column(unique = false, nullable = false)
    private String email;

    @JsonIgnoreProperties("passenger")
    @OneToMany(mappedBy = "passenger", cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Booking> bookings;

}

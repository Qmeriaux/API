package fr.unilasalle.flight.api.repositories;

import fr.unilasalle.flight.api.beans.Flight;
import jakarta.enterprise.inject.Model;

import java.util.List;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;


@Model
public class FlightRepo implements PanacheRepositoryBase<Flight, Long> {
    public List<Flight> findByDestination(String destination) {
        return list("destination", destination);
    }
}

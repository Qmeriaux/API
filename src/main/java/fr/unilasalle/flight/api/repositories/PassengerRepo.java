package fr.unilasalle.flight.api.repositories;

import fr.unilasalle.flight.api.beans.Passenger;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.inject.Model;

import java.util.List;

@Model
public class PassengerRepo implements PanacheRepositoryBase<Passenger, Long> {
    public List<Passenger> findByPassengerId(Integer passengerId) {
        return list("passengerId", passengerId);
    }
}

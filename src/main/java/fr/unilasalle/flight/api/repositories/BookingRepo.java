package fr.unilasalle.flight.api.repositories;

import fr.unilasalle.flight.api.beans.Booking;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.inject.Model;

import java.util.List;

@Model
public class BookingRepo implements PanacheRepositoryBase<Booking, Long> {
    public List<Booking> findByFlightId(Integer flightId) {
        return list("flightId", flightId);
    }

    public List<Booking> findByPassengerId(Integer passengerId) {
        return list("passengerId", passengerId);
    }
}

package fr.unilasalle.flight.api.repositories;

import fr.unilasalle.flight.api.beans.Plane;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.inject.Model;

import java.util.List;

@Model
public class PlaneRepo implements PanacheRepositoryBase<Plane, Long> {
    public List<Plane> findByOperator(String operator) {
        return list("operator", operator);
    }

    public List<Plane> findByModel(String model) {
        return list("model", model);
    }

    public List<Plane> findByRegistration(String registration) {
        return list("registration", registration);
    }

    public List<Plane> findByCapacity(Integer capacity) {
        return list("capacity", capacity);
    }
}

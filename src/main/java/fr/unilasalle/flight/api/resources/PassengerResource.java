package fr.unilasalle.flight.api.resources;

import fr.unilasalle.flight.api.beans.Passenger;
import fr.unilasalle.flight.api.repositories.PassengerRepo;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/passengers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PassengerResource extends GenericResource {
    @Inject
    PassengerRepo passengerRepo;

    @GET
    public Response getPassengers(
            @QueryParam("passengerId") Integer passengerId
    ) {
        if (passengerId != null) {
            return getOr404(passengerRepo.findByPassengerId(passengerId));
        }
        return getOr404(passengerRepo.listAll());
    }

    @PUT
    @Transactional
    public Response updatePassenger(Passenger passenger) {
        // check which fields are filled and retrieve fields not filled from db
        Passenger passengerFromDb = passengerRepo.findById(passenger.getId());
        if (passenger.getFirstname() == null) {
            passenger.setFirstname(passengerFromDb.getFirstname());
        }
        if (passenger.getLastname() == null) {
            passenger.setLastname(passengerFromDb.getLastname());
        }
        if (passenger.getEmail() == null) {
            passenger.setEmail(passengerFromDb.getEmail());
        }

        passengerRepo.update("firstname = ?1, lastname = ?2, email = ?3",
                passenger.getFirstname(), passenger.getLastname(), passenger.getEmail());
        return Response.ok(passenger).status(200).build();
    }
}

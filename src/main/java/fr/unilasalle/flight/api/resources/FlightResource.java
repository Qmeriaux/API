package fr.unilasalle.flight.api.resources;

import fr.unilasalle.flight.api.beans.Flight;
import fr.unilasalle.flight.api.repositories.FlightRepo;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/flights")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlightResource extends GenericResource {
    @Inject
    FlightRepo flightRepo;

    @GET
    public Response getFlights(@QueryParam("number") String number) {
        if (number != null) {
            return getOr404(flightRepo.findByNumber(number));
        }
        return getOr404(flightRepo.listAll());
    }

    @GET
    @Path("/{id}")
public Response getFlightById(@PathParam("id") Long id) {
        return getOr404(flightRepo.findByIdOptional(id).orElse(null));
    }

    @POST
    @Transactional
    public Response createFlight(Flight flight) {
        try {
            flightRepo.persistAndFlush(flight);
            return Response.ok(flight).status(201).build();
        } catch (PersistenceException e) {
            return Response.status(400).entity(new ErrorWrapper(e.getMessage())).build();
        }
    }
}

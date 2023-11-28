package fr.unilasalle.flight.api.resources;

import fr.unilasalle.flight.api.beans.Flight;
import fr.unilasalle.flight.api.repositories.FlightRepo;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

@Path("/flights")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FlightResource extends GenericResource {
    @Inject
    FlightRepo flightRepo;

    @GET
    public Response getFlights(@QueryParam("destination") String destination) {
        if (StringUtils.isNotBlank(destination)) {
            return getOr404(flightRepo.findByDestination(destination));
        }
        return getOr404(flightRepo.listAll());
    }

    @GET
    @Path("/{id}")
    @Transactional
public Response getFlightById(@PathParam("id") Long id) {
        Flight flight = flightRepo.findByIdOptional(id).orElse(null);
        return getOr404(flight);
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

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteFlight(@PathParam("id") Long id) {
        try {
            flightRepo.deleteById(id);
            return Response.ok().status(204).build();
        } catch (PersistenceException e) {
            return Response.status(400).entity(new ErrorWrapper(e.getMessage())).build();
        }
    }
}

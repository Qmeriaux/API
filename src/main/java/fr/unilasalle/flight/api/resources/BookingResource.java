package fr.unilasalle.flight.api.resources;

import fr.unilasalle.flight.api.repositories.BookingRepo;
import jakarta.inject.Inject;
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

@Path("/bookings")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookingResource extends GenericResource {
    @Inject
    BookingRepo bookingRepo;

    @GET
    public Response getBookings(
            @QueryParam("flightId") Integer flightId
    ) {
        if (flightId != null) {
            return getOr404(bookingRepo.findByFlightId(flightId));
        }
        return getOr404(bookingRepo.listAll());
    }

    @GET
    @Path("/{id}")
    public Response getBookingById(@PathParam("id") Long id) {
        return getOr404(bookingRepo.findByIdOptional(id).orElse(null));
    }

    @POST
    @Transactional
    public Response createBooking(fr.unilasalle.flight.api.beans.Booking booking) {
        try {
            bookingRepo.persistAndFlush(booking);
            return Response.ok(booking).status(201).build();
        } catch (Exception e) {
            return Response.status(400).entity(new ErrorWrapper(e.getMessage())).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteBooking(@PathParam("id") Long id) {
        try {
            bookingRepo.deleteById(id);
            return Response.ok().status(204).build();
        } catch (Exception e) {
            return Response.status(400).entity(new ErrorWrapper(e.getMessage())).build();
        }
    }

}

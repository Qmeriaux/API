package fr.unilasalle.flight.api.resources;

import fr.unilasalle.flight.api.beans.Plane;
import fr.unilasalle.flight.api.repositories.PlaneRepo;
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
import org.apache.commons.lang3.StringUtils;

@Path("/planes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlaneResource extends GenericResource {
    @Inject
    PlaneRepo planeRepo;

    @GET
    public Response getPlanes(
            @QueryParam("operator") String operator) {
        if (StringUtils.isNotBlank(operator)) {
            return getOr404(planeRepo.findByOperator(operator));
        }
        return getOr404(planeRepo.listAll());
    }

    @GET
    @Path("/{id}")
    public Response getPlaneById(@PathParam("id") Long id) {
        return getOr404(planeRepo.findByIdOptional(id).orElse(null));
    }

    @POST
    @Transactional
    public Response createPlane(Plane plane) {
        System.out.println(plane);
        try {
            planeRepo.persistAndFlush(plane);
            return Response.ok(plane).status(201).build();
        } catch (PersistenceException e) {
            return Response.status(400).entity(new ErrorWrapper(e.getMessage())).build();
        }
    }
}

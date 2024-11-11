package com.demo.rest.application;

import com.demo.webservice.model.Studio;
import com.demo.webservice.service.StudioService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Collections;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Suchismita
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/greetings",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest"
	},
	service = Application.class
)
public class WebServicesRestApplication extends Application {

	@Reference
    private StudioService studioService;

	
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	
	@GET
	@Path("get/{studioId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudio(@PathParam("studioId") long studioId) throws PortalException {
		try {

			Studio studio = studioService.getStudio(studioId);

			if (studio == null) {
				return Response.status(Response.Status.NOT_FOUND).entity("Studio not found").build();
			}

			return Response.ok(studio).build();
		} catch (Exception e) {
			return Response.serverError().entity("Error retrieving studio: " + e.getMessage()).build();
		}
	}
	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmployee(StudioDTO studioDTO, @Context HttpServletRequest request) {
		try {
			ServiceContext serviceContext = new ServiceContext();

			Studio studio = studioService.addStudioDetails(studioDTO.getCameraName(), studioDTO.getCameraModel(),
					studioDTO.getCameraPrice(), serviceContext);
			return Response.ok(studio).build();
		} catch (Exception e) {
			return Response.serverError().entity("Error adding studio: " + e.getMessage()).build();
		}
	}
	
    @PUT
    @Path("/update/{studioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStudio(@PathParam("studioId") long studioId, StudioDTO studioDTO) {
        try {

            Studio updatedStudio = studioService.updateStudioDetails(studioId, studioDTO.getCameraName(), studioDTO.getCameraModel(), studioDTO.getCameraPrice());
            return Response.ok(updatedStudio).build();
        } catch (Exception e) {
            return Response.serverError().entity("Error updating studio: " + e.getMessage()).build();
        }
    }
	
    @DELETE
    @Path("/delete/{studioId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStudio(@PathParam("studioId") long studioId, @Context HttpServletRequest request) {
        try {
            System.out.println(studioId);
            studioService.deleteStudio(studioId);

            return Response.ok().entity("Studio deleted successfully").build();
        } catch (Exception e) {
            return Response.serverError().entity("Error deleting studio: " + e.getMessage()).build();
        }
    }
    
	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}

}
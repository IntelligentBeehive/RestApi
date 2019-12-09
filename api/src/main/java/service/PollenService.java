package service;

import com.google.gson.Gson;
import database.Database;
import database.PollenRepository;
import model.Pollen;
import model.PollenResponse;
import model.PollenResponseList;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.MalformedURLException;

/**
 * @author Hugo Mkandawire
 */
@Path("/pollen")
public class PollenService {
    private Gson gson = new Gson();
    private PollenRepository repo = new PollenRepository();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPollen(@PathParam("id") String id) {
        PollenResponse response = new PollenResponse();
        response.setOperation("getPollen");
        response.setExpression("/" + id);

        try {
            var pollenId = Integer.parseInt(id);
            var pollen = repo.getPollenById(pollenId);

            if (pollen == null) {
                response.setResult("pollen not found");
            }
            else {
                response.setResult("pollen found");
                response.setPollen(pollen);
            }
        }
        catch (IllegalArgumentException ex) {
            response.setResult("invalid value");
            ex.printStackTrace();
        }

        String output = gson.toJson(response);
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBetween(
            @Context UriInfo uriInfo,
            @QueryParam("dateFrom") String dateFrom,
            @QueryParam("dateTo") String dateTo) {
        PollenResponseList response= new PollenResponseList();
        response.setOperation("getAllBetween");
        response.setExpression("");
        try {
            var pollenMap = repo.getAllBetween(dateFrom, dateTo);
            var url = uriInfo.getBaseUri().toURL().toString();

            for (Pollen p : pollenMap.values()) {
                p.setUrl(url);
                response.addPollen(p);
            }

            if(response.getPollenList().size() < 1) {
                response.setResult("no results found");
                return Response.status(Response.Status.NO_CONTENT).build();
            }
            response.setResult("success");
        }
        catch (IllegalArgumentException | MalformedURLException ex) {
            response.setResult("invalid value");
            ex.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        String output = gson.toJson(response);
        return Response.status(Response.Status.OK).entity(output).build();
    }
}

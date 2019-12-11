package service;

import com.google.gson.Gson;
import database.PollenRepository;
import model.Pollen;
import model.PollenResponse;
import model.PollenResponseList;
import org.eclipse.jetty.util.StringUtil;

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
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBetween(
            @Context UriInfo uriInfo,
            @QueryParam("dateFrom") String dateFrom,
            @QueryParam("dateTo") String dateTo) {
        PollenResponseList response= new PollenResponseList();
        response.setOperation("getAllBetween");
        try {
            var pollenMap = StringUtil.isBlank(dateFrom) || StringUtil.isBlank(dateTo)
                    ? repo.getAll()
                    : repo.getAllBetween(dateFrom, dateTo);
            var url = uriInfo.getBaseUri().toURL().toString();

            for (Pollen p : pollenMap.values()) {
                p.setUrl(url);
                response.addPollen(p);
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

package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import database.HealthRepository;
import database.SensorRepository;
import model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.lang.reflect.Type;

@Path("/health")
public class HealthService {

    private Gson gson = new Gson();
    private HealthRepository repo = new HealthRepository();

    @GET
    @Path("/getBeeData")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBeeDate(@Context UriInfo uriInfo, @QueryParam("timeFrom") String timeFrom, @QueryParam("timeTo") String timeTo){
        var response = new BeeInfoResponse();
        try {
            if(!(!isNullOrEmpty(timeFrom) && !isNullOrEmpty(timeTo))){
                throw new IllegalArgumentException("The parameters timeFrom and timeTo are not filled!");
            }
            var beeHealthInfo = repo.getAllBetween(timeFrom, timeTo);
            var url = uriInfo.getBaseUri().toURL().toString();

            response.setBeeInfo(beeHealthInfo);

            response.setResult("success");
            return Response.ok().entity(gson.toJson(response)).build();
        } catch (Exception e) {
            response.setResult("invalid value");
            e.printStackTrace();

            return Response.status(400).entity(response).build();
        }
    }

    @PUT
    @Path("/addBeeInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBeeInfo(String beeInfo){

        if (beeInfo == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        BeeInfo beeInfoObject = gson.fromJson(beeInfo, BeeInfo.class);
        this.repo.addBeeInfo(beeInfoObject);
        return Response.ok().build();
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}

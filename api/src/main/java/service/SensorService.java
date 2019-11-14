package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import database.Database;
import model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.lang.reflect.Type;
import java.net.MalformedURLException;

@Path("/sensors")
public class SensorService {

    private Gson gson = new Gson();
    private Database database = new Database();
    private static int id = 0;

    // TODO: Basic Auth

/*    @GET
    public Response getAll(@Context UriInfo uriInfo) {
        var sensorMap = database.getAllSensors();

        SensorResponseList response = new SensorResponseList();
        response.setOperation("GetAllSensors");
        response.setExpression("/");
        try {
            try {
                var url = uriInfo.getBaseUri().toURL().toString();

                for(Sensor p: sensorMap.values()) {
                    p.setUrl(url);
                    response.addToResponseList(p);
                }

                response.setResult("success");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } catch (NumberFormatException nfe) {
            response.setResult("invalid value");
        }

        String output = gson.toJson(response);
        return Response.status(200).entity(output).build();
    }*/

    @GET
    @Path("/{type}")
    public Response getAllByType(
            @Context UriInfo uriInfo,
            @PathParam("type") String type
    ) {
        var sensorType = SensorType.valueOf(type);
        var sensorMap = database.getAllByType(sensorType);

        SensorResponseList response = new SensorResponseList();
        response.setOperation("getAllByType");
        response.setExpression("/"+type);
        try {
            try {
                var url = uriInfo.getBaseUri().toURL().toString();

                for(Sensor p: sensorMap.values()) {
                    p.setUrl(url);
                    response.addToResponseList(p);
                }

                response.setResult("success");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } catch (NumberFormatException nfe) {
            response.setResult("invalid value");
        }

        String output = gson.toJson(response);
        return Response.status(200).entity(output).build();
    }


    @GET
    @Path("/{type}/{id}")
    public Response getSensor(@PathParam("type") String type, @PathParam("id") String id) {

        SensorResponse response = new SensorResponse();
        response.setOperation("GetSensor");
        response.setExpression("/"+type+"/"+id);

        try {
            var sensorType = SensorType.valueOf(type);
            var sensorId = Integer.parseInt(id);
            var sensor = database.getSensorById(sensorType, sensorId);

            if( sensor == null) {
                response.setResult("Sensor not found");
            }
            else {
                response.setResult("Sensor found");
                response.setSensor(sensor);
            }

        } catch (NumberFormatException nfe) {
            response.setResult("invalid value");
        }

        String output = gson.toJson(response);
        return Response.status(200).entity(output).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewSensor(
            String SensorInput
    ) {
        System.out.println(SensorInput);

        Type type = new TypeToken<SensorRequest>() {}.getType();
        SensorRequest request = gson.fromJson(SensorInput, type);

        var value = request.getValue();
        var sensor = new Sensor(SensorType.CO2, value);

        if(database.insertSensor(sensor) == 0) {
            return Response.status(400).build();
        }

        String output = gson.toJson(sensor);
        return Response.status(200).entity(output).build();
    }
}

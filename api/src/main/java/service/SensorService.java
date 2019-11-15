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
        SensorResponseList response = new SensorResponseList();
        response.setOperation("getAllByType");
        response.setExpression("/"+type);
        try {
            var sensorType = SensorType.valueOf(type);
            var sensorMap = database.getAllByType(sensorType);


                var url = uriInfo.getBaseUri().toURL().toString();

                for(Sensor p: sensorMap.values()) {
                    p.setUrl(url);
                    response.addToResponseList(p);
                }

                response.setResult("success");


        } catch (NumberFormatException | MalformedURLException nfe) {
            response.setResult("invalid value");
            nfe.printStackTrace();

            return Response.status(400).entity(response).build();
        }

        String output = gson.toJson(response);
        return Response.status(200).entity(output).build();
    }


    @GET
    @Path("/{type}/{id}")
    public Response getSensor(@PathParam("type") String type, @PathParam("id") String id) {

        SensorResponse response = new SensorResponse();
        response.setOperation("getSensor");
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
    public Response insertSensor(
            @Context UriInfo uriInfo,
            String SensorInput
    ) {
        System.out.println(SensorInput);

        Type type = new TypeToken<SensorRequest>() {}.getType();
        SensorRequest request = gson.fromJson(SensorInput, type);

        SensorResponse response = new SensorResponse();
        response.setOperation("insertSensor");
        response.setExpression("POST");

        try {
            var requestType = SensorType.valueOf(request.getType());
            var requestValue = request.getValue();
            var sensor = new Sensor(requestType, requestValue);

            if(database.insertSensor(sensor) == 0) {
                response.setResult("invalid request");
                return Response.status(400).entity(response).build();
            }

            sensor.setUrl(uriInfo.getBaseUri().toURL().toString());
            response.setResult("success");
            response.setSensor(sensor);

        } catch (NumberFormatException | MalformedURLException nfe) {
            response.setResult("invalid value");
            nfe.printStackTrace();

            return Response.status(400).entity(response).build();
        }

        String output = gson.toJson(response);
        return Response.status(200).entity(output).build();
    }
}

package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

@Path("/Sensor")
public class SensorService {

    private Gson gson = new Gson();
    private static int id = 0;

    private void saveToFile(Map<Integer, Sensor> SensorMap) {
        try (FileWriter file = new FileWriter(
                "/Users/dtril/Documents/JavaProjects/battleship/seabattleserver/src/main/resources/test.json"
        )) {
            file.write(gson.toJson(SensorMap));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<Integer, Sensor> getSensorMapFromFile() {

        try {
            var file = new FileReader(
                    "/Users/dtril/Documents/JavaProjects/battleship/seabattleserver/src/main/resources/test.json"
            );

            JsonReader result = new JsonReader(file);
            Type type = new TypeToken<Map<Integer, Sensor>>(){}.getType();
            Map<Integer, Sensor> SensorMap = gson.fromJson(result, type);

            if(SensorMap != null) {
                return SensorMap;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new HashMap<>();
    }



    @GET
    public Response getAllSensors(@Context UriInfo uriInfo) {
        var SensorMap = getSensorMapFromFile();

        SensorResponseList response = new SensorResponseList();
        response.setOperation("GetAllSensors");
        response.setExpression("/");
        try {
            try {
                var url = uriInfo.getBaseUri().toURL().toString();

                for(Sensor p: SensorMap.values()) {
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
    @Path("/{id}")
    public Response getSensor(@PathParam("id") String id) {
        var SensorMap = getSensorMapFromFile();

        SensorResponse response = new SensorResponse();
        response.setOperation("GetSensor");
        response.setExpression(id);

        try {
            int value = Integer.parseInt(id);
            if(!SensorMap.containsKey(value)){
                response.setResult("Sensor not found");
            }
            else {
                var Sensor = SensorMap.get(value);
                response.setResult("Sensor found");
                response.setSensor(Sensor);
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

        var SensorMap = getSensorMapFromFile();
        var username = request.getUsername();
        var password = request.getPassword();

        if (username != null && password != null) {
            if (username.isEmpty() || password.isEmpty()) {
                return Response.status(400).build();
            }
        }
        else {
            return Response.status(400).build();
        }

        var Sensor = new Sensor(id, SensorType.CO2, username, password);

        SensorMap.put(id, Sensor);
        id++;

        saveToFile(SensorMap);

        String output = gson.toJson(Sensor);
        return Response.status(200).entity(output).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSensor(@PathParam("id") String id) {
        var SensorMap = getSensorMapFromFile();

        boolean okayResult = true;
        SensorResponse response = new SensorResponse();
        response.setOperation("DeleteSensor");
        response.setExpression(id);
        try {
            int value = Integer.parseInt(id);
            if(!SensorMap.containsKey(value)){
                okayResult = false;
                response.setResult("Sensor not found");
            }
            else {
                SensorMap.remove(value);
                response.setResult("Sensor Deleted");
            }


        } catch (NumberFormatException nfe) {
            response.setResult("invalid value");
        }

        saveToFile(SensorMap);

        String output = gson.toJson(response);
        if(okayResult) {
            return Response.status(200).entity(output).build();
        }
        return Response.status(400).entity(output).build();
    }
}

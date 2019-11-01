package server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import model.Player;
import model.PlayerResponse;
import model.PlayerResponseList;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

@Path("/player")
public class PlayerService {

    private Gson gson = new Gson();
    private static int id = 0;

    private void saveToFile(Map<Integer, Player> playerMap) {
        try (FileWriter file = new FileWriter(
        "/Users/dtril/Documents/JavaProjects/battleship/seabattleserver/src/main/resources/test.json"
        )) {
            file.write(gson.toJson(playerMap));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<Integer, Player> getPlayerMapFromFile() {

        try {
            var file = new FileReader(
            "/Users/dtril/Documents/JavaProjects/battleship/seabattleserver/src/main/resources/test.json"
            );

            JsonReader result = new JsonReader(file);
            Type type = new TypeToken<Map<Integer, Player>>(){}.getType();
            Map<Integer, Player> playerMap = gson.fromJson(result, type);

            if(playerMap != null) {
                return playerMap;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new HashMap<>();
    }



    @GET
    public Response getAllPlayers(@Context UriInfo uriInfo) {
        var playerMap = getPlayerMapFromFile();

        PlayerResponseList response = new PlayerResponseList();
        response.setOperation("GetAllPlayers");
        response.setExpression("/");
        try {
            try {
                var url = uriInfo.getBaseUri().toURL().toString();

                for(Player p: playerMap.values()) {
                    p.setUrl(url);
                    response.addToResponseList(p);
                }

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
    public Response getPlayer(@PathParam("id") String id) {
        var playerMap = getPlayerMapFromFile();

        PlayerResponse response = new PlayerResponse();
        response.setOperation("GetPlayer");
        response.setExpression(id);

        try {
            int value = Integer.parseInt(id);
            if(!playerMap.containsKey(value)){
                response.setResult("Player not found");
            }
            else {
                var player = playerMap.get(value);
                response.setResult("Player found");
                response.setPlayer(player);
            }

        } catch (NumberFormatException nfe) {
            response.setResult("invalid value");
        }

        String output = gson.toJson(response);
        return Response.status(200).entity(output).build();
    }

    @POST
    public Response addNewPlayer(
            @QueryParam("name") String name,
            @QueryParam("password") String password
    ) {
        var playerMap = getPlayerMapFromFile();

        if (name.isEmpty() || password.isEmpty()) {
            return Response.status(400).build();
        }

        var player = new Player(id, name, password);

        playerMap.put(id, player);
        id++;

        saveToFile(playerMap);

        String output = gson.toJson(player);
        return Response.status(200).entity(output).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePlayer(@PathParam("id") String id) {
        var playerMap = getPlayerMapFromFile();

        boolean okayResult = true;
        PlayerResponse response = new PlayerResponse();
        response.setOperation("DeletePlayer");
        response.setExpression(id);
        try {
            int value = Integer.parseInt(id);
            if(!playerMap.containsKey(value)){
                okayResult = false;
                response.setResult("Player not found");
            }
            else {
                playerMap.remove(value);
                response.setResult("Player Deleted");
            }


        } catch (NumberFormatException nfe) {
            response.setResult("invalid value");
        }

        saveToFile(playerMap);

        String output = gson.toJson(response);
        if(okayResult) {
            return Response.status(200).entity(output).build();
        }
        return Response.status(400).entity(output).build();
    }
}

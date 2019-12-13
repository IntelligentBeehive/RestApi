package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import database.PollenRepository;
import model.*;
import org.eclipse.jetty.util.StringUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Pollen representational state transfer service
 *
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
            } else {
                response.setResult("pollen found");
                response.setPollen(pollen);
            }
        } catch (IllegalArgumentException ex) {
            response.setResult("invalid value");
            ex.printStackTrace();
        }

        String output = gson.toJson(response);
        return Response.status(200).entity(output).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBetween(
            @Context UriInfo uriInfo,
            @QueryParam("dateFrom") String dateFrom,
            @QueryParam("dateTo") String dateTo) {
        PollenResponseList response = new PollenResponseList();
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
        } catch (IllegalArgumentException | MalformedURLException ex) {
            response.setResult("invalid value");
            ex.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        String output = gson.toJson(response);
        return Response.status(Response.Status.OK).entity(output).header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAmountDuring(@QueryParam("time") String time) {
        int amount = 0;
        try {
            LocalDate today = LocalDate.now(), firstDay = LocalDate.now();
            var timeLength = StringUtil.isNotBlank(time) ? TimeLength.valueOf(time.toUpperCase()) : TimeLength.UNKNOWN;
            switch (timeLength) {
                case DAY: // today from midnight to the end of evening
                    break;
                case WEEK: // current week from sunday to today
                    firstDay = today;
                    while (firstDay.getDayOfWeek() != DayOfWeek.SUNDAY) {
                        firstDay = firstDay.minusDays(1);
                    }
                    break;
                case MONTH: // current month from first day to today
                    firstDay = LocalDate.of(today.getYear(), today.getMonth(), 1);
                    break;
                case QUARTER: // current last 3 month from the first day to today
                    firstDay = today.minusMonths(3);
                    firstDay = LocalDate.of(firstDay.getYear(), firstDay.getMonth(), 1);
                    break;
                case YEAR: // current year from first day to today
                    firstDay = LocalDate.of(today.getYear(), 1, 1);
                    break;
                case TWO_YEARS: // from the first day of last year to today
                    firstDay = LocalDate.of(today.getYear() - 1, 1, 1);
                    break;
                case FIVE_YEARS: // from the first day of 5 years ago to today
                    firstDay = LocalDate.of(today.getYear() - 5, 1, 1);
                    break;
                default:
                    firstDay = LocalDate.MIN;
            }
            amount = repo.getAmountBetween(firstDay, today.plusDays(1));
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        String output = gson.toJson(amount);
        return Response.status(Response.Status.OK).entity(output).header("Access-Control-Allow-Origin", "*").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPollen(String post) {
        Type type = new TypeToken<PollenRequest>() {
        }.getType();
        PollenRequest request = gson.fromJson(post, type);
        PollenResponse response = new PollenResponse();
        response.setOperation("insertPollen");
        response.setExpression("POST");
        try {
            var pollen = new Pollen(request.getPlantName(), request.getHex(), request.getRgb());
            if (repo.insertPollen(pollen) == 0) {
                response.setResult("invalid request");
                return Response.status(400).entity(response).build();
            }
            response.setResult("success");
            response.setPollen(pollen);

        } catch (NumberFormatException nfe) {
            response.setResult("invalid value");
            return Response.status(400).entity(response).build();
        }
        String output = gson.toJson(response);
        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(output).build();
    }
}

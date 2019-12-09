package service;

import model.Response;
import model.WaggleDanceCountResponse;
import model.WaggleDanceLocationsResponse;
import model.WaggleDanceResult;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Path("/waggledances")
public class WaggledanceService {
    @GET
    @Path("/history")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHistory(
    ){
        var waggleDances = new ArrayList<WaggleDanceResult>();
        //strijp tq: 51.4508986 ; 5.4509588
        var day = LocalDateTime.of(LocalDate.of(2019,12, 5), LocalTime.of(9,10));
        waggleDances.add(new WaggleDanceResult(51.4208986f, 5.4409588f, "Tulpen",day.minusWeeks(1), 60*5));
        waggleDances.add(new WaggleDanceResult(51.4598986f, 5.4529588f, "Rozen",day.minusDays(1), 170));
        waggleDances.add(new WaggleDanceResult(51.4308986f, 5.4509588f, "Zonnebloem",day, 90));
        var result = new WaggleDanceLocationsResponse(waggleDances);

        return result;
    }
    @GET
    @Path("/count")
    public Response getCount(
            @QueryParam("dateFrom") String dateFrom,
            @QueryParam("dateUntil") String dateUntil
            ) {
        if(dateFrom != null) {
            var fromDate = LocalDateTime.parse(dateFrom);
        }
        if(dateUntil != null) {
            var untilDate = LocalDateTime.parse(dateUntil);
        }

        return new WaggleDanceCountResponse(5);
    }
}

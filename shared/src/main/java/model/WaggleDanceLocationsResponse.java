package model;

import java.util.List;

public class WaggleDanceLocationsResponse {

    private final List<WaggleDanceResult> waggleDanceResults;

    public WaggleDanceLocationsResponse(List<WaggleDanceResult> results){
        waggleDanceResults = results;
    }
}

package model;

import java.time.LocalDateTime;


public class WaggleDanceResult {
    private final float latitude;
    private final float longitude;
    private final String pollenType;
    private final float foodQuality;
    private final LocalDateTime date;
    private final int durationSeconds;

    public WaggleDanceResult(float latitude, float longitude, String pollenType, float foodQuality, LocalDateTime date, int durationSeconds) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.pollenType = pollenType;
        this.foodQuality = foodQuality;
        this.date = date;
        this.durationSeconds = durationSeconds;
    }
    public WaggleDanceResult(float latitude, float longitude, String pollenType, LocalDateTime date, int durationSeconds) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.pollenType = pollenType;
        this.date = date;
        this.durationSeconds = durationSeconds;
        this.foodQuality = 0.5f;
    }
}

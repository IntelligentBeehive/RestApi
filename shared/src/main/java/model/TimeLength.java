package model;

public enum TimeLength {
    DAY("day"),
    WEEK("week"),
    MONTH("month"),
    QUARTER("quarter"),
    YEAR("year"),
    TWO_YEARS("two_years"),
    FIVE_YEARS("five_years"),
    UNKNOWN("unknown");

    private String timeLength;

    TimeLength(String timeLength) {
        this.timeLength = timeLength;
    }

    public String getString() {
        return timeLength;
    }
}

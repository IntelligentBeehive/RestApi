package model;

public class BeeInfo {
    private int id;
    private String dateCreated;
    private int beeCount;
    private int broodPatternHealthyConfidence;
    private int broodPatternUnhealthyConfidence;
    private int hiveHealth;
    private String message;

    public BeeInfo(int id, String dateCreated, int beeCount, int broodPatternHealthyConfidence, int broodPatternUnhealthyConfidence, int hiveHealth, String message) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.beeCount = beeCount;
        this.broodPatternHealthyConfidence = broodPatternHealthyConfidence;
        this.broodPatternUnhealthyConfidence = broodPatternUnhealthyConfidence;
        this.hiveHealth = hiveHealth;
        this.message = message;
    }
    public BeeInfo(){

    }

    public String getDateTime() {
        return dateCreated;
    }

    public int getBeeCount() {
        return beeCount;
    }

    public int getBroodPatternHealthyConfidence() {
        return broodPatternHealthyConfidence;
    }

    public int getBroodPatternUnhealthyConfidence() {
        return broodPatternUnhealthyConfidence;
    }

    public int getHiveHealth() {
        return hiveHealth;
    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }
}

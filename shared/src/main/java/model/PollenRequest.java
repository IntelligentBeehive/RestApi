package model;

/**
 * Pollen request
 *
 * @Author Hugo Mkandawire
 */
public class PollenRequest {
    private String plantName;
    private String hex;
    private String rgb;
    private String dateCreated;

    public PollenRequest(String plantName, String hex, String rgb) {
        this.plantName = plantName;
        this.hex = hex;
        this.rgb = rgb;
        this.dateCreated = "";
    }

    public PollenRequest(){}

    public PollenRequest(String plantName, String hex, String rgb, String dateCreated) {
        this.plantName = plantName;
        this.hex = hex;
        this.rgb = rgb;
        this.dateCreated = dateCreated;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getHex() {
        return hex;
    }

    public String getRgb() {
        return rgb;
    }

    public String getDateCreated() {
        return dateCreated;
    }
}

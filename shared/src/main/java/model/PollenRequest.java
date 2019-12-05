package model;

/**
 * Pollen request
 * @Author Hugo Mkandawire
 */
public class PollenRequest {
    private String plantName;
    private String hex;
    private String rgb;

    public PollenRequest(String plantName, String hex, String rgb) {
        this.plantName = plantName;
        this.hex = hex;
        this.rgb = rgb;
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
}

package model;

/**
 * Model class Pollen
 * @author Hugo Mkandawire
 */
public class Pollen extends Model {
    private String plantName;
    private String hex;
    private String rgb;

    /**
     * Default constructor for allowing JSON Type convert
     */
    public Pollen() {}

    /**
     * Constructor with minimal parameters
     * @param plantName plant name
     * @param hex hex color code
     * @param rgb red-green-blue color code
     */
    public Pollen(String plantName, String hex, String rgb) {
        this.plantName = plantName;
        this.hex = hex;
        this.rgb = rgb;
    }

    /**
     * Constructor with maximal parameters
     * @param id identifier
     * @param plantName plant name
     * @param hex hex color code
     * @param rgb red-green-blue color code
     * @param dateCreated date of created
     */
    public Pollen(int id, String plantName, String hex, String rgb, String dateCreated) {
        this.id = id;
        this.plantName = plantName;
        this.hex = hex;
        this.rgb = rgb;
        this.dateCreated = dateCreated;
    }

    /**
     * Set url
     * @param baseUrl base url
     */
    public void setUrl(String baseUrl){
        this.url = baseUrl + "pollen/" + this.id;
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

    /**
     * Return model string
     * @return pollen string
     */
    @Override
    public String toString() {
        return String.format("Plant name: %s, Hex: %s, RGB: %s, Url: %s", plantName, hex, rgb, url);
    }
}

package model;

public class Sensor {
    private int id;
    private SensorType type;
    private String value;
    private String url;

    public Sensor() { } // Default to allow JSON Type convert

    public Sensor(int id, SensorType type, String value, String baseUrl) {
        this.id = id;
        this.type = type;
        this.value = value;
        this.setUrl(baseUrl);
    }

    public void setUrl(String baseUrl){
        this.url = baseUrl+"sensors/"+this.id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Type: %s, Value: %s Url: %s", type, value, url);
    }
}

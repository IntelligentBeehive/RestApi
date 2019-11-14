package model;

public class Sensor {
    private int id;
    private SensorType type;

    private float value;
    private String url;

    public Sensor() { } // Default to allow JSON Type convert

    public Sensor(int id, SensorType type, float value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public void setUrl(String baseUrl){
        this.url = baseUrl+"sensors/"+this.id;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public float getValue() {
        return value;
    }

    public SensorType getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Type: %s, Value: %s Url: %s", type, value, url);
    }
}
